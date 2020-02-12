package boot;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    int i = 0;
    @Test
    public void testOOM() {
        List<Object> list = new ArrayList<>();
        try {
            while (true) {
                list.add(new Object());
                i++;
            }
        } catch (Exception e) {
            System.out.println(i);
            e.printStackTrace();
        }finally {
            System.out.println(i);
        }
    }
}
