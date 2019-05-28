package springbasic.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.core.Ordered;
import sun.reflect.annotation.ExceptionProxy;

public class ConcurrentOperationExecutor implements Ordered {

    private static final int DEFAULT_MAX_RETRIES = 2;

    private int maxRetries = DEFAULT_MAX_RETRIES;

    private int order = 1;

    public void setMaxRetries(int maxRetries) {
        this.maxRetries = maxRetries;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @Override
    public int getOrder() {
        return this.order;
    }

    public Object doConcurrentOperation(ProceedingJoinPoint pjp) throws Throwable {
        int numAttempts = 0;
        Exception ex;
        do {
            numAttempts++;
            try{
                return pjp.proceed();
            }catch (Exception e) {
                ex = e;
            }
        }while(numAttempts <= this.maxRetries);

        throw ex;
    }

}
