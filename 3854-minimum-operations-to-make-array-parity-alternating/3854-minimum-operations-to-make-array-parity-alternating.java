class Solution {
    public int[] solve(int[] nums,boolean flag){
        int op=0;
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int it:nums){
            if((it%2!=0&&flag)||(it%2==0&&!flag)){
                op++;
                max=Math.max(max,it-1);
                min=Math.min(min,it+1);
            }else{
                max=Math.max(max,it);
                min=Math.min(min,it);
            }
            flag=!flag;
        }
        return new int[]{op,max-min};
    }
    public int[] makeParityAlternating(int[] nums) {
        int n=nums.length;
        if(n==1){
            return new int[]{0,0};
        }
        HashSet<Integer> set=new HashSet<>();
        for(int it:nums){
            set.add(it);
        }
        if(set.size()==1){
            return new int[]{n/2,1};
        }
        int[] ans1=solve(nums,false);
        int[] ans2=solve(nums,true);
        if(ans1[0]==ans2[0]){
            return ans1[1]<ans2[1]?ans1:ans2;
        }
        return ans1[0]<ans2[0]?ans1:ans2;
    }
}