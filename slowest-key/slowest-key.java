class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
            char slowest = keysPressed.charAt(0);
            int max = releaseTimes[0];
            for(int i = 1 ; i < releaseTimes.length ; i++){
                int diff = releaseTimes[i] - releaseTimes[i-1];
                if( diff > max ){
                    max = diff ; 
                    slowest = keysPressed.charAt(i);
                   
                }else if( diff == max){
                     slowest = (char)Math.max((int)slowest,(int)keysPressed.charAt(i));
                }
            }
        return slowest ;
    }
}