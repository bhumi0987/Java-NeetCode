class Solution {
    public int solve(String s,int[] weight){
        int ans=0;
        for(char ch:s.toCharArray()){
            ans+=weight[ch-'a'];
        }
        return ans;
    }
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder sb=new StringBuilder();
        for(String st:words){
            int w=solve(st,weights);
            char ch=(char)('z'-(w%26));
            sb.append(ch);
        }
        return sb.toString();
    }
}