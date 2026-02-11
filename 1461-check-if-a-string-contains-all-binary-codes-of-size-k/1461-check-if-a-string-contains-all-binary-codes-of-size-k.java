class Solution {
    public boolean hasAllCodes(String s, int k) {
        int n=s.length();
        int need=1<<k;
        boolean[] vis=new boolean[need];
        int val=0;
        int i=0;
        int j=0;
        while(j<n){
            val=(val<<1)+(s.charAt(j)-'0');
            if(j-i+1<k){
                j++;
            }else if(j-i+1==k){
                vis[val]=true;
                val=val-(s.charAt(i)-'0')*(1<<(k-1));
                i++;
                j++;
            }
        }
        for(int l=0;l<need;l++){
            if(vis[l]==false){
                return false;
            }
        }
        return true;
    }
}