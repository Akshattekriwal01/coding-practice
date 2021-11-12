/*
 [[5,2],[5,4],[10,3],[20,1]]
                       i
    2+6+4+1  
  int lastFinishTime = 14;  
*/

class Solution {
    public double averageWaitingTime(int[][] customers) {
        double totalTime = 0.0 ; 
        int lastFinishTime = 0; 
        for(int i  = 0 ; i < customers.length; i++){
            if(customers[i][0] > lastFinishTime ){
                lastFinishTime = customers[i][0]  + customers[i][1];
            }else{
                  lastFinishTime += customers[i][1]  ; 
            }
          totalTime += (lastFinishTime - customers[i][0]) ;
        }
        return totalTime/customers.length ;
    }
}