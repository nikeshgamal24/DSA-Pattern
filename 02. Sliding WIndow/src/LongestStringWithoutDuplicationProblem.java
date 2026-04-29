//3. Longest Substring Without Repeating Characters
//Given a string s, find the length of the longest substring without duplicate characters.

//Example 1:
//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.

//Example 2:
//Input: s = "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.

//Example 3:
//Input: s = "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.

//Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

import javax.swing.*;
import java.util.HashMap;

class LongestStringWithoutDuplicationProblem {
     public static void main(String [] args){
         String str1 = "abcabcbb";
         int k1 = 3;

         String str2 = "bbbbb";
         int k2 = 2;

         String str3 = "pwwkew";
         int k3 = 2;

         System.out.println("Output 1: "+ longestStringWithoutDuplicationProblem(str1));
         System.out.println("Output 2: "+ longestStringWithoutDuplicationProblem(str2));
         System.out.println("Output 3: "+ longestStringWithoutDuplicationProblem(str3));

     }

     public static int longestStringWithoutDuplicationProblem(String str){
         int low =0;
         int high;
         int res = Integer.MIN_VALUE;

         HashMap<String,Integer> frequencyMap = new HashMap<>();

         for (high = 0; high < str.length(); high++) {
             // add new character to the substring and increase the count in the hashtable
             char currentChar = str.charAt(high);
             frequencyMap.put(String.valueOf(currentChar),frequencyMap.
                     getOrDefault(String.valueOf(currentChar),0)+1);

             // check if the window size is greater than that of frequencyMap size then there are duplicate elements
             // so need start eliminating the elemens from initial pointers--low
             int window = high -low+1;
             while(window > frequencyMap.size()){
                 char leftChar = str.charAt(low);
                 frequencyMap.put(String.valueOf(leftChar),frequencyMap.
                         getOrDefault(String.valueOf(leftChar),0)-1);
                 if(frequencyMap.getOrDefault(String.valueOf(leftChar),0) == 0){
                     frequencyMap.remove(String.valueOf(leftChar));
                 }
                 low++;
                 window = high-low+1;
             }
             int len  = high - low + 1;
             res = Math.max(res,len);
         }
         return  (res == Integer.MIN_VALUE)? -1 : res;
     }
}
