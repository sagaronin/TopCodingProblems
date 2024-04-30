package arrays_strings;

public class MissingNumber {
    public static void main(String[] args) {
        int arr[]={0,1};
        System.out.println("Missing Number (Brute Force) : "+MissingNumber.missingNumberBrute(arr));
        System.out.println("Missing Number (Better) : "+MissingNumber.missingNumberBetter(arr));
        System.out.println("Missing Number (Optimal) : "+MissingNumber.missingNumberOptimal(arr));
    }   
    public static int missingNumberBrute(int[] arr) {
        for (int i = 0; i <= arr.length; i++) {
            int found=0;
            for (int j = 0; j < arr.length; j++) {
                if(arr[j]==i){
                    found=1;
                    break;
                }
            }
            if(found==0){
                return i;
            }
        }
        return -1;
    }

    public static int missingNumberBetter(int[] arr) {
        int hash[] = new int[arr.length+1];
        for (int i = 0; i < arr.length; i++) {
            hash[arr[i]]++;
        }
        for (int i = 0; i < hash.length; i++) {
            if(hash[i]==0){
                return i;
            }
        }
        return -1;
    }

    public static int missingNumberOptimal(int[] arr) {
        int n= arr.length;
        int sum = (n*(n+1))/2;
        System.out.println("sum "+sum);
        int add=0;
        for (int i = 0; i < arr.length; i++) {
            add+=arr[i];
        }
        return sum-add;
        
    }
}
