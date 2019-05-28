package springbasic.aspect;

public aspect MyAspect {

    pointcut logPointCut() : execution(* springbasic.aspect.Hello.hello(..));

    before() : logPointCut() {
        System.out.println("before hello");
    }

    after() : logPointCut() {
        System.out.println("after hello");
    }
}
