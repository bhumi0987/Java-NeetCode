class Solution {
    static List<Integer> pre=new ArrayList<>();
    static boolean flag=false;
    public void solve(){
        Map<Integer,Integer> map=new TreeMap<>();
        for(int i=1;i<=1000;i++){
            for(int j=i+1;j<=1000;j++){
                int sum=i*i*i+j*j*j;
                map.put(sum,map.getOrDefault(sum,0)+1);
            }
        }
        for(Map.Entry<Integer,Integer> it:map.entrySet()){
            if(it.getValue()>1){
                pre.add(it.getKey());
            }
        }
        flag=true;
    }
    public List<Integer> findGoodIntegers(int n) {
        if(!flag){
            solve();
        }
        List<Integer> ans=new ArrayList<>();
        for(int it:pre){
            if(it<=n){
                ans.add(it);
            }else{
                break;
            }
        }
        return ans;
    }
}