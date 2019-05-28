package springbasic.propertyeditor;

import org.springframework.beans.PropertyEditorRegistrySupport;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.beans.PropertyEditor;

public class Main {
    public static void main(String[] args) {
//        PropertyEditorRegistrySupport ps = new PropertyEditorRegistrySupport();
//        PropertyEditor pe = ps.getDefaultEditor(Integer.class);

        ApplicationContext context = new ClassPathXmlApplicationContext("propertyeditor.xml");
        Boss b = (Boss)context.getBean("boss");
    }
}
