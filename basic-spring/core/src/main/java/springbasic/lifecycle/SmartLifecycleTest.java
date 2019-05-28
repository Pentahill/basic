package springbasic.lifecycle;

import org.springframework.context.SmartLifecycle;

public class SmartLifecycleTest implements SmartLifecycle {
    @Override
    public void start() {
        System.out.println("SmartLifecycleTest start");
    }

    @Override
    public void stop() {
        System.out.println("SmartLifecycleTest stop");
    }

    @Override
    public boolean isRunning() {
        return false;
    }

    @Override
    public int getPhase() {
        return 0;
    }
}
