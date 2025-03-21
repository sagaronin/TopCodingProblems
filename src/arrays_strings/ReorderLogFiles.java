package arrays_strings;

import java.util.Arrays;

public class ReorderLogFiles {
    public static void main(String[] args) {
        String logs[] = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        System.out.println("Reordered log files: "+Arrays.toString(ReorderLogFiles.reorderLogFiles(logs)));
    }
    
    public static String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (log1,log2)->{
            //log1 < log2  -> -1
            //log1 == log2 ->  0
            //log1 > log2  ->  1
            String id1 = ((String) log1).substring(0, ((String) log1).indexOf(" "));
            String id2 = ((String) log2).substring(0, ((String) log2).indexOf(" "));
            String main1 = ((String) log1).substring(((String) log1).indexOf(" ")+1);
            String main2 = ((String) log2).substring(((String) log2).indexOf(" ")+1);

            boolean isDigit1 = Character.isDigit(main1.charAt(0));
            boolean isDigit2 = Character.isDigit(main2.charAt(0));
            if(!isDigit1 && !isDigit2){
                int value = main1.compareTo(main2);
                if(value==0)
                    return id1.compareTo(id2);
                return value;
            }else if(isDigit1 == isDigit2){
                return 0;
            }else if(isDigit1!=isDigit2){
                return 1;
            }else{
                return -1;
            }
            //return isDigit1?(isDigit2? 0 : 1) :-1;
        });
        return logs;
    }
}
