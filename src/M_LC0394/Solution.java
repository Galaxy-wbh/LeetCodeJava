package M_LC0394;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public String decodeString(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        int index = 0;
        while(index < s.length()){
            char c = s.charAt(index);
            stack.push(c);
            index++;
            if(c == ']'){
                stack.pop();//弹出']'
                StringBuilder repeatStringBuilder = new StringBuilder();
                while(stack.peek()!='['){
                    repeatStringBuilder.append(stack.pop());
                }
                stack.pop();//弹出'['
                StringBuilder repeateNum = new StringBuilder();
                while(!stack.isEmpty() && stack.peek()>='0' && stack.peek()<='9'){
                    repeateNum.append(stack.pop());
                }
                int num = Integer.parseInt(repeateNum.reverse().toString());
                String sb_string = repeatStringBuilder.reverse().toString();
                while(num > 0){
                    for(int i=0;i<sb_string.length();i++)
                        stack.push(sb_string.charAt(i));
                    num--;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String s = "100[leetcode]";
        System.out.println(new Solution().decodeString(s));
    }
}
