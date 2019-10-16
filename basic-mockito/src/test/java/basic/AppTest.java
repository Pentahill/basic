package basic;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import org.junit.Test;

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

    @Test
    public void testMock() {
        List mockedList = mock(List.class);
        mockedList.add("one");
        mockedList.clear();

//        verify(mockedList).add("one");
//        verify(mockedList).clear();

//        when(mockedList.get(0)).thenReturn("first");
//        when(mockedList.get(1)).thenThrow(new RuntimeException());
//        System.out.println(mockedList.get(0));
//        System.out.println(mockedList.get(1));
//        System.out.println(mockedList.get(99));
//
//        verify(mockedList).get(0);

        when(mockedList.get(anyInt())).thenReturn("element");
        when(mockedList.contains(argThat(someString -> someString.length() > 5))).thenReturn("element");
    }
}
