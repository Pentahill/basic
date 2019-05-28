package springbasic.aop.program;

import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

public class Main {
    public static void main(String[] args) {
        Hello hello = new Hello();
        AspectJProxyFactory factory = new AspectJProxyFactory(hello);
        factory.addAspect(HelloAspect.class);
        Hello hi = factory.getProxy();
        hi.hello();
    }
}
