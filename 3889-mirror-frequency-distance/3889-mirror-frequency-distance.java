class Solution {
    public int mirrorFrequency(String s) {
        int[] freq=new int[10];
        int[] freq1=new int[26];
        for(char ch:s.toCharArray()){
            if(ch>='0'&&ch<='9'){
                freq[ch-'0']++;
            }else{
                freq1[ch-'a']++;
            }
        }
        int ans=0;
        for(int i=0;i<5;i++){
            ans+=Math.abs(freq[i]-freq[9-i]);
        }
        for(int i=0;i<13;i++){
            ans+=Math.abs(freq1[i]-freq1[25-i]);
        }
        return ans;
    }
}