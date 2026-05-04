//Longest Repeating Character Replacement

//You are given a string s and an integer k.
// You can choose any character of the string and
// change it to any other uppercase English character.
// You can perform this operation at most k times.
//
//Return the length of the longest substring containing the same letter you can get after performing the above operations.

//Example 1
//Input: s = "ABAB", k = 2
//Output: 4
//Explanation: Replace the two 'A's with two 'B's or vice versa.

//Example 2:
//Input: s = "AABABBA", k = 1
//Output: 4
//Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".

//The substring "BBBB" has the longest repeating letters, which is 4.
//There may exist other ways to achieve this answer too.

package revision;

class LongestRepeatingCharacterReplacement {
    public static void main(String[] args){
        String s1 = "ABAB";
        int k1 = 2;

        String s2 = "AABABBA";
        int k2 = 1;

        System.out.println("Output 1: " + longestRepeatingCharacterReplacement(s1,k1));
        System.out.println("Output 2: " + longestRepeatingCharacterReplacement(s2,k2));
    }

    public static int longestRepeatingCharacterReplacement(String s, int k){
        int low = 0;
        int maxLen = -1;

        int[] arr = new int[255];

        for (int high = 0; high <s.length() ; high++) {
            char rightChar = s.charAt(high);
            arr[rightChar]++;

            int len = high-low+1;
            int maxFreq = maxFreq(arr);
            int diff = len - maxFreq;

            while(diff > k){
                char leftChar = s.charAt(low);
                arr[leftChar]--;
                low++;

                len = high-low+1;
                maxFreq = maxFreq(arr);
                diff = len - maxFreq;
            }
            maxLen = Math.max(maxLen, high-low+1);
        }
        if(maxLen==-1) return 0;
        return maxLen;
    }

    public static int maxFreq(int[] array){
        int maxFreq = 0;

        for(int num:array){
            if(maxFreq < num){
                maxFreq = num;
            }
        }
        return maxFreq;
    }
}
