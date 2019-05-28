package springbasic.expression;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;

import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {
//        ExpressionParser parser = new SpelExpressionParser();
//        Expression exp = parser.parseExpression("'Hello World'");
//        System.out.println(exp.getValue());
//
//        System.out.println(parser.parseExpression("'Hello World'.concat('!')").getValue());

//        GregorianCalendar c = new GregorianCalendar();
//        c.set(1856, 7, 9);
//        Inventor tesla = new Inventor("Nikola Tesla", c.getTimeInMillis(), "Serbian");
//        Expression exp = parser.parseExpression("name");
//        String name = (String)exp.getValue(tesla);
//        System.out.println(name);
//        exp = parser.parseExpression("name == 'Nikola Tesla'");
//        boolean result = exp.getValue(tesla, Boolean.class);
//        System.out.println(result);

//        Simple simple = new Simple();
//        simple.booleanList.add(true);
//        EvaluationContext context = SimpleEvaluationContext.forReadOnlyDataBinding().build();
//        parser.parseExpression("booleanList[0]").setValue(context, simple, "false");
//        System.out.println(simple.booleanList.get(0));

//        Demo demo = new Demo();
//        SpelParserConfiguration configuration = new SpelParserConfiguration(true, true);
//        ExpressionParser parser = new SpelExpressionParser(configuration);
//        Expression expression = parser.parseExpression("list[3]");
//        Object o = expression.getValue(demo);

//        ExpressionParser parser = new SpelExpressionParser();
//        boolean falseValue = parser.parseExpression(
//                "'xyz' instanceof T(Integer)").getValue(Boolean.class);
//        System.out.println(falseValue);

        SpelParserConfiguration configuration = new SpelParserConfiguration(true, true);
        ExpressionParser parser = new SpelExpressionParser(configuration);
        Inventor inventor = new Inventor();
        EvaluationContext context = SimpleEvaluationContext.forReadOnlyDataBinding().build();
        parser.parseExpression("name").setValue(context, inventor, "Aleksandar Seovic");

    }
}
