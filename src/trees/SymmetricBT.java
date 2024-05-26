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
public class SymmetricBT {
    public boolean isSymmetric(TreeNode root) {
        return check(root.left, root.right);
    }
    public boolean check(TreeNode lc, TreeNode rc){
        if(lc==null || rc==null )
            return lc==rc;
        if(lc.val!=rc.val)
            return false;
        return (check(lc.left, rc.right) && check(lc.right, rc.left));

    }
}
