import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class InputTest {
    MainFrame mainFrame;

    @BeforeEach
    public void initEach() {
        this.mainFrame = new MainFrame();
    }

    @Test
    public void testCheckInput1() {
        boolean actual = this.mainFrame.checkInput("a");
        assertFalse(actual);
    }

    @Test
    public void testCheckInput2() {
        boolean actual = this.mainFrame.checkInput("55");
        assertTrue(actual);
    }



}
    

