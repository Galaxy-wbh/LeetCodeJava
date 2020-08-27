package DemoRecord;

import java.util.List;
import java.util.Scanner;

public class InAndOutTemplate {
    private void test(){
        System.out.println("test");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int[] nums = new int[a];
        int i=0;
        while(a-- > 0){
            nums[i++] = sc.nextInt();
        }
        for(int n:nums)
            System.out.print(n+" ");
    }
}
