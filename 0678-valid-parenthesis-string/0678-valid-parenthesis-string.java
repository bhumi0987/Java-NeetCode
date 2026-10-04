class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> st=new Stack<>();
        Stack<Integer> st1=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                st.push(i);
            }else if(s.charAt(i)==')'){
                if(!st.isEmpty()){
                    st.pop();
                }else if(!st1.isEmpty()){
                    st1.pop();
                }else{
                    return false;
                }
            }else{
                st1.push(i);
            }
        }
        while(!st.isEmpty()){
            if(st1.isEmpty()){
                return false;
            }
            if(st1.peek()<st.peek()){
                return false;
            }
            st.pop();
            st1.pop();
        }
        return true;
    }
}