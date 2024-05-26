package trees;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
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
public class ZigZagPrint {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        boolean flag=false;
        if(root==null)
            return ans;
        q.add(root);
        while(!q.isEmpty()){
            int level = q.size();
            List<Integer> sub = new LinkedList<>();
            for(int i=0;i<level;i++){
                TreeNode node = q.peek();
                if(node.left!=null)
                    q.add(node.left);
                if(node.right!=null)
                    q.add(node.right);
                sub.add(q.poll().val);
            }
            flag=!flag;
            if(!flag){
                Collections.reverse(sub);
            }
            ans.add(sub);
        }
        return ans;
        
    }
}
