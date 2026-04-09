class Solution {
    public int minLengthAfterRemovals(List<Integer> nums){
        int n=nums.size();
        int i=0;
        int j=(n+1)/2;
        int count=0;
        while(i<n/2&&j<n){
            if(nums.get(i)<nums.get(j)){
                count++;
            }
            i++;
            j++;
        }
        return nums.size()- 2*count;
    }
}