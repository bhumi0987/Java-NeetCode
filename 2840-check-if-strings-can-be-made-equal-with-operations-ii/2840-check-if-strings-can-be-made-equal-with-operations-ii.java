class Solution {
    public boolean checkStrings(String s1, String s2) {
        ArrayList<Character> even=new ArrayList<>();
        ArrayList<Character> odd=new ArrayList<>();
        ArrayList<Character> even1=new ArrayList<>();
        ArrayList<Character> odd1=new ArrayList<>();
        int n=s1.length();
        for(int i=0;i<n;i++){
            if(i%2==0){
                even.add(s1.charAt(i));
                even1.add(s2.charAt(i));
            }else{
                odd.add(s1.charAt(i));
                odd1.add(s2.charAt(i));
            }
        }
        Collections.sort(even);
        Collections.sort(odd);
        Collections.sort(even1);
        Collections.sort(odd1);
        return even.equals(even1)&&odd.equals(odd1);
    }
}