class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        //[a,y] a boxes oftype 0 with y boxes in each; 
        // maximize units. minimuze boxes 
        
        Comparator<int[]> comp = new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return -1*Integer.compare(a[1],b[1]);
            }
        };
        Arrays.sort(boxTypes,comp);
        int totalBoxes = 0 ; 
        int  totalUnits = 0 ;
        int i = 0 ;
        while(i < boxTypes.length ){
            while( boxTypes[i][0] > 0 && (totalBoxes + 1) <=  truckSize ){
                totalUnits += boxTypes[i][1];
                boxTypes[i][0]-- ; 
                totalBoxes++ ;
            }
            if(totalBoxes == truckSize) break ;
            
            i++ ; 
        }
        return totalUnits;
    }
}