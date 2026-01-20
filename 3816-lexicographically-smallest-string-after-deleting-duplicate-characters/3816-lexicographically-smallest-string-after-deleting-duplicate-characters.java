class Solution {
    public String lexSmallestAfterDeletion(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            while(!st.isEmpty()&&st.peek()>s.charAt(i)&&map.get(st.peek())>1){
                map.put(st.peek(),map.get(st.peek())-1);
                st.pop();
            }
            st.push(s.charAt(i));
        }
        while(!st.isEmpty()&&map.get(st.peek())>1){
            map.put(st.peek(),map.get(st.peek())-1);
            st.pop();
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}