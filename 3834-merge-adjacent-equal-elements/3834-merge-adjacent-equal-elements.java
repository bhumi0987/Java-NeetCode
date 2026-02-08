class Solution {
    public List<Long> mergeAdjacent(int[] nums) {
        Stack<Long> st=new Stack<>();
        st.push((long)nums[0]);
        for(int i=1;i<nums.length;i++){
            long x=nums[i];
            while(!st.isEmpty()&&st.peek()==x){
                long y=st.pop();
                x=x+y;
            }
            st.push(x);
        }
        List<Long> ans=new ArrayList<>();
        while(!st.isEmpty()){
            ans.add(st.pop());
        }
        Collections.reverse(ans);
        return ans;
    }
}