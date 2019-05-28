package springbasic.prototype;

public abstract class AbstractCommandManager {

    public void process() {
        System.out.println(createCommand().toString());
    }

    protected abstract Command createCommand();
}
