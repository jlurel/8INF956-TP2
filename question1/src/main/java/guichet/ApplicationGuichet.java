package guichet;

import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ApplicationGuichet {

    public static void main(String[] args) {
        new FileSystemXmlApplicationContext( "classpath:guichet/AuGuichet.xml" );

    }

}
