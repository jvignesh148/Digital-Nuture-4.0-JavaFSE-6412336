import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {
    private final Calculator cal=new Calculator();

    @Test
    public void testSquare(){
        assertEquals("Square values:",25,cal.square(5));
    }

    @Test
    public void testConcat(){
        assertEquals("VigneshJagadeesan",cal.concat("Vignesh","Jagadeesan"));
    }
}
