package arrays_strings;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingChar {
    public static void main(String[] args) {
        String s = "sasar";
        System.out.println("First non repeating char in given string is(Brute force) : "
                + FirstNonRepeatingChar.findFirstbruteForce(s));
        System.out.println(
                "First non repeating char in given string is(Better) : " + FirstNonRepeatingChar.findFirstBetter(s));
    }

    public static int findFirstbruteForce(String str) {
        for (int i = 0; i < str.length(); i++) {
            int flag = 0;
            for (int j = 0; j < str.length(); j++) {
                if (i == j) {
                    continue;
                }
                if (str.charAt(i) == str.charAt(j)) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                return i;
            }
        }
        return -1;
    }

    public static int findFirstBetter(String str) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        
        for (int i = 0; i < str.length(); i++) {
            if(map.containsKey(str.charAt(i))){
                map.put(str.charAt(i), map.get(str.charAt(i))+1);
            }else{
                map.put(str.charAt(i), 1);
            }
        }
        for (int i = 0; i < str.length(); i++) {
            if(map.get(str.charAt(i))==1){
                return i;
            }
        }
        return -1;
    }
}
