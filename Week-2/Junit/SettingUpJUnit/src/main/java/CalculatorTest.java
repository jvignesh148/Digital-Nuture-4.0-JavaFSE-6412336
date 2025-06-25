import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {
    @Test
    public void additionTest(){
        assertEquals(5,add(2,3));
    }
    public int add(int a, int b) {
        return a + b;
    }
}
