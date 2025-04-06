package arrays_strings.greedy;

public class JumpGame2 {
    public static void main(String[] args) {
        int jumps[] = { 2,3,1,4,1,1,1,2 };
        System.out.println("Max jumps: "+JumpGame2.jump(jumps));
    }

    public static int jump(int[] jumps) {
        int l =0,r=0,maxjumps=0;
        while(r<jumps.length-1){
            int farthest=0;
            for (int i = l; i <= r; i++) {
                farthest = Math.max(i+jumps[i],farthest);
                if (farthest >= jumps.length - 1) { 
                    return maxjumps + 1;
                }
            }
            l=r+1;
            r=farthest;
            maxjumps++;
        }
        
        return maxjumps;
    }
}
