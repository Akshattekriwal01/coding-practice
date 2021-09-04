class Solution {
    public int trap(int[] height) {
        int[] maxL = new int[height.length] ; 
        int l = 0 ; 
        for(int i = 0 ; i < height.length ; i++){
            if(l > height[i]){
                maxL[i] = l ;
            }else{
                maxL[i] = 0 ;
                l = height[i] ;
            }
        }
        int[] maxR = new int[height.length] ; 
        int r = 0 ; 
        
        for(int i = height.length - 1 ; i >= 0 ; i--){
            if(r > height[i]){
                maxR[i] = r ;
            }else{
                maxR[i] = 0 ;
                r = height[i] ; 
            }
        }
        int ans = 0 ; 
        
        for(int i = 0 ; i < height.length ; i++){
            int water = Math.min(maxL[i], maxR[i]) - height[i] ; 
            if(water > 0 )
                ans += water ;
        }
        return ans; 
        
     
    }
    
    public void disp(int[] arr){
        for(int n : arr){
            System.out.print(n+",");
        }
        System.out.println();
    }
}

//[4, 2,0, 5,3,2,5]
//[-1,4,4,-1,5,5,-1]
// 5  5  5   -1,  5 ,5,-1]
// understand that the water at ith building is min(maxL - maxR) - heigth(ith) ; 
// where maxL is maximum element to the left ;