//Longest Substring Without Repeating Characters

//Hint
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

package revision;

class LongestSubstringWithoutRepetition {
    public static void main(String[] args){
        String s1 = "abcabcbb";
        String s2 = "bbbbb";
        String s3 = "pwwkew";

        System.out.println("Output 1: " + longestSubstringWithoutRepetition(s1));
        System.out.println("Output 1: " + longestSubstringWithoutRepetition(s2));
        System.out.println("Output 1: " + longestSubstringWithoutRepetition(s3));

    }

    public static int longestSubstringWithoutRepetition(String s){
        int low = 0;
        int maxLen = -1;

//        Approach 1: Using Array
        int[] arr = new int[255];

        for (int high = 0; high < s.length(); high++) {
            arr[s.charAt(high)]++;
            int maxFreq = maxFreq(arr);
            while(maxFreq > 1){
                arr[s.charAt(low)]--;
                low++;
                maxFreq = maxFreq(arr);
            }


            int len = high-low+1;
            maxLen = Math.max(maxLen,len);
        }

        if(maxLen == -1) return 0;

        return maxLen;
    }

    public static int maxFreq(int[] arr){
        int maxFreq= 0;
        for(int ele:arr){
            if(maxFreq < ele){
                maxFreq = ele;
            }
        }
        return maxFreq;
    }
}
