class Solution {
    int r;
    int c;
    int[][] dp;
    List<Integer> mask;
    public void solve1(char[] seats,int curr,int prev,int curr1){
        if(curr==c){
            mask.add(curr1);
            return;
        }
        solve1(seats,curr+1,prev,curr1);
        if(seats[curr]!='#'&&(curr==0||(((curr1&(1<<(curr-1)))==0)&&(prev&(1<<(curr-1)))==0))&&(curr==c-1||((prev&(1<<(curr+1)))==0))){
            curr1|=(1<<(curr));
            solve1(seats,curr+1,prev,curr1);
            curr1^=(1<<(curr));
        }
    }
    public int solve(char[][] seats,int curr,int prev){
        if(curr==r){
            return 0;
        }
        if(dp[curr][prev]!=-1){
            return dp[curr][prev];
        }
        mask=new LinkedList<>();
        solve1(seats[curr],0,prev,0);
        int ans=0;
        for(int it:mask){
            ans=Math.max(ans,Integer.bitCount(it)+solve(seats,curr+1,it));
        }
        return dp[curr][prev]=ans;
    }
    public int maxStudents(char[][] seats) {
        r=seats.length;
        c=seats[0].length;
        dp=new int[r][1<<c];
        for(int[] it:dp){
            Arrays.fill(it,-1);
        }
        return solve(seats,0,0);
    }
}