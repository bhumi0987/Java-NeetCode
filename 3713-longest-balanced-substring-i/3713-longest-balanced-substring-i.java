class Solution {
    public int longestBalanced(String s) {
        int ans=1 ;
        int n=s.length();
        for(int i=0;i<n-1;i++){
            int [] arr=new int[26];
            arr[s.charAt(i)-'a']++;
            for(int j=i+1;j<n;j++){
                arr[s.charAt(j)-'a']++;
                if(valid(i,j,s,arr)){
                    ans=Math.max(ans,j-i+1); 
                }
            }
        }
        return ans;
    }
    public boolean valid(int start,int end,String s,int [] arr ){
        int same=0; 
        for(int i=start;i<=end;i++ ){
            char ch=s.charAt(i); 
            int val=arr[ch-'a'];  
            if(val==0){
                continue;
            }  
            if(same==0){
                same=val; 
            } 
            if(same!=val){
                return false;
            } 
        }
        return true;
    }
}