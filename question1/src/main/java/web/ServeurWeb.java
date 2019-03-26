package web;

import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ServeurWeb {

    public static void main(String[] args) {
        // static Logger log = Logger.getLogger(MyClass.class);
        new FileSystemXmlApplicationContext( "classpath:web/ServeurWeb.xml" );

    }
}
