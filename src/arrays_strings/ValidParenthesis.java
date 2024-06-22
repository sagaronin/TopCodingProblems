package arrays_strings;

import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {
        String parenthesis = ")";
        System.out.println("Answer : " + ValidParenthesis.validParenthesisBrute(parenthesis));
    }

    public static boolean validParenthesisBrute(String parenthesis) {

        if (parenthesis.length() % 2 != 0)
            return false;
        Stack<Character> stack = new Stack<>();
        for (char ch : parenthesis.toCharArray()) {
            if (ch == '(')
                stack.push(')');
            else if (ch == '{')
                stack.push('}');
            else if (ch == '[')
                stack.push(']');
            else if(!stack.isEmpty() && stack.pop()!=ch)
                return false;
        }
        return stack.isEmpty();
    }
}
