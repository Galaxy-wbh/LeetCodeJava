package NewCoderContest.Contest20200711;

public class Solution1 {

    public String Orderofpoker (String x) {
        int cardNum = x.length()/2;
        int[] prime = {2,3,5,7};
        int start = 0, end = x.length()-1;
        StringBuilder sb = new StringBuilder();
        boolean isPrime = false;
        while(start < end){
            int curNum = (end-start+1)/2;
            for(int i=0;i<4;i++){
                if(curNum == prime[i]){
                    isPrime = true;
                    break;
                }
            }
            if(isPrime){
                sb.append(x.charAt(start++));
                sb.append(x.charAt(start++));
                isPrime = false;
            }
            else{
                end -= 2;
                sb.append(x.charAt(end+1));
                sb.append(x.charAt(end+2));
            }


        }
        return sb.toString();
    }

    public static void main(String[] args) {

        Solution1 s1 = new Solution1();
        System.out.println(s1.Orderofpoker("3C8D6H3D"));
    }
}
