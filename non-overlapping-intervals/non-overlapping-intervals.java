/*
Given intervals below. 
----------
            -----       
                        -------
                           ------
                          --------
*/



/**
public int eraseOverlapIntervals(Interval[] intervals) {
    if (intervals.length == 0)
        return 0;
    Arrays.sort(intervals, new MyComparator());
    int count = 0;
    int end = intervals[0].end;
    for (int i =1; i < intervals.length; i++){
    
        if(intervals[i].start < end){
            count += 1;
        }
        else end = intervals[i].end;
    }
    return count;
    
}

*/

// one has to understand that when we the over lapping intervals get max non over lapping intervals .




// class Solution {
//     public int eraseOverlapIntervals(int[][] intervals) {
        
//         Arrays.sort(intervals, new Comparator<int[]> (){
//             public int compare(int[] a, int[] b){
//                 return Integer.compare(a[1],b[1]);
//             }
//         });

//         int count = 0; // basically couting overlapping intervals
//         int prevFinish = intervals[0][1];
//         for(int i = 1 ; i < intervals.length ; i++){
//             int currStart = intervals[i][0];
//             if(currStart < prevFinish){
//                 count++;
//             }else{
//                 prevFinish = intervals[i][1];  // make the current end as prev end only when curr start >= prevFinish. other 
//                                                 // wise there can be more intervals that overlap with previous interval;
//             }
           
//         }
//         return count ;
//     }
// }

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
        int prevFinish = intervals[0][1]; 
        for(int i = 1 ; i < intervals.length ;i++){
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




