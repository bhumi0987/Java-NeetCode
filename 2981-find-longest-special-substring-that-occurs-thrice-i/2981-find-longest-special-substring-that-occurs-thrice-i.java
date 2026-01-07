class Solution {
    public boolean solve(String s,int mid){
        int[] freq=new int[26];
        int[] match=new int[26];
        int i=0;
        int j=0;
        while(j<s.length()){
            int ch=s.charAt(j)-'a';
            freq[ch]++;
            if(j-i+1<mid){
                j++;
                continue;
            }
            if(j-i+1>mid){
                int ch1=s.charAt(i)-'a';
                freq[ch1]--;
                i++;
            }
            if(freq[ch]==mid){
                match[ch]++;
            }
            j++;
        }
        for(int it:match){
            if(it>=3){
                return true;
            }
        }
        return false;
    }
    public int maximumLength(String s) {
        int low=0;
        int high=s.length();
        while(low<high){
            int mid=low+(high-low+1)/2;
            if(solve(s,mid)){
                low=mid;
            }else{
                high=mid-1;
            }
        }
        return low==0?-1:low;
    }
}