package M_LC0983;

public class Solution {
    //dp
    public int mincostTickets(int[] days, int[] costs) {
        if(days == null || costs == null || days.length == 0|| costs.length != 3)
            return 0;
        int[] dp = new int[366];
        //dp[i]代表截至到今年的第i天的最小花费
        dp[0] = 0;
        int today = 0;
        for(int i=1;i<=365;i++){
            //到达旅行的最后一天，直接结束
            if(today >= days.length)
                break;
            //如果当天没有旅行，直接等于上一天的消费
            if(days[today] != i){
                dp[i] = dp[i-1];
                continue;
            }
            today++;
            dp[i] = Math.min(Math.min(dp[Math.max(0,i-1)]+costs[0],
                    dp[Math.max(0, i-7)] +costs[1]), dp[Math.max(0,i-30)]+costs[2]);
        }
        return dp[days[days.length-1]];
    }
}
