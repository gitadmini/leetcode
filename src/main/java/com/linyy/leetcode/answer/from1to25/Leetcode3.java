package com.linyy.leetcode.answer.from1to25;

import java.util.HashMap;
import java.util.Map;

/**
 * 无重复字符的最长子串
 */
public class Leetcode3 {

    public static void main(String[] args) {

        String s = " ";
        System.out.println(lengthOfLongestSubstring(s));
    }

    // 用时超过用户数，百分之65
    // 消耗内存超过用户数，百分之22
    public static int lengthOfLongestSubstring(String s) {

        // 整体思路：子串从左侧起始处向右扩大，当遇到重复字符时，向右滑动到第一个重复字符，记录当前子串长度，同时删除滑过去的字符，再向右扩大，依次类推。
        int startIndex = 0; // 子串头指针
        int endIndex = 0; // 子串尾指针
        int repeatIndex = 0; // 重复字符指针
        int max = 0; // 最大子串长度
        char charEnd; // 子串右侧字符
        Map<Character,Integer> map = new HashMap<>(); // 存放子串字符
        if(s.length() == 0){
            return 0;
        }
        while(endIndex < s.length()){
            charEnd = s.charAt(endIndex);
            if(map.containsKey(charEnd)){
                repeatIndex = map.get(charEnd);
                max = (endIndex - startIndex) > max ? (endIndex - startIndex) : max;
                for(int i=startIndex;i<=repeatIndex;i++){
                    map.remove(s.charAt(i));
                }
                map.put(charEnd,endIndex);
                startIndex = repeatIndex + 1;
            }else{
                map.put(charEnd,endIndex);
                max = (endIndex - startIndex + 1) > max ? (endIndex - startIndex + 1) : max;
            }

            endIndex++;
        }
        return max;
    }

}
