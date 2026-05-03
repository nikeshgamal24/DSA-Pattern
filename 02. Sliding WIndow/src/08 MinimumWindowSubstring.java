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

        return "";
    }

    public static boolean isValid(int[] have, int[] need){

        return true;
    }
}
