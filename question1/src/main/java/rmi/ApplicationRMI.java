package rmi;

import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ApplicationRMI {

    public static void main(String[] args) {
        // static Logger log = Logger.getLogger(MyClass.class);
        new FileSystemXmlApplicationContext( "classpath:rmi/ViaRMI.xml" );

    }

}
