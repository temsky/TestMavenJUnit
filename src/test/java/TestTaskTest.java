import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by me on 21.01.2019.
 */
public class TestTaskTest {
    @Test
    public void getCountStep() throws Exception {
        TestTask task = new TestTask("0 5 10 0 11 14 13 4 11 8 8 7 1 4 12 11");
        task.doIt();
        int actualStep = task.getCountStep();
        int expectedStep = 7864;
        assertEquals(expectedStep,actualStep);

    }

    @Test
    public void getLengthCycle() throws Exception {
        TestTask task = new TestTask("0 5 10 0 11 14 13 4 11 8 8 7 1 4 12 11");
        task.doIt();
        int actualLength = task.getLengthCycle();
        int expectedLength = 1695;
        assertEquals(expectedLength,actualLength);

    }
}