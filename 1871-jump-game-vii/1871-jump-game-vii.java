class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        if(s.charAt(s.length()-1)!='0'){
            return false;
        }
        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        int max=0;
        while(!q.isEmpty()){
            int i=q.remove();
            if(i==s.length()-1){
                return true;
            }
            for(int j=Math.max(i+minJump,max);j<=Math.min(i+maxJump,s.length()-1);j++){
                if(s.charAt(j)=='0'){
                    q.add(j);
                }
            }
            max=Math.min(i+maxJump+1,s.length()-1);
        }
        return false;
    }
}