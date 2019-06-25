package thread.active.object;

public interface ActiveObject {
    Result<String> makeString(int count, char fillchar);
    void displayString(String string);
}
