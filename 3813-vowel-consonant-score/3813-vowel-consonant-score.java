class Solution {
    public int vowelConsonantScore(String s) {
        HashSet<Character> set=new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        HashSet<Character> set1=new HashSet<>();
        set1.add('b');
        set1.add('c');
        set1.add('d');
        set1.add('f');
        set1.add('g');
        set1.add('h');
        set1.add('j');
        set1.add('k');
        set1.add('l');
        set1.add('m');
        set1.add('n');
        set1.add('p');
        set1.add('q');
        set1.add('r');
        set1.add('s');
        set1.add('t');
        set1.add('v');
        set1.add('w');
        set1.add('x');
        set1.add('y');
        set1.add('z');
        int v=0;
        int c=0;
        for(char ch:s.toCharArray()){
            if(set.contains(ch)){
                v++;
            }else if(set1.contains(ch)){
                c++;
            }
        }
        return c>0?(int)Math.floor(v/c):0;
    }
}