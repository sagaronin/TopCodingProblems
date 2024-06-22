package arrays_strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagram {
    public static void main(String[] args) {
        String strs[] = { "eat", "tea", "tan", "ate", "nat", "bat" };
        System.out.println(Arrays.toString(GroupAnagram.groupAnagramBruteForce(strs).toArray()));
    }

    public static List<List<String>> groupAnagramBruteForce(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char temp[] = str.toCharArray();
            Arrays.sort(temp);
            String tempString = String.valueOf(temp);
            if(map.get(tempString)==null){
                map.put(tempString, new ArrayList<String>(Arrays.asList(str)));
            }else{
                map.get(tempString).add(str);                
            }
        }        
        return new ArrayList<>(map.values());
    }
    public static List<List<String>> optimized(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char temp[] = str.toCharArray();
            Arrays.sort(temp);
            String tempStr = String.valueOf(temp);
            if(map.get(tempStr)==null){
                map.put(tempStr,new ArrayList<String>(Arrays.asList(str)));
            }else{
                map.get(tempStr).add(str);
            }
        }
        return new ArrayList<>(map.values());
    }
}
