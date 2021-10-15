// send 2n people to A 
// see what would be the savings if you sent all of them to B
// sort the savings and get refund for the first N
class Solution {
    public int twoCitySchedCost(int[][] costs) {
        
        int totalCost = 0 ; 
        for(int i = 0 ; i < costs.length ; i++){
            totalCost += costs[i][0] ;
        }
        
        int[] savings = new int[costs.length]; 
        for(int i = 0 ; i < costs.length ; i++){
            savings[i] = -1* (costs[i][0] - costs[i][1]);
        }
        Arrays.sort(savings); 
        
        for(int i = 0 ;   i < costs.length /2 ; i++){
            totalCost += savings[i];
        }
        return totalCost ;
    }
}