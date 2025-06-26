package org.example;
import org.junit.*;
import static org.junit.Assert.*;

public class MathUtilsTest {
    private MathUtils math;
    @Before
    public void setUp(){
        math=new MathUtils();
    }
    @After
    public void tearDown(){
        math=null;
    }
    @Test
    public void addTest(){
        assertEquals(10,math.add(7,3));
    }
    @Test
    public void divideByNonZero(){
        int result=math.divide(625,5);
        assertEquals("625 / 5 = 125",125,result);
    }
    @Test(expected = ArithmeticException.class)
    public void divideByZero(){
        math.divide(10,0);
    }
}
