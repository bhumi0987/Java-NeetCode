class Solution {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        if(tomatoSlices%2!=0){
            return new ArrayList<>();
        }
        int x=(tomatoSlices-2*cheeseSlices)/2;  
        int y=cheeseSlices-x;
        if(x<0||y<0){
            return new ArrayList<>();
        }
        return Arrays.asList(x,y);
    }
}