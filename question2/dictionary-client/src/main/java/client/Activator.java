package client;

import org.osgi.framework.*;
import org.osgi.util.tracker.ServiceTracker;

import service.DictionaryService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.List;

public class Activator implements BundleActivator {
    private JFrame frame;

    private ServiceTracker mServiceTracker = null;
    private DictionaryService dictionaryService;

    public void start(final BundleContext context) throws Exception {

        mServiceTracker = new ServiceTracker(
                context,
                context.createFilter(
                "(&(objectClass=" + DictionaryService.class.getName() + ")" +
                        "(Language=*))"),
                null
        );
        mServiceTracker.open();

        installAndStartFrenchDictionary();

        //Get the selected dictionary if available
        dictionaryService = (DictionaryService) mServiceTracker.getService();

        frame = new JFrame("Dictionnaire");
        frame.setSize(400, 150);

        if (dictionaryService != null)
        {
            createUI();
        }
        else
        {
            frame.getContentPane().removeAll();
            frame.getContentPane().setLayout(new BorderLayout());
            JLabel label = new JLabel("Impossible de trouver un service de dictionnaire...");
            label.setHorizontalTextPosition(JLabel.CENTER);
            label.setVerticalTextPosition(JLabel.CENTER);
            frame.getContentPane().add(label, BorderLayout.CENTER);
            createMenu(frame);
            frame.setVisible(true);
        }
    }

    public void stop(BundleContext context) {
        destroyInterface();
    }

    private void destroyInterface() {
        frame.setVisible(false);
        frame.dispose();
    }

    private void createUI() {
        frame.getContentPane().removeAll();
        frame.getContentPane().setLayout(new BorderLayout());

        final JLabel label = new JLabel();
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.CENTER);
        frame.getContentPane().add(label, BorderLayout.CENTER);

        final JTextField textField = new JTextField();
        Action action = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String word = textField.getText();
                if (word.length() != 0) {
                    if (dictionaryService.checkWord(word))
                    {
                        label.setText("Correct.");
                    }
                    else
                    {
                        label.setText("<html>Incorrect.<br/>");

                        List<String> words = dictionaryService.getWordStartingWith(word);
                        if (!words.isEmpty()) {
                            StringBuilder availableWords = new StringBuilder("Mot(s) disponible(s) :");
                            for (String s: words) {
                                availableWords.append("<br/>").append(s);
                            }
                            label.setText(label.getText() + availableWords + "</html>");
                        }
                    }
                }
            }
        };
        textField.addActionListener(action);
        final JButton button = new JButton("Vérifier");
        button.addActionListener(action);
        createMenu(frame);
        frame.getContentPane().add(textField, BorderLayout.PAGE_START);
        frame.getContentPane().add(button, BorderLayout.PAGE_END);
        frame.setVisible(true);
    }

    private void createMenu(JFrame frame) {
        //Create menu bar
        JMenuBar menuBar = new JMenuBar();

        //Build menu
        JMenu menu = new JMenu("Services de dictionnaire");
        menu.setMnemonic(KeyEvent.VK_A);
        menu.getAccessibleContext().setAccessibleDescription(
                "Choisir un service de dictionnaire");
        menuBar.add(menu);

        //Group of menu items
        JMenuItem menuItem = new JMenuItem("Français",
                KeyEvent.VK_T);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_1, InputEvent.ALT_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription(
                "Activer le dictionnaire français");
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    installAndStartFrenchDictionary();
                } catch (BundleException e1) {
                    e1.printStackTrace();
                }
            }
        });
        menu.add(menuItem);

        menuItem = new JMenuItem("Anglais",
                KeyEvent.VK_B);
        menuItem.getAccessibleContext().setAccessibleDescription(
                "Activer le dictionnaire anglais");
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    installAndStartEnglishDictionary();
                } catch (BundleException e1) {
                    e1.printStackTrace();
                }
            }
        });
        menu.add(menuItem);

        menuBar.add(menu);
        frame.setJMenuBar(menuBar);
    }

    private void installAndStartFrenchDictionary() throws BundleException {
        BundleContext bundleContext = FrameworkUtil.getBundle(this.getClass()).getBundleContext();
        Bundle bundle = bundleContext.installBundle("file:" + System.getProperty("user.dir")
                + "/../../question2/french-dictionary/target/french-dictionary-1.0-SNAPSHOT.jar");
        bundle.start();

        Bundle englishDictionaryBundle = bundleContext.installBundle("file:" + System.getProperty("user.dir")
                + "/../../question2/english-dictionary/target/english-dictionary-1.0-SNAPSHOT.jar");
        stopBundle(englishDictionaryBundle);

        dictionaryService = (DictionaryService) mServiceTracker.getService();
    }

    private void installAndStartEnglishDictionary() throws BundleException {
        BundleContext bundleContext = FrameworkUtil.getBundle(this.getClass()).getBundleContext();
        Bundle bundle = bundleContext.installBundle("file:" + System.getProperty("user.dir")
                + "/../../question2/english-dictionary/target/english-dictionary-1.0-SNAPSHOT.jar");
        bundle.start();

        Bundle frenchDictionaryBundle = bundleContext.installBundle("file:" + System.getProperty("user.dir")
                + "/../../question2/french-dictionary/target/french-dictionary-1.0-SNAPSHOT.jar");
        stopBundle(frenchDictionaryBundle);

        dictionaryService = (DictionaryService) mServiceTracker.getService();
    }

    private void stopBundle(Bundle bundle) throws BundleException {
        if (bundle.getState() == Bundle.ACTIVE) {
            bundle.stop();
        }
    }

}
