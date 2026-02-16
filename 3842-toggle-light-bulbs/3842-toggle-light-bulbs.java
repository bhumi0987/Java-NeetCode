class Solution {
    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
        int[] freq=new int[101];
        for(int it:bulbs){
            freq[it]++;
        }
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<101;i++){
            if(freq[i]>0&&freq[i]%2==1){
                ans.add(i);
            }
        }
        return ans;
    }
}