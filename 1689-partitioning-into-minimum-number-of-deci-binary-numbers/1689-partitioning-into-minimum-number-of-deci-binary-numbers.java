class Solution {
    public int minPartitions(String n) {
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n.length();i++){
            int s=Integer.parseInt(String.valueOf(n.charAt(i)));
            max=Math.max(s,max);
        }
        return max;
    }
}