package arrays_strings;

import java.util.ArrayList;
import java.util.List;

public class ZigZagString {
    // Question
    /*
     * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number
     * of rows like this: (you may want to display this pattern in a fixed font for
     * better legibility)
     * 
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     * And then read line by line: "PAHNAPLSIIGYIR"
     * 
     * Write the code that will take a string and make this conversion given a
     * number of rows:
     * 
     * string convert(string s, int numRows);
     * 
     * 
     * Example 1:
     * 
     * Input: s = "PAYPALISHIRING", numRows = 3
     * Output: "PAHNAPLSIIGYIR"
     */
    public static void main(String[] args) {
        System.out.println("Zigzag converted string: "+convertToZigzag("ServiceNowIsHiring", 4));
    }
    public static String convertToZigzag(String s, int numRows){
        //check if the #rows is 1 or greater than equal to length of original string
        //i.e. since row>=s.length() it will be same string
        //e.g. s=sam, numRows=4
        //1.s
        //2.a
        //3.m
        //4.
        //output -> sam
        if(numRows==1 || numRows>=s.length()){
            return s;
        }
        //Initialize the array of ArrayList - 2d array
        List<Character> rows[] = new ArrayList[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new ArrayList<>();
        }
        int direction=1,rowIndex=0;
        for (char ch: s.toCharArray()) {
            rows[rowIndex].add(ch);
            if(rowIndex==0){
                //Go Up
                direction=1;
            }else if(rowIndex == (numRows-1)){
                //Go Down
                direction=-1;
            }
            //Add the value of direction to rowindex to go up or down
            rowIndex += direction;
        }
        StringBuilder result = new StringBuilder();
        for (List<Character> list : rows) {
            for (char ch : list) {
                result.append(ch);
            }
        }
        return result.toString();
    }
}
