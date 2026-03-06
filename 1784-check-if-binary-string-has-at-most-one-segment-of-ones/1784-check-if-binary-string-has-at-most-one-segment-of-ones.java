class Solution {
    public boolean checkOnesSegment(String s) {
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                arr.add(i);
            }
        }
        for(int i=0;i<arr.size()-1;i++){
            if((arr.get(i+1)-arr.get(i))>1){
                return false;
            }
        }
        return true;
    }
}