//Longest Substring with K Uniques

//You are given a string s consisting only lowercase alphabets and an integer k.
// Your task is to find the length of the longest substring that contains exactly k distinct characters.
//Note : If no such substring exists, return -1.

//Examples:
//Input: s = "aabacbebebe", k = 3
//Output: 7
//Explanation: The longest substring with exactly 3 distinct characters is "cbebebe", which includes 'c', 'b', and 'e'.

//Input: s = "aaaa", k = 2
//Output: -1
//Explanation: There's no substring with 2 distinct characters.

//Input: s = "aabaaab", k = 2
//Output: 7
//Explanation: The entire string "aabaaab" has exactly 2 unique characters 'a' and 'b', making it the longest valid substring.

package revision;

import java.util.HashMap;

class LongestSubstringWithKUnique {
 public static void main(String[] args){
  String s1 =  "aabacbebebe";
  int k1 = 3;

  String s2 =  "aaaa";
  int k2 = 2;

  String s3 =  "aabaaab";
  int k3 = 2;

  System.out.println("Output 1: " + longestSubstringWithKUnique(s1,k1));
  System.out.println("Output 2: " + longestSubstringWithKUnique(s2,k2));
  System.out.println("Output 2: " + longestSubstringWithKUnique(s3,k3));

 }

 public static int longestSubstringWithKUnique(String s, int k){
  //declaring necessary variables
  int low = 0;
  int maxLen = Integer.MIN_VALUE;

  // HashMap to maintain the count of the distinct keys
  HashMap<String,Integer> map = new HashMap<>();

  //loop
  for (int high = 0; high < s.length(); high++) {
    map.put(String.valueOf(s.charAt(high)),map.getOrDefault(String.valueOf(s.charAt(high)),0)+1);

    while(map.size() > k){
     // this is to reduce the count of the elements --? removing
     map.put(String.valueOf(s.charAt(low)),map.getOrDefault(String.valueOf(s.charAt(low)),0)-1);
     if(map.getOrDefault(String.valueOf(s.charAt(low)),0) == 0){
      map.remove(String.valueOf(s.charAt(low)));
     }
     low++;
    }

    if(map.size() == k){
     int len = high-low+1;
     maxLen = Math.max(maxLen,len);
    }
  }

  if(maxLen == Integer.MIN_VALUE){
   return -1;
  }
  return maxLen;
 }
}
