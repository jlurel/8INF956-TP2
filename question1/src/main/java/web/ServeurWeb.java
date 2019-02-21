package web;

import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ServeurWeb {
    /**
     * @param args
     */
    public static void main(String[] args) {
        // static Logger log = Logger.getLogger(MyClass.class);
        // TODO Auto-generated method stub
        new FileSystemXmlApplicationContext( "classpath:web/httpInvoker-servlet.xml" );

    }
}
