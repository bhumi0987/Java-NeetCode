class Solution {
    public int solve(List<Integer> arr,int end,int[] one,int[] zero){
        if(arr==null){
            return 0;
        }
        int tone=one[one.length-1];
        int tzero=zero[zero.length-1];
        for(int it:arr){
            if(it>=end){
                break;
            }
            int ones=one[end]-one[it];
            int zeros=zero[end]-zero[it];
            if(ones==zeros){
                return end-it;
            }
            if(zeros==ones+2&&tone-ones>0){
                return end-it;
            }
            if(ones==zeros+2&&tzero-zeros>0){
                return end-it;
            }
        }
        return 0;
    }
    public int longestBalanced(String s) {
        int n=s.length();
        int[] pre=new int[n+1];
        int[] zero=new int[n+1];
        int[] one=new int[n+1];
        for(int i=0;i<n;i++){
            one[i+1]=one[i]+(s.charAt(i)=='1'?1:0);
            zero[i+1]=zero[i]+(s.charAt(i)=='0'?1:0);
            pre[i+1]=one[i+1]-zero[i+1];
        }
        Map<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<=n;i++){
            map.computeIfAbsent(pre[i],k->new ArrayList<>()).add(i);
        }
        int ans=0;
        for(int i=0;i<=n;i++){
            ans=Math.max(ans,solve(map.get(pre[i]),i,one,zero));
            ans=Math.max(ans,solve(map.get(pre[i]+2),i,one,zero));
            ans=Math.max(ans,solve(map.get(pre[i]-2),i,one,zero));
        }
        return ans;
    }
}