package arrays_strings;

import java.util.HashMap;
import java.util.HashSet;

public class MostCommonWord {
    public static void main(String[] args) {
        String paragraph="a.";
        String[] banned={""};
        System.out.println("Most common word is: "+MostCommonWord.mostCommonWordBruteForce(paragraph, banned));
    }

    public static String mostCommonWordBruteForce(String paragraph, String banned[]) {
        HashSet<String> hashset = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (String string : banned) {
            hashset.add(string);
        }
        String tokens[] = paragraph.toLowerCase().split("\\W+");
        for (String string : tokens) {
            if (!hashset.contains(string))
                map.put(string, map.getOrDefault(string, 0) + 1);
        }
        int max=0;
        String result="";
        for (String string : map.keySet()) {
            if(map.get(string)>max){
                max=map.get(string);
                result = string;
            }
        }
        return result;
    }
}
