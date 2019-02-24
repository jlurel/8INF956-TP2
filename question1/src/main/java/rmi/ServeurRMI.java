package rmi;

import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ServeurRMI {

    public static void main(String[] args) {
        // static Logger log = Logger.getLogger(MyClass.class);
        new FileSystemXmlApplicationContext( "classpath:rmi/ServeurRMI.xml" );

    }
}
