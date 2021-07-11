class Solution {
    public boolean isRobotBounded(String instructions) {
  
        int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
        int curr = 0;
        int x = 0 ; 
        int y = 0 ;

        for (int i =0 ; i< instructions.length() ; i++){
            char move = instructions.charAt(i);
            switch(move){
                case 'G':
                   x = x+dir[curr][0];
                   y = y+dir[curr][1];
                   break;
                case 'L':
                  curr=turnLeft(curr);
                      break;
                case 'R':
                  curr=turnRight(curr);
                      break;
            }
        }
      return (x ==0 && y==0) || (curr !=0 ); 
    }
 
    public int turnRight(int currentdir){
       return (currentdir+1) % 4 ;
    }
    public int turnLeft(int currentdir){
       return (currentdir-1 >=0) ? currentdir-1 : 3  ;
    }
}




/*

xxx
x x
xxx 
*/