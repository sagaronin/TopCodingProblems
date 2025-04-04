package arrays_strings.greedy;

public class JumpGame1 {
    public static void main(String[] args) {
        int jumps[] = { 5, 5, 5, 10, 20 };
        System.out.println("Can I reach end of array: "+JumpGame1.jump(jumps));
    }

    public static boolean jump(int[] jumps) {
        var maxIndex = 0;
        for (int i = 0; i < jumps.length; i++) {
            if (i > maxIndex)
                return false;
            maxIndex = Math.max(maxIndex, i+jumps[i]);
        }
        return true;
    }
}
