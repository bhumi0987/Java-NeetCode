class Solution {
    Map<String,Integer> dp;
    public int distance(int a[],int b[]){
        return Math.abs(a[0]-b[0])+Math.abs(a[1]-b[1]);
    }
    public int solve(String word,int idx,int[] finger1,int[] finger2){
        if(idx==word.length()){
            return 0;
        }
        String key=idx+","+finger1[0]+","+finger1[1]+","+finger2[0]+','+finger2[1];
        if(dp.containsKey(key)){
            return dp.get(key);
        }
        int[] curr=new int[]{(word.charAt(idx)-'A')/6,(word.charAt(idx)-'A')%6};
        int f1=solve(word,idx+1,curr,finger2);
        int f2=solve(word,idx+1,finger1,curr);
        int val=Math.min(f1+(finger1[0]==-1?0:distance(finger1,curr)),f2+(finger2[0]==-1?0:distance(finger2,curr)));
        dp.put(key,val);
        return val;
    }
    public int minimumDistance(String word) {
        dp=new HashMap<>();
        return solve(word,0,new int[]{-1,-1},new int[]{-1,-1});
    }
}