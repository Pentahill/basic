package springbasic.factorybean;

import org.springframework.beans.factory.FactoryBean;

public class FactoryBeanTest implements FactoryBean {

    @Override
    public Object getObject() throws Exception {
        return new Test();
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

}
