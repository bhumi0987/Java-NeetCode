class Solution {
    public boolean checkOnesSegment(String s) {
        for(int i=0;i<s.length()-1;i++){
            String s1=s.substring(i,i+2);
            System.out.println(s1+" "+i+" "+(i+1));
            if(s1.equals("01")){
                return false;
            }
        }
        return true;
    }
}