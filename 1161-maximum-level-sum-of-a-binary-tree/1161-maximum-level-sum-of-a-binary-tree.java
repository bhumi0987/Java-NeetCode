class Solution {
    public int maxLevelSum(TreeNode root) {
        if(root==null){
            return 0;
        }
        int sum=Integer.MIN_VALUE;
        int maxlevel=0;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int level=0;
        while(!q.isEmpty()){
            int size=q.size();
            level++;
            int ans=0;
            while(size-->0){
                TreeNode node=q.peek();
                q.remove();
                ans+=node.val;
                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
            }
            if(ans>sum){
                sum=ans;
                maxlevel=level;
            }
        }
        return maxlevel;
    }
}