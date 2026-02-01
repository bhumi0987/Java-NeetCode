class Solution {
    public int minimumCost(int[] nums) {
        int sum=0;
        sum+=nums[0];
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i=1;i<nums.length;i++){
            arr.add(nums[i]);
        }
        Collections.sort(arr);
        sum+=arr.get(0);
        sum+=arr.get(1);
        return sum;
    }
}