class Solution {
    public int solve(int n,int digit){
        int count=0;
        while(n!=0){
            int x=n%10;
            if(x==digit){
                count++;
            }
            n/=10;
        }
        return count;
    }
    public int countDigitOccurrences(int[] nums, int digit) {
        int count=0;
        for(int it:nums){
            count+=solve(it,digit);
        }
        return count;
    }
}