class Solution {
    public int residuePrefixes(String s) {
        HashSet<Character> set=new HashSet<>();
        int ans=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            set.add(ch);
            if((i+1)%3==set.size()){
                ans++;
            }
        }
        return ans;
    }
}