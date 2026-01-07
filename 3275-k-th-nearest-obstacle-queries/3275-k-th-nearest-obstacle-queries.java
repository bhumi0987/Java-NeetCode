class Solution {
    public int[] resultsArray(int[][] queries, int k) {
        int n=queries.length;
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            int sum=Math.abs(queries[i][0])+Math.abs(queries[i][1]);
            pq.add(sum);
            if(pq.size()>k){
                pq.poll();
            }
            ans[i]=(pq.size()==k)?pq.peek():-1;
        }
        return ans;
    }
}