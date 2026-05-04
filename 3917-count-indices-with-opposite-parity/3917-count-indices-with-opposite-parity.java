class Solution {
    public int solve(List<Integer> list,int target){
        int left=0;
        int right=list.size()-1;
        int first=list.size(); 
        while(left<=right){
            int mid=left+(right-left)/2;
            if(list.get(mid)>target){
                first=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return list.size()-first;
    }
    public int[] countOppositeParity(int[] nums){
        int n=nums.length;
        int[] ans=new int[n];
        List<Integer> even=new ArrayList<>();
        List<Integer> odd=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(nums[i]%2==0){
                even.add(i);
            }else{
                odd.add(i);
            }
        }
        for(int i=0;i<n;i++){
            if(nums[i]%2==0){
                ans[i]=solve(odd,i);
            }else{
                ans[i]=solve(even,i);
            }
        }
        return ans;
    }
}