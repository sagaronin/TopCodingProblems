package arrays_strings.meeting_room;

public class MedianOFSortedArrays {
    public static void main(String[] args) {
        int nums1[] = {1,3}, nums2[] ={2, 4};
        int n=nums1.length, m=nums2.length, i=0, j=0, index=0;
        int arr[] = new int[n+m];
        while(i<n && j<m){
            if(nums1[i]<=nums2[j])
                arr[index++] = nums1[i++];
            else if(nums1[i]> nums2[j])
                arr[index++] = nums2[j++];
        }
        while(j<m)
                arr[index++] = nums2[j++];
        while(i<n)
                arr[index++] = nums1[i++];
        //System.out.println(Arrays.toString(arr));
        //System.out.println("length: "+(n+m)/2);
        System.out.println(arr[(arr.length/2)-1]);
        System.out.println(arr[(arr.length/2)]);
        System.out.println((double)(arr[(arr.length/2)-1]+arr[(arr.length/2)])/2);
        double median=0;
        if((n+m)%2==0)
            median = (double)(arr[(arr.length/2)-1]+arr[(arr.length/2)])/2;
        else
            median = (double)arr[(arr.length/2)];
        System.out.println("Median: "+median);

    }
}
