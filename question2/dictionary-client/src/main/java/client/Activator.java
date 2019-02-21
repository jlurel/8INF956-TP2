package client;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import service.DictionaryService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Activator implements BundleActivator {
    private JFrame frame;

    public void start(final BundleContext context) throws Exception {
        final ServiceReference[] refs = context.getServiceReferences(
                DictionaryService.class.getName(), "(Language=*)");

        if (refs != null)
        {
            frame = new JFrame();
            frame.setSize(400, 150);
            frame.getContentPane().setLayout(new BorderLayout());
            final JTextField textField = new JTextField();
            final JLabel label = new JLabel();
            label.setHorizontalTextPosition(JLabel.CENTER);
            label.setVerticalTextPosition(JLabel.CENTER);
            frame.getContentPane().add(label, BorderLayout.CENTER);
            final JButton button = new JButton("Vérifier");
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    String word = textField.getText();
                    if (word.length() != 0) {
                        DictionaryService dictionary =
                                (DictionaryService) context.getService(refs[0]);
                        if (dictionary.checkWord(word))
                        {
                            label.setText("Correct.");
                        }
                        else
                        {
                            label.setText("<html>Incorrect.<br/>");

                            List<String> words = dictionary.getWordStartingWith(word);
                            if (!words.isEmpty()) {
                                StringBuilder availableWords = new StringBuilder("Mot(s) disponible(s) :");
                                for (String s: words) {
                                    availableWords.append("<br/>").append(s);
                                }
                                label.setText(label.getText() + availableWords + "</html>");
                            }
                        }

                        // Unget the dictionary service.
                        context.ungetService(refs[0]);
                    }
                }
            });

            frame.getContentPane().add(textField, BorderLayout.PAGE_START);
            frame.getContentPane().add(button, BorderLayout.PAGE_END);
            frame.setVisible(true);
        }
        else
        {
            frame = new JFrame("Aucun dictionnaire disponible");
            frame.setSize(400, 100);
            frame.getContentPane().setLayout(new BorderLayout());
            JLabel label = new JLabel("Impossible de trouver un service de dictionnaire...");
            label.setHorizontalTextPosition(JLabel.CENTER);
            label.setVerticalTextPosition(JLabel.CENTER);
            frame.getContentPane().add(label, BorderLayout.CENTER);
            frame.setVisible(true);
        }
    }

    public void stop(BundleContext context) throws Exception {
        destroyInterface();
    }

    private void destroyInterface() {
        frame.setVisible(false);
        frame.dispose();
    }
}
