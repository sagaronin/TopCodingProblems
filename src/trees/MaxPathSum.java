package trees;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class MaxPathSum {
    public int maxPathSum(TreeNode root) {
        int maxVal[] = new int[1];
        maxVal[0] = Integer.MIN_VALUE;
        findMaxPath(root, maxVal);
        return maxVal[0];
    }
    public int findMaxPath(TreeNode root, int[] maxVal){
        if(root==null)
            return 0;
        int left = findMaxPath(root.left, maxVal);
        int right = findMaxPath(root.right, maxVal);
        left = Math.max(0,left); //for -ve value of left
        right = Math.max(0,right);//for -ve value of right
        maxVal[0] = Math.max(maxVal[0], left+right+root.val);
        return Math.max(left,right)+root.val;
    }
}
