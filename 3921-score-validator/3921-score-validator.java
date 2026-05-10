class Solution {
    public int[] scoreValidator(String[] events) {
        int count=0;
        int score=0;
        for(String s:events){
            if(s.equals("1")){
                score+=1;
            }else if(s.equals("2")){
                score+=2;
            }else if(s.equals("3")){
                score+=3;
            }else if(s.equals("4")){
                score+=4;
            }else if(s.equals("6")){
                score+=6;
            }else if(s.equals("W")){
                count+=1;
            }else if(s.equals("WD")){
                score+=1;
            }else if(s.equals("NB")){
                score+=1;
            }
            if(count==10){
                break;
            }
        }
        return new int[]{score,count};
    }
}