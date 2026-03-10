class Solution {
    public int min;
    public void solve(int[] count,int[] count1){
        for(int i=1;i<26;i++){
            int chng=0;
            for(int j=i;j<26;j++){
                chng+=count[j];
            }
            for(int j=0;j<i;j++){
                chng+=count1[j];
            }
            min=Math.min(min,chng);
        }
    }
    public int minCharacters(String a, String b) {
        int n=a.length();
        int m=b.length();
        int[] count=new int[26];
        int[] count1=new int[26];
        for(int i=0;i<n;i++){
            count[a.charAt(i)-'a']++;
        }
        for(int i=0;i<m;i++){
            count1[b.charAt(i)-'a']++;
        }
        min=n+m;
        for(int i=0;i<26;i++){
            min=Math.min(min,n+m-count[i]-count1[i]);
        }
        solve(count,count1);
        solve(count1,count);
        return min;
    }
}