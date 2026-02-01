class Solution {
    public String reverseByType(String s) {
        Stack<Character> st=new Stack<>();
        Stack<Character> st1=new Stack<>();
        for(char ch:s.toCharArray()){
            if(Character.isLetter(ch)){
                st.add(ch);
            }else{
                st1.add(ch);
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(Character.isLetter(s.charAt(i))){
                sb.append(st.pop());
            }else{
                sb.append(st1.pop());
            }
        }
        return sb.toString();
    }
}