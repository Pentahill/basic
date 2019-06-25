package thread.active.object;

public class RealResult<T> extends Result {
    private final T resultValue;

    public RealResult(T resultValue) {
        this.resultValue = resultValue;
    }

    @Override
    public Object getResultValue() {
        return resultValue;
    }
}
