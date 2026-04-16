class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n=nums.length;
        int m=queries.length;
        HashMap<Integer,ArrayList<Integer>> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.computeIfAbsent(nums[i],k->new ArrayList<>()).add(i);
        }
        List<Integer> ans=new ArrayList<>();
        for(int it:queries){
            int node=nums[it];
            ArrayList<Integer> ds=map.get(node);
            if(ds.size()==1){
                ans.add(-1);
                continue;
            }
            int posi=Collections.binarySearch(ds,it);
            int left=(posi-1>=0)?ds.get(posi-1):ds.get(ds.size()-1);
            int right=(posi+1<ds.size())?ds.get(posi+1):ds.get(0);
            int dl=Math.abs(it-left);
            dl=Math.min(dl,n-dl);
            int dr=Math.abs(it-right);
            dr=Math.min(dr,n-dr);
            ans.add(Math.min(dl,dr));
        }
        return ans;
    }
}