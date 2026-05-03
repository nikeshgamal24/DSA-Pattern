//Minimum Window Substring

//Hint
//Given two strings s and t of lengths m and n respectively,
// return the minimum window substring of s such that
//every character in t (including duplicates) is included in the window.
// If there is no such substring, return the empty string "".

//The testcases will be generated such that the answer is unique.

//Example 1:
//Input: s = "ADOBECODEBANC", t = "ABC"
//Output: "BANC"
//Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.

//Example 2:
//Input: s = "a", t = "a"
//Output: "a"
//Explanation: The entire string s is the minimum window.

//Example 3:
//Input: s = "a", t = "aa"
//Output: ""
//Explanation: Both 'a's from t must be included in the window.

//Since the largest window of s only has one 'a', return empty string.

class MinimumWindowSubstring {
    public static void main(String[]  args){
        String s1 = "ADOBECODEBANC";
        String t1 ="ABC";


        String s2 = "a";
        String t2 ="a";

        String s3 = "a";
        String t3 ="aa";

        System.out.println("Output 1: " + minimumWindowSubstring(s1,t1));
        System.out.println("Output 2: " + minimumWindowSubstring(s2,t2));
        System.out.println("Output 3: " + minimumWindowSubstring(s3,t3));
    }

    public static String minimumWindowSubstring(String s, String t){
        //necessary variables
        int low = 0;
        int minLen = Integer.MAX_VALUE ; // here the length of the sub string will be stored
        int startIdx = 0;
        // create two arrays
        int[] have = new int[255];
        int[] need = new int[255];
        for (char c:t.toCharArray()) {
           need[c]++;
        }
//        System.out.println("Array need");
//        for (int i = 0; i < need.length; i++) {
//            System.out.println(need[i]);
//        }

        for (int high = 0; high < s.length(); high++) {
            //get the character
            have[s.charAt(high)]++;

            // Shrink the window as long as it remains valid
            while(isValid(have,need)){
                int currentWindowLen = high - low + 1;

                // store the minLen and startIndex only when the min length of the substring is obtained
                if (currentWindowLen < minLen) {
                    minLen = currentWindowLen;
                    startIdx = low;
                }

                // Remove the character at 'low' and move forward
                have[s.charAt(low)]--;
                low++;
            }
        }

        // Safety check: if minLen is still MAX_VALUE, no window was found
        if (minLen == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(startIdx,startIdx+minLen);

    }

    public static boolean isValid(int[] have, int[] need){
        for (int i = 0; i < need.length; i++) {
            if(need[i] > have[i]){
                return false;
            }
        }
        return true;
    }
}
