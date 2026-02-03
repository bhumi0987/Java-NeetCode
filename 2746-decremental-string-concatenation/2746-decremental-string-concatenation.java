class Solution {
    int[][][] dp=new int[1001][26][26]; 
    public int solve(int i,int start,int end,String[] words){
        if(i==words.length){
            return 0;
        }
        if(dp[i][start][end]!=-1){
            return dp[i][start][end];
        }
        int front=Integer.MAX_VALUE;
        int back=Integer.MAX_VALUE;
        int ff=words[i].charAt(0)-'a';
        int bb=words[i].charAt(words[i].length()-1)-'a';
        if(end==ff){
            back=words[i].length()-1+solve(i+1,start,bb,words);
        }else{
            back=words[i].length()+solve(i+1,start,bb,words);
        }
        if(bb==start){
            front=words[i].length()-1+solve(i+1,ff,end,words);
        }else{
            front=words[i].length()+solve(i+1,ff,end,words);
        }
        return dp[i][start][end]=Math.min(front,back);
    }
    public int minimizeConcatenatedLength(String[] words) {
        for(int[][] it:dp){
            for(int[] it1:it){
                Arrays.fill(it1,-1);
            }
        }
        return words[0].length()+solve(1,words[0].charAt(0)-'a',words[0].charAt(words[0].length()-1)-'a',words);
    }
}