package arrays_strings;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String str = "cabwefgewcwaefgcf", sub = "cae";
        //System.out.println(
                //"Minimum Window Substring (Brute Force) : "
                    //    + MinimumWindowSubstring.minimumWindowSubstringBruteForce(str, sub));
        System.out.println(
                "Minimum Window Substring (Better) : " + MinimumWindowSubstring.minimumWindowSubstringBetterRetry(str, sub));
    }

    public static String minimumWindowSubstringBruteForce(String str, String sub) {
        int minLength = Integer.MAX_VALUE;
        int startIndex = -1;
        for (int i = 0; i <= (str.length() - sub.length()); i++) {
            int hash[] = new int[256];
            for (int k = 0; k < sub.length(); k++) {
                hash[sub.charAt(k)] = hash[sub.charAt(k)] + 1;
            }
            int count = 0;
            for (int j = i; j < str.length(); j++) {
                if (hash[str.charAt(j)] > 0) {
                    count = count + 1;
                }
                hash[str.charAt(j)]--;
                if (count == sub.length()) {
                    if ((j - i + 1) < minLength) {
                        minLength = j - i + 1;
                        startIndex = i;
                        break;
                    }
                }
            }
        }
        if (startIndex == -1 && minLength == Integer.MAX_VALUE) {
            return "";
        }
        return str.substring(startIndex, startIndex + minLength);
    }

    public static String minimumWindowSubstringBetter(String str, String sub) {
        int minLength = Integer.MAX_VALUE;
        int startIndex = -1, l=0,r=0, count=0;
        int hash[] = new int[256];
        for (int k = 0; k < sub.length(); k++) {
            hash[sub.charAt(k)] = hash[sub.charAt(k)] + 1;
        }
        while(r<str.length()){
            if(hash[str.charAt(r)]>0){
                count++;
            }
            hash[str.charAt(r)]--;
            while(count==sub.length()){
                if((r-l+1)<minLength){
                    minLength = r-l+1;
                    startIndex =l;
                }
                hash[str.charAt(l)]++;
                if(hash[str.charAt(l)]>0){
                    count--;
                }
                l++;
            }
            r++;
        }
        if (startIndex == -1) {
            return "";
        }
        return str.substring(startIndex, startIndex + minLength);
    }

    public static String minimumWindowSubstringBetterRetry(String str, String sub) {
        int minLength = Integer.MAX_VALUE;
        int startIndex =-1;
        int count=0;
        int l=0,r=0;
        int hash[] = new int[256];
        for (int i = 0; i < sub.length(); i++) {
            hash[sub.charAt(i)] = hash[sub.charAt(i)]+1;
        }
        while(r<str.length()){
            if(hash[str.charAt(r)]>0){
                count++;
            }
            hash[str.charAt(r)]--;
            while(count==sub.length()){
                if((r-l+1)<minLength){
                    minLength =r-l+1;
                    startIndex=l;
                }
                hash[str.charAt(l)]++;
                if(hash[str.charAt(l)]>0){
                    count--;
                }
                l++;                
            }
            r++;
        }
        if (startIndex == -1) {
            return "";
        }
        return str.substring(startIndex, startIndex + minLength);
    }
}
