//Longest Repeating Character Replacement

//You are given a string s and an integer k. You can choose any character of the string and change
// it to any other uppercase English character. You can perform this operation at most k times.

//Return the length of the longest substring containing the same letter you can get after performing the above operations.

//Example 1:
//Input: s = "ABAB", k = 2
//Output: 4
//Explanation: Replace the two 'A's with two 'B's or vice versa.

//Example 2:
//Input: s = "AABABBA", k = 1
//Output: 4
//Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".

//The substring "BBBB" has the longest repeating letters, which is 4.

//There may exists other ways to achieve this answer too.

class LongestSubStringWithSameLettersWithReplacement {
    public static void main(String[] args){
        String str1 = "ABAB";
        int k1 = 2;
        String str2 = "AABABBA";
        int k2 = 1;

        System.out.println("Output 1: " + longestSubStringWithSameLettersWithReplacement(str1,k1));
        System.out.println("Output 2: " + longestSubStringWithSameLettersWithReplacement(str2,k2));
    }

    public static int longestSubStringWithSameLettersWithReplacement(String str, int k){
        int low = 0;
        int res = Integer.MIN_VALUE;
        int [] freq = new int[26];
        int len, maxFreq = 0, diff;

        for (int high = 0; high < str.length(); high++) {
            // add the character to the substring
            freq[str.charAt(high) - 'A']++;

            len = high-low+1;
            maxFreq= maxFreq(freq);
            diff = len - maxFreq;

            while(diff > k){
                freq[str.charAt(low) - 'A']--;
                low++;
                len = high-low+1;
                maxFreq= maxFreq(freq);
                diff = len - maxFreq;
            }

            len = high - low + 1;
            res = Math.max(res,len);
        }
        return (res==Integer.MIN_VALUE)? -1 : res;
    }

    public static int maxFreq(int [] freq){
        int max = 0;
        for(int count: freq){
            max = Math.max(max,count);
        }
        return max;
    }
}

