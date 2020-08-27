package NewCoderContest.Contest20200709;

public class Solution1 {
    public String change (String s) {
        // write code here
        int length = s.length();
        char[] array = new char[length];
        int size = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c != 'a') {
                array[size++] = c;
            }
        }
        for(int i=size;i<length;i++){
            array[size++] = 'a';
        }
        return new String(array);

    }


    public static void main(String[] args) {
        String test = "abcavv";
        System.out.println(new Solution1().change(test));
    }
}
