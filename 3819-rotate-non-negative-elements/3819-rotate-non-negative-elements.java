class Solution {
    public int[] rotateElements(int[] nums, int k) {
        ArrayList<Integer> arr=new ArrayList<>();
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=0){
                arr.add(i);
                ans.add(nums[i]);
            }
        }
        if(arr.size()==0){
            return nums;
        }
        k%=arr.size();
        ArrayList<Integer> arr1=new ArrayList<>(ans.size());
        for(int i=k;i<ans.size();i++){
            arr1.add(ans.get(i));
        }
        for(int i=0;i<k;i++){
            arr1.add(ans.get(i));
        }
        for(int i=0;i<arr.size();i++){
            nums[arr.get(i)]=arr1.get(i);
        }
        return nums;
    }
}