package springbasic.aop;

public class AopTest {

    public String hello() {
        System.out.println("hello world");

        return "hello";
    }

    public String helloThrowException() {
        throw new RuntimeException();
    }

}
