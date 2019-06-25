package thread.active.object;

public class Servant implements ActiveObject {

    @Override
    public Result<String> makeString(int count, char fillchar) {
        char[] buffer = new char[count];
        for(int i = 0; i < count; i++) {
            buffer[i] = fillchar;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
                // TODO
            }
        }

        return new RealResult<String>(new String(buffer));
    }

    @Override
    public void displayString(String string) {
        System.out.println("displayString: " + string);
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
            // TODO
        }
    }
}