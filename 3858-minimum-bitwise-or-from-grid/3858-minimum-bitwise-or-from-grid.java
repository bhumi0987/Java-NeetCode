class Solution {
    public int minimumOR(int[][] grid) {
        int ans=(1<<18)-1;
        for(int bit=17;bit>=0;bit--){
            int curr=ans&~(1<<bit);
            boolean flag=true;
            for(int[] it:grid){
                boolean ok=false;
                for(int it1:it){
                    if((it1|curr)==curr){
                        ok=true;
                        break;
                    }
                }
                if(!ok){
                    flag=false;
                    break;
                }
            }
            if(flag){
                ans=curr;
            }
        }
        return ans;
    }
}