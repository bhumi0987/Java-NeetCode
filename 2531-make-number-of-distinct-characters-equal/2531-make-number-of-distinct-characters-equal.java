class Solution{
    public int solve(char[] arr){
        int count=0;
        for(int i=0;i<26;i++){
            if(arr[i]>0){
                count++;
            }
        }
        return count;
    }
    public boolean isItPossible(String word1, String word2) {
        char[] freq1=new char[26];
        char[] freq2=new char[26];
        for(char ch:word1.toCharArray()){
            freq1[ch-'a']++;
        }
        for(char ch:word2.toCharArray()){
            freq2[ch-'a']++;
        }
        for(int i=0;i<26;i++){
            if(freq1[i]==0){
                continue;
            }
            for(int j=0;j<26;j++){
                if(freq2[j]==0){
                    continue;
                }
                freq1[i]--;
                freq1[j]++;
                freq2[i]++;
                freq2[j]--;
                if(solve(freq1)==solve(freq2)){
                    return true;
                }
                freq1[i]++;
                freq1[j]--;
                freq2[i]--;
                freq2[j]++;
            }
        }
        return false;
    }
}