class Solution {
    public String maximumXor(String s, String t) {
        int t1=0;
        int t0=0;
        for(char ch:t.toCharArray()){
            if(ch=='1'){
                t1++;
            }
        }
        t0=t.length()-t1;
        StringBuilder res=new StringBuilder();
        for(char ch:s.toCharArray()){
            if(ch=='1'){
                if(t0>0){
                    res.append("1");
                    t0--;    
                }else{
                    res.append("0");
                    t1--;
                }
            }else{ 
                if(t1>0){
                    res.append("1"); 
                    t1--;
                }else{
                    res.append("0"); 
                    t0--;
                }
            }
        }
        return res.toString();
    }
}