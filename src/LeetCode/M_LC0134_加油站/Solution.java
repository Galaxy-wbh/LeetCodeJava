package LeetCode.M_LC0134_加油站;

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        for(int i=0;i<len;i++){
            if(check(gas, cost, i)){
                return i;
            }
        }
        return -1;
    }
    public boolean check(int[] gas, int[] cost, int k){
        boolean res = true;
        int gasInTank = 0;
        int pos = k;
        do{
            gasInTank += gas[pos%gas.length];
            if(gasInTank<cost[pos%gas.length]){
                res = false;
                break;
            }
            gasInTank-=cost[pos%gas.length];
            pos++;
        }while(pos%gas.length != k);
        return res;
    }

    public static void main(String[] args) {
        int[] gas = {3,3,4};
        int[] cost = {3,4,4};
        new Solution().canCompleteCircuit(gas, cost);
    }
}
