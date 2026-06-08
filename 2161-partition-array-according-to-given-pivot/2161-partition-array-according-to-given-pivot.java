class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        ArrayList<Integer> small=new ArrayList<Integer>();
        ArrayList<Integer> large=new ArrayList<Integer>();
        ArrayList<Integer> same=new ArrayList<Integer>();
        for(int it:nums){
            if(it<pivot){
                small.add(it);
            }
            else if(it==pivot){
                same.add(it);
            }else{
                large.add(it);
            }
        }
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<small.size();i++){
            ans.add(small.get(i));
        }
        for(int i=0;i<same.size();i++){
            ans.add(same.get(i));
        }
        for(int i=0;i<large.size();i++){
            ans.add(large.get(i));
        }
        int[] res=new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            res[i]=ans.get(i);
        }
        return res;
    }
}