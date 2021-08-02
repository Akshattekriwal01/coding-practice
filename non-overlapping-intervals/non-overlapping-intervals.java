/*Explaination. 
so we understand that when 2 intervals overlap we have to remove one of them. which one would you remove?
Remove the one with longer finsih time. [may be just removing the one with longer finish time will make the remaining
intervals non-overlapping]

{all intervals} - {max compatible intervals} = minimum deleted intervals

*/
class Solution{
    public int eraseOverlapIntervals(int[][] intervals){
        // sort by finish time. 
           Comparator<int[]> myCompare = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        };
        Arrays.sort(intervals, myCompare ) ; 
        // total - nonOverlapping = intervals to be removed ; 
        int count = 0 ; // stores the min number of overlaping intervals. 
        /*
        ----------------------------------    <- Only remove this. the one with longer finish time. 
         ------
                --------
                          -------- 
                                    -----
        
        */
        int prevFinish = Integer.MIN_VALUE; 
        for(int i = 0 ; i < intervals.length ;i++){
            int currStart = intervals[i][0]; 
            int currFinish = intervals[i][1];
            if( currStart < prevFinish){
                count ++ ; 
                prevFinish = Math.min(prevFinish, currFinish); // remove the one with longer finsih time when 2 intervals overlap. 
            }else{
                prevFinish = currFinish ; 
            }
        }
       return count ;
      
    }
}

























