class Solution {
    public boolean isReachable(int targetX, int targetY) {
        if(targetX%2==0){
            return isReachable(targetX/2,targetY);
        }
        else if(targetY%2==0){
            return isReachable(targetX,targetY/2);
        }
        else if(targetX>targetY){
            return isReachable(targetX-targetY,targetY);
        }
        else if(targetY>targetX){
            return isReachable(targetX,targetY-targetX);
        }
        return targetX==1&&targetY==1;
    }
}