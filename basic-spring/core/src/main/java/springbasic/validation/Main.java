package springbasic.validation;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.validation.BindException;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;


public class Main {
    public static void main(String[] args) {
//        Person p = new Person();
//        PersonValidator pv = new PersonValidator();
//        BindException be = new BindException(p, "person");
//        if(pv.supports(Person.class)) {
//            pv.validate(p, be);
//        }

        //BeanWrapper
//        BeanWrapper company = new BeanWrapperImpl(new Company());
//        company.setPropertyValue("name", "company name");
//
//        BeanWrapper jim = new BeanWrapperImpl(new Employee());
//        jim.setPropertyValue("name", "user name");
//        company.setPropertyValue("managingDirector", jim.getWrappedInstance());
//
//        System.out.println(company.getPropertyValue("managingDirector.name"));

        // spring validator
//        LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
//        validator.supports(String.class);
//        BindException ex = new BindException("hello", "hello");
//        validator.validate("hello", ex);

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("validation.xml");
    }
}
