class Solution {
    public int totalStrength(int[] strength) {
        long mod=1000000007;
        int n=strength.length;
        long[] pre=new long[n+1];
        long[] pre1=new long[n+2];
        for(int i=0;i<n;i++){
            pre[i+1]=(pre[i]+strength[i])%mod;
        }
        for(int i=0;i<=n;i++){
            pre1[i+1]=(pre1[i]+pre[i])%mod;
        }
        Stack<Integer> st=new Stack<>();
        int[] left=new int[n];
        int[] right=new int[n];
        Arrays.fill(left,-1);
        for(int i=0;i<n;i++){
            while(!st.isEmpty()&&strength[st.peek()]>=strength[i]){
                st.pop();
            }
            if(st.empty()){
                left[i]=-1;
            }else{
                left[i]=st.peek();
            }
            st.push(i);
        }
        st.clear();
        Arrays.fill(right,n);
        for(int i=n-1;i>=0;i--){
            while(!st.empty()&&strength[st.peek()]>strength[i]){
                st.pop();
            }
            if(st.empty()){
                right[i]=n;
            }
            else{
                right[i]=st.peek();
            }
            st.push(i);
        }
        long ans=0;
        for(int i=0;i<n;i++){
            int l=left[i];
            int r=right[i];
            long part1=(pre1[r+1]-pre1[i+1])*(i-l)%mod;
            long part2=(pre1[i+1]-pre1[l+1])*(r-i)%mod;
            long p=(part1-part2)%mod;
            if(p<0){
                p+=mod;
            }
            ans=(ans+(p*strength[i])%mod)%mod;
        }
        if(ans<0){
            ans+=mod;
        }
        return (int)(ans%mod);
    }
}