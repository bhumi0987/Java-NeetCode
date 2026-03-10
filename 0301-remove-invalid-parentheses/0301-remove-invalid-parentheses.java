class Solution {
    boolean solve(String s){
        int count=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='('){
                count++;
            }
            if(c==')'&&count--==0){
                return false;
            }
        }
        
        return count==0;
    }
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans=new ArrayList<>();
        Queue<String> q=new LinkedList<>();
        Set<String> set=new HashSet<>();
        q.add(s);
        set.add(s);
        boolean flag=false;
        while(!q.isEmpty()){
            s=q.poll();
            if(solve(s)){
                ans.add(s);
                flag=true;
            }
            if(flag){
                continue;
            }
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)!='('&&s.charAt(i)!=')'){
                    continue;
                }
                String t=s.substring(0,i)+s.substring(i+1);
                if(!set.contains(t)){
                    q.add(t);
                    set.add(t);
                }
            }
        }
        return ans;
    }
}