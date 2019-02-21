package rmi;

import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ApplicationRMI {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // static Logger log = Logger.getLogger(MyClass.class);
        // TODO Auto-generated method stub
        new FileSystemXmlApplicationContext( "classpath:ViaRMI.xml" );

    }

}
