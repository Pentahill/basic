package springbasic.expression;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main2 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("expression.xml");
        NumberGuess ng = (NumberGuess)context.getBean("numberGuess");
        ShapeGuess sg = (ShapeGuess)context.getBean("shapeGuess");
    }
}
