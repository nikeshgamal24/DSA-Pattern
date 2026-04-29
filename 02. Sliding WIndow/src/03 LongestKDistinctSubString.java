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

import java.util.HashMap;

class LongestKDistinctSubString {
    public static void main(String [] args){
        String str1 = "aabacbebebe";
        int k1 = 3;

        String str2 = "aaaa";
        int k2 = 2;

        String str3 = "aabaaab";
        int k3 = 2;

        System.out.println("Output 1: "+ longestKDistinctSubString(str1,k1));
        System.out.println("Output 2: "+ longestKDistinctSubString(str2,k2));
        System.out.println("Output 3: "+ longestKDistinctSubString(str3,k3));

    }

    public static int longestKDistinctSubString(String str, int k) {
        // declare necessary variables
        int low = 0;
        int high;
        int res = Integer.MIN_VALUE;
        HashMap<String, Integer> charFrequencyMap = new HashMap<>();

        for (high = 0; high < str.length(); high++) {
            // 1. track the frequency of the each character using hashmap */
            // get the character
            char currentChar = str.charAt(high);
//            System.out.println("currentChar at" + high + "index :" + currentChar );

            // retrieve the character from the hashmap ad add 1 else return 0
            charFrequencyMap.put(String.valueOf(currentChar), charFrequencyMap.
                    getOrDefault(String.valueOf(currentChar), 0) + 1);

            //2. if the distinct value is above the K value in the hashmap we eliminate from the initial index
            while (charFrequencyMap.size() > k) {
                //******removing character from left of the string and update its count on HashMap*****

                //character at pointer low
                char leftChar = str.charAt(low);

                // eliminate the count of that character
                charFrequencyMap.put(String.valueOf(leftChar), charFrequencyMap.
                        getOrDefault(String.valueOf(leftChar), 0) - 1);
                int countValue = charFrequencyMap.getOrDefault(String.valueOf(leftChar), 0);

                // check if that key is 0 if yes then remove it from the Hashmap
                if (countValue == 0) {
                    charFrequencyMap.remove(String.valueOf(leftChar));
                }

                // update low
                low++;
            }

            //3. if the distinct value is equals to K value then we will keep track of the length record max/longest substring
            if (charFrequencyMap.size() == k) {
                int len = high - low + 1;
                res = Math.max(res, len);
            }
        }
        return (res == Integer.MIN_VALUE)? -1 : res;
    }
}
