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

public class ValidateBST {
    
    public boolean isValidBST(TreeNode root) {
        return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean check(TreeNode node, long left, long right){
        if(node==null)
            return true;
        if(!(node.val > left && node.val < right)) //or // if(node.val <= left || node.val >= right)
            return false;
        return (check(node.left, left,node.val) && check(node.right, node.val, right));
        
    }
}
