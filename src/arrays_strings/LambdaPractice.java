package arrays_strings;

import java.util.*;

public class LambdaPractice {
    public static void main(String[] args) {
        //Using anonymous inner class concept
        Comparator<String> nameComparator = new Comparator<String>() {
            public int compare(String name1, String name2) {
                //Compares its two arguments for order. 
                //Returns a negative integer, zero, or a positive integer 
                //as the first argument is 
                //less than, equal to, or greater than the second respectively.
                if (name1.length() > name2.length())
                    return 1;// return 1 means swap
                else if (name1.length() < name2.length())
                    return -1;
                else
                    return 0;
            }
        };

        //Using lambda expression
        Comparator<String> nameComparatorLambda = (String name1, String name2) -> {
                if (name1.length() > name2.length())
                    return 1;// return 1 means swap
                else if (name1.length() < name2.length())
                    return -1;
                else
                    return 0;
            };
        

        List<String> names = new ArrayList<>();
        names.add("aa2");
        names.add("aaaaaaaa8");
        names.add("aaaaa5");
        names.add("aaa3");
        names.add("aaaaaaa7");
        names.add("aa2");
        names.add("a1");
        names.add("aaaa4");
        System.out.println(names);
        Collections.sort(names, nameComparator);
        Collections.sort(names, nameComparatorLambda);
        Collections.sort(names, (name1, name2) -> {
            if (name1.length() > name2.length())
                return 1;// return 1 means swap
            else if (name1.length() < name2.length())
                return -1;
            else
                return 0;
        });
        System.out.println(names);

    }

}
