package springbasic.aop;

public class DefaultFooService implements FooService {
    @Override
    public String getFoo(String fooName, int age) {
        return "hello";
    }
}
