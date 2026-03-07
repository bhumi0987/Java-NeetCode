class Solution {
    public int minFlips(String s) {
        String alt="01";
        int n=s.length();
        int count=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)!=alt.charAt(i&1)){
                count++;
            }
        }
        int ans=Math.min(count,n-count);
        for(int i=0;i<n;i++){
            if(s.charAt(i)!=alt.charAt(i&1)){
                count--;
            }
            if(s.charAt(i)!=alt.charAt((i+n)&1)){
                count++;
            }
            ans=Math.min(ans,Math.min(count,n-count));
        }
        return ans;
    }
}