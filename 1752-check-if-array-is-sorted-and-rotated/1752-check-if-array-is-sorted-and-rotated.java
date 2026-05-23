class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int rotations = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i-1]) {
                rotations++;
                if (rotations > 1) {
                    return false;
                }
            }
        }
        if (rotations == 1) {
            return nums[n-1] <= nums[0];
        }
        return true;
    }
}