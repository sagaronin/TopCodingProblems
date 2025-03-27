package arrays_strings;

class Solution {

    public void reverseWords(char[] s) {
        reverse(s, 0, s.length-1);// reverse whole array
        int r=0;
        while(r<s.length){
            int l=r;
            while(r<s.length && s[r]!=' ')
                r++;
            reverse(s, l, r-1);//reverse only first set of char till space
            r++;            
        }
    }

    public void reverse(char[] s, int l, int r) {
        while(l<r){
            char ch = s[l];
            s[l++]=s[r];
            s[r--]=ch;
        }
    }
    public static void main(String[] args) {
        Solution sl = new Solution();
        char ch[]={'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
        sl.reverseWords(ch);
        System.out.println(ch);
    }
}