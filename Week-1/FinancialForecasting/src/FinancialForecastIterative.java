import java.util.*;
public class FinancialForecastIterative {
    public static double futureValueRecursive(double pv, double rate, int years) {
        if(years==0){
            return pv;
        }
        return (1+rate)* futureValueRecursive(pv,rate,years-1);
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        double pv=sc.nextDouble();
        double rate=sc.nextDouble();
        int years=sc.nextInt();
        double result=futureValueRecursive(pv,rate,years);
        System.out.printf("Future Value after %d years: $%.2f\n", years, result);
    }
}
