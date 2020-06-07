package LeetCode.H_LC0126_单词接龙_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

    //此解法超时
public class Solution {
    int minLength = Integer.MAX_VALUE;
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        //wordList中不包含endWord
        if (!wordList.contains(endWord))
            return res;
        //回溯法
        List<String> list = new ArrayList<>();
        list.add(beginWord);
        backtrack(beginWord, beginWord, endWord, wordList, list);
        List<List<String>> ans = new ArrayList<>();
        for(List<String> l:res){
            if(l.size() == minLength)
                ans.add(l);
        }
        return ans;

    }

    public void backtrack(String nowWord, String beginWord, String endWord, List<String> wordList, List<String> nowList){
        //转换成功
        if(nowWord.equals(endWord)){
            if(minLength >= nowList.size()) {
                List<String> ans = new ArrayList<>();
                minLength = nowList.size();
                ans.addAll(nowList);
                res.add(ans);
            }
            return;
        }


        List<String> options = replaceList(nowWord, endWord, wordList, nowList);

        for (String word: options){
            //做选择--wordList中有可以让我进行替换的词
            nowList.add(word);
            backtrack(word, beginWord, endWord, wordList, nowList);
            nowList.remove(nowList.size()-1);
        }
    }

    public List<String> replaceList(String nowWord, String endWord, List<String> wordList, List<String> nowList){
        List<String> res = new ArrayList<>();
        //如果经过一个变换就可以到endWord，优先返回
        if(canReplace(nowWord, endWord)){
            res.add(endWord);
            return res;
        }
        for(String word:wordList){
            if (canReplace(nowWord, word) && !nowList.contains(word))
                res.add(word);
        }
        return res;
    }

    public boolean canReplace(String s1, String s2){
        int count = 0;
        if(s1.length() != s2.length())
            return false;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i) != s2.charAt(i))
                count++;
        }
        if(count == 1 )
            return true;
        else return false;
    }

    public static void main(String[] args) {
        String beginWord = "hot";
        String endWord = "dog";
        String[] strins = new String[]{"hot","cog","dog","tot","hog","hop","pot","dot"};
        List<String> wordList = Arrays.asList(strins);
        System.out.println(new Solution().findLadders(beginWord, endWord, wordList));
    }
}
