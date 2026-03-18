class Solution {
    public int minCost(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int[] freq=new int[80001];
        int[] freq1=new int[80001];
        for(int i=0;i<n;i++){
            freq[nums1[i]]++;
            freq1[nums2[i]]++;
        }
        long sum=0;
        for(int i=0;i<80001;i++){
            int x=freq[i]+freq1[i];
            if(x%2!=0){
                return -1;
            }
            sum+=(Math.abs(freq[i]-freq1[i]));
        }
        return (int)(sum/4);
    }
}