class Solution {
    public int solve(int n,int idx,int[] pos,char[] arr){
        if(idx==arr.length){
            return 0;
        }
        if(arr[idx]=='R'&&pos[1]+1<n){
            return 1+solve(n,idx+1,new int[]{pos[0],pos[1]+1},arr);
        }
        else if(arr[idx]=='L'&&pos[1]-1>=0){
            return 1+solve(n,idx+1,new int[]{pos[0],pos[1]-1},arr);
        }
        else if(arr[idx]=='U'&&pos[0]-1>=0){
            return 1+solve(n,idx+1,new int[]{pos[0]-1,pos[1]},arr);
        }
        else if(arr[idx]=='D'&&pos[0]+1<n){
            return 1+solve(n,idx+1,new int[]{pos[0]+1,pos[1]},arr);
        }else{
            return 0;
        }
    }
    public int[] executeInstructions(int n, int[] pos, String s) {
        int[] ans=new int[s.length()];
        for(int i=0;i<s.length();i++){
            ans[i]=solve(n,0,pos,s.substring(i,s.length()).toCharArray());
        }
        return ans;
    }
}