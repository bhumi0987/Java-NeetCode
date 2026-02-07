class Solution {
    public int minimumDeletions(String s) {
        int n=s.length();
        int[] pre=new int[n];
        int[] suff=new int[n];
        pre[0]=0;
        suff[n-1]=0;
        for(int i=1;i<n;i++){
            pre[i]=pre[i-1]+(s.charAt(i-1)=='b'?1:0);
        }
        for(int i=n-2;i>=0;i--){
            suff[i]=suff[i+1]+(s.charAt(i+1)=='a'?1:0);
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            ans=Math.min(ans,pre[i]+suff[i]);
        }
        return ans;
    }
}