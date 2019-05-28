package springbasic.aop;

public class AspectTest {

    public void beforeMethod() {
        System.out.println("hello aop");
    }

    public void afterMethodReturning(Object retVal) {
        System.out.println("hello method returning");
        System.out.println("return value : " + retVal);
    }

    public void monitor(Object service) {
        System.out.println("hello monitor");
    }

    public void methodException(Exception ex) {
        System.out.println("method exception");
//        ex.printStackTrace();
    }
}
