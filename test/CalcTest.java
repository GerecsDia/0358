import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalcTest {
    MainFrame mainFrame;

    @BeforeEach
    public void initEach() {
        this.mainFrame = new MainFrame();
    }

    @Test
    public void testCalcVolume1() {
        double actual = this.mainFrame.calcVolume(10, 20, 10);
        double expected = 2000;
        assertEquals(expected, actual, 0.1);
    }

    @Test
    public void testCalcVolume2() {
        double actual = this.mainFrame.calcVolume(1, 5, 5);
        double expected = 25;
        assertEquals(expected, actual, 0.1);
    }

    @Test
    public void testCalcVolume3() {
        double actual = this.mainFrame.calcVolume(1, 200, 1);
        double expected = 0.34;
        assertEquals(expected, actual, 0.1);
    }

    @Test
    public void testCalcVolume4() {
        double actual = this.mainFrame.calcVolume(600, 0, 600);
        double expected = 0;
        assertEquals(expected, actual, 0.1);
    }

   
}
