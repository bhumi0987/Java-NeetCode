class Solution {
    public String processStr(String s) {
        StringBuilder sb=new StringBuilder();
        for(char ch:s.toCharArray()){
            if(ch!='*'&&ch!='#'&&ch!='%'){
                sb.append(ch);
            }else if(ch=='*'&&sb.length()>0){
                sb.deleteCharAt(sb.length() - 1);
            }else if(ch=='#'&&sb.length()>0){
                sb.append(sb);
            }else{
                sb.reverse();
            }
        }
        return sb.toString();
    }
}