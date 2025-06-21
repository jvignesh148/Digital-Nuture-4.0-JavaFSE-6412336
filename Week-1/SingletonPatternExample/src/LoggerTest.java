public class LoggerTest {
    public static void main(String[] args) {
        Logger log1=Logger.getInstance();
        Logger log2=Logger.getInstance();
        log1.log("Logger1 initiated");
        log2.log("Logger2 initiated");
        if(log1==log2) System.out.println("Both Loggers same.");
        else System.out.print("These Loggers are not same. They are different.");
    }
}
