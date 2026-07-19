class Solution {
    public String smallestSubsequence(String s) {
        Stack<Character> st=new Stack<>();
        int count[]=new int[26];
        boolean user[]=new boolean[26];
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            count[ch-'a']++;
        }
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            count[ch-'a']--;
            if(user[ch-'a']){
                continue;
            }
            while(st.size()>0&&st.peek()>ch&&count[st.peek()-'a']>0){
                char rem=st.pop();
                user[rem-'a']=false;
            }
            st.push(ch);
            user[ch-'a']=true;
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}