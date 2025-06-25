import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int size=sc.nextInt();
        int[] nums=new int[size];
        for(int i=0;i<size;i++) nums[i]=sc.nextInt();
        sc.close();
        int count=0;
        for(int i=0;i<size;i++){
            int sum=0; 
            for(int j=i;j<size;j++){
                sum+=nums[j];
                if(sum<0) count+=1;
            }
        }
        System.out.println(count);
    }
}
