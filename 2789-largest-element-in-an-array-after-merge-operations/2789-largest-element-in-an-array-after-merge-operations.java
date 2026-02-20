class Solution {
    public long maxArrayValue(int[] nums) {
        int n=nums.length;
        Stack<Long> st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            if(!st.isEmpty()&&st.peek()>=nums[i]){
                long x=st.pop();
                long y=x+nums[i];
                st.push(y);
            }else{
                st.push((long)nums[i]);
            }
        }
        long ans=Long.MIN_VALUE;
        while(!st.isEmpty()){
            ans=Math.max(ans,st.pop());
        }
        return ans;
    }
}