class Solution {
    public int findWinningPlayer(int[] skills, int k) {
        int n=skills.length;
        Deque<Integer> dq=new LinkedList<>();
        for(int i=1;i<n;i++){
            dq.addLast(i);
        }
        int prev=0;
        int win=0;
        while(true){
            int curr=dq.pollFirst();
            if(skills[curr]<skills[prev]){
                win++;
                dq.addLast(curr);
            }else{
                win=1;
                dq.addLast(prev);
                prev=curr;
            }
            if(win==k||win>=n-1){
                return prev;
            }
        }
    }
}