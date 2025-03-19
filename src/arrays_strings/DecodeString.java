package arrays_strings;

import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {
        //String encoded="3[a2[c]]";
        String encoded="2[abc]3[cd]ef";
       System.out.println( DecodeString.decode(encoded));
    }

    private static String decode(String encoded) {
        Stack<Integer> occurence = new Stack<>();
        Stack<StringBuilder> aux = new Stack<>();
        StringBuilder output = new StringBuilder();
        int n=0;
        for (char c:encoded.toCharArray()) {
            if(Character.isDigit(c)){
                n = n*10+(c-'0');
            }else if(c=='['){
                //since this is start of brack, what it means is before this there was definitely a digit.
                // so push the digit into occurence stack and make n as zero
                occurence.push(n);
                n=0;
                //Push the output string formed till now in auxillary stack
                aux.push(output);
                // Create a new instance of string and assign it to output string builder
                output = new StringBuilder();
            }else if(c==']'){
                //Since this is end of bracket, what is means is last char was Character.
                //Get the output string and store in temp variable
                StringBuilder temp =output;
                //Pop the last formed string from auxillary stack and assign it to Output string
                output = aux.pop();
                //Get the latest count of digit occurence and append the temp string to output string
                int k = occurence.pop();
                while(k-- >0){
                    output.append(temp);
                }
            }else{
                // This is character hence append it to output string
                output.append(c);
            }
        }
        return output.toString();
    }
}
