package arrays_strings;

public class LongestPalindromicSubstring {
    static int resultStart;
    static int resultLen;

    public static void main(String[] args) {
        String s = "ooabbaoo";
        System.out.println("Longest Palindromic substring is: "+LongestPalindromicSubstring.checkPalindrome(s));
    }

    private static String checkPalindrome(String s) {
        int n = s.length();
        if (n < 2)
            return s;
        for (int i = 0; i < n-1; i++) {
            expand(s,i,i);
            expand(s,i,i+1);
        }
        return s.substring(resultStart, resultStart+resultLen);
    }

    private static void expand(String s, int start, int end) {
        while(start>=0 && end<s.length() && s.charAt(start)==s.charAt(end)){
            start--;
            end++;
        }
        if(resultLen< end-start-1){
            resultStart = start+1;
            resultLen = end-start-1;
        }
    }

}
