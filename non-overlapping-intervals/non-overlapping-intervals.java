/*Explaination. 
so we understand that when 2 intervals overlap we have to remove one of them. which one would you remove?
Remove the one with longer finsih time. [may be just removing the one with longer finish time will make the remaining
intervals non-overlapping]

{all intervals} - {max compatible intervals} = minimum deleted intervals

*/
class Solution{
    public int eraseOverlapIntervals(int[][] intervals){
        // sort by finish time. 
        Arrays.sort(intervals, (a,b) -> a[1]-b[1] ) ; 
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
        
        // Alternatively {all intervals} - {max compatible intervals} = minimum deleted intervals
        
        /*
        count = 0 ;
        int prevFinish = intervals[0][1]; 
        for(int i = 1 ; i < intervals.length ;i++){
            int currStart = intervals[i][0]; 
            int currFinish = intervals[i][1];
            if( currStart < prevFinish){
                
                prevFinish = Math.min(prevFinish, currFinish); // remove the one with longer finsih time when 2 intervals overlap. 
            }else{
                count ++ ;
                prevFinish = currFinish ; 
            }
        }
       return intervals.length - count - 1; 
       */
        /*
        int end = intervals[0].end;
        int count = 1;        

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start >= end) {
                end = intervals[i].end;
                count++;
            }
        }
        return intervals.length - count;
    }
        */
    }
}

























