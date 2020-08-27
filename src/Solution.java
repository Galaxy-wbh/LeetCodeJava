import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();
        int k = sc.nextInt();
        int[] num = new int[10];
        for(int i=1;i<=k;i++)
            num[i-1] = i;
        List<List<Integer>> res = permute(num, k);
        for(int i=0;i<res.size();i++){
            System.out.print("[");
            for(int j=0;j<res.get(i).size();j++){
                System.out.print(res.get(i).get(j));
                if(j != res.get(i).size()-1){
                    System.out.print(",");
                }
            }
            System.out.println("],");
        }


    }
    public static List<List<Integer>> permute(int[] nums, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(res, list, nums, k);
        return res;
    }

    public static void backtrack(List<List<Integer>> res, List<Integer> list, int[] nums, int k){
        if(list.size() == k){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int num:nums){
            if(!list.contains(num)){
                list.add(num);
                backtrack(res, list, nums, k);
                list.remove(list.size()-1);
            }
        }
    }

}
