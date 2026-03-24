class Solution {
    public long countGoodSubarrays(int[] nums) {
        Stack<Integer> st=new Stack<>();
        int[] pre=new int[nums.length];
        for(int i=nums.length-1;i>=0;i--){
            while(!st.isEmpty()&&(nums[st.peek()]|nums[i])==nums[i]){
                st.pop();
            }
            if(st.isEmpty()){
                pre[i]=nums.length;
            }else{
                pre[i]=st.peek();
            }
            st.push(i);
        }
        int[] suff=new int[nums.length];
        st.clear();
        for(int i=0;i<nums.length;i++){
            while(!st.isEmpty()&&(nums[st.peek()]|nums[i])==nums[i]&&nums[st.peek()]!=nums[i]){
                st.pop();
            }
            if(st.isEmpty()){
                suff[i]=-1;
            }else{
                suff[i]=st.peek();
            }
            st.push(i);
        }
        long ans=0;
        for(int i=0;i<nums.length;i++){
            int x=i-suff[i];
            int y=pre[i]-i;
            ans+=(x*y);
        }
        return ans;
    }
}