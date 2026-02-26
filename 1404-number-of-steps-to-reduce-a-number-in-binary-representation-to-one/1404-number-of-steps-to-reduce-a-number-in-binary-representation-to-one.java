class Solution {
    public int numSteps(String s) {
        int n=s.length();
        int ans=0;
        int count=0;
        for(int i=n-1;i>0;i--){
            int digit=Character.getNumericValue(s.charAt(i))+count;
            if(digit%2==1){
                ans+=2;
                count=1;
            }else{
                ans++;
            }
        }
        return ans+count;
    }
}