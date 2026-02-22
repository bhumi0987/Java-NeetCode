class Solution {
    public int binaryGap(int n) {
        String s=Integer.toBinaryString(n);
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                arr.add(i);
            }
        }
        int max=0;
        for(int i=0;i<arr.size()-1;i++){
            max=Math.max(max,arr.get(i+1)-arr.get(i));
        }
        return max;
    }
}