package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	
	public int TreeDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int l = TreeDepth(root.left);
		int r = TreeDepth(root.right);
		return l > r ? (l + 1) : (r + 1);
	}
	public static void main(String[] args) {
		
	}
	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list=new ArrayList<Integer>();
        if(root==null){
            return list;
        }
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()) {
        	TreeNode node= queue.poll();
            list.add(node.val);
            if (node.left!=null){
                queue.add(node.left);
            }
            if (node.right!=null){
                queue.add(node.right);
            }
        }
        return list;
    }
}