package arrays_strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSumUnique {
    public static void main(String[] args) {
        int arr[] = { -1, 0, 1, 2, -1, -4 };
        //List<List<Integer>> ans = ThreeSumUnique.threeSumBruteForce(arr);
        //List<List<Integer>> ans = ThreeSumUnique.threeSumBetter(arr);
        List<List<Integer>> ans = ThreeSumUnique.threeSumOptimal(arr);
        for (List<Integer> it : ans) {
            System.out.print("[");
            for (Integer i : it) {
                System.out.print(i + " ");
            }
            System.out.print("] ");
        }
        System.out.println();
    }

    public static List<List<Integer>> threeSumBruteForce(int arr[]) {
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        List<Integer> list = Arrays.asList(arr[i], arr[j], arr[k]);
                        list.sort(null);
                        set.add(list);
                    }
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<List<Integer>>(set);
        return ans;
    }

    public static List<List<Integer>> threeSumBetter(int arr[]) {
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        for (int i = 0; i < arr.length; i++) {
            Set<Integer> temp = new HashSet<>();
            for (int j = i + 1; j < arr.length; j++) {
                int third = -(arr[i] + arr[j]);
                if (temp.contains(third)) {
                    List<Integer> list = Arrays.asList(arr[i], arr[j], third);
                    list.sort(null);
                    set.add(list);
                }
                temp.add(arr[j]);
            }
        }
        List<List<Integer>> ans = new ArrayList<List<Integer>>(set);
        return ans;
    }

    public static List<List<Integer>> threeSumOptimal(int arr[]) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if(i>0 && arr[i]==arr[i-1])
                continue;
            int l = i+1;
            int r = arr.length-1;
            while(l<r){
                int sum = arr[i]+arr[l]+arr[r];
                if(sum<0){
                    l++;
                }else if(sum>0){
                    r--;
                }else{
                    // if sum is same means we found the element
                    ans.add(Arrays.asList(arr[i], arr[l], arr[r]));
                    l++;
                    r--;
                    while(l<r && arr[l]==arr[l-1]) l++;
                    while(l<r && arr[r]==arr[r+1]) r--;
                }
            }
        }
        return ans;
    }
}
