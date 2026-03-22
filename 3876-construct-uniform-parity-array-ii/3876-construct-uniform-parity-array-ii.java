class Solution {
    public boolean uniformArray(int[] nums1) {
        boolean flag=true;
        int min=nums1[0];
        for(int it:nums1){
            if(it<min){
                min=it;
            }
            if(it%2!=0){
                flag=false;
            }
        }
        return min%2!=0||flag;
    }
}