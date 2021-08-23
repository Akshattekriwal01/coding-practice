class Solution {
    public void sortColors(int[] nums) {
        int i = -1 ; 
        int j = 0 ;
        int k = nums.length ; 
        
        while(j < k){
            if(nums[j] == 0){
              i++;
                swap(i,j,nums);  
                j++;
            }else if (nums[j] == 2){
               k--;
              swap(j,k,nums);
            }else{
              j++;  
            }
            
        } 
    }
    
    private void swap(int i, int j,int[] nums){
        int temp = nums[j] ; 
        nums[j] = nums[i] ; 
        nums[i] = temp ;
    }
}



/*


[0,0,2,1,1,2]
   1 
   2
             3


[-,p1)  0
[p1,p2) 1
[p2,p3) undefined
[p3,-) p2



*/