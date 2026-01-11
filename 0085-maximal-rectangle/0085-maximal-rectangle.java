class Solution {
    public int solve(int[] height){
        if(height==null||height.length==0){
            return 0;
        }
        int[] nsl=new int[height.length];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<height.length;i++){
            while(!st.isEmpty()&&height[st.peek()]>=height[i]){
                st.pop();
            }
            if(st.isEmpty()){
                nsl[i]=-1;
            }else{
                nsl[i]=st.peek();
            }
            st.push(i);
        }
        st.clear();
        int[] nsr=new int[height.length];
        for(int i=height.length-1;i>=0;i--){
            while(!st.isEmpty()&&height[st.peek()]>=height[i]){
                st.pop();
            }
            if(st.isEmpty()){
                nsr[i]=-1;
            }else{
                nsr[i]=st.peek();
            }
            st.push(i);
        }
        int area=0;
        for(int i=0;i<height.length;i++){
            int pl=0;
            if(nsl[i]==-1){
                pl=0;
            }else{
                pl=nsl[i]+1;
            }
            int pr=0;
            if(nsr[i]==-1){
                pr=height.length-1;
            }
            else{
                pr=nsr[i]-1;
            }
            area=Math.max(area,height[i]*(pr-pl+1));
        }
        return area;
    }
    public int maximalRectangle(char[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return 0;
        }
        int[] height=new int[matrix[0].length];
        for(int i=0;i<matrix[0].length;i++){
            if(matrix[0][i]=='1'){
                height[i]=1;
            }
        }
        int result=solve(height);
        for(int i=1;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]=='1'){
                    height[j]+=1;
                }
                else{
                    height[j]=0;
                }
            }
            result=Math.max(result,solve(height));
        }
        return result;
    }
}