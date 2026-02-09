/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<Integer>ans=new ArrayList<>();
    public void solve(TreeNode root){
        if(root.left==null&&root.right==null){
            ans.add(root.val);
            return;
        }
        if(root.left!=null){
            solve(root.left);
        }
        ans.add(root.val);
        if(root.right!=null){
            solve(root.right);
        }
    }
    public TreeNode dfs(int i,int j){
        if(i>j){
            return null;
        }
        int mid=i+(j-i)/2;
        TreeNode left=dfs(i,mid-1);
        TreeNode right=dfs(mid+1,j);
        TreeNode root=new TreeNode(ans.get(mid),left,right);
        return root;
        
    }
    public TreeNode balanceBST(TreeNode root) {
        solve(root);
        int i=0;
        int j=ans.size()-1;
        return dfs(i,j);
        
    }
}