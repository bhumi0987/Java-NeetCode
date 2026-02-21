class Solution {
    public int countPrimeSetBits(int left, int right) {
        ArrayList<Integer> arr=new ArrayList<>(Arrays.asList(2,3,5,7,11,13,17,19));
        int count=0;
        for(int i=left;i<=right;i++){
            int count1=0;
            String x=Integer.toBinaryString(i);
            for(int j=0;j<x.length();j++){
                if(x.charAt(j)=='1'){
                    count1++;
                }
            }
            boolean flag=arr.contains(count1);
            if(flag){
                count++;
            }
        }
        return count;
    }
}