class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left= 0 ; 
        // we are finding the left boud of our anwer, if left bound > k then we dont have enough elements for our answers. 
        int right = arr.length - k ; 
        
        while(left < right ){
            int mid = left + ((right - left )/2);
            if(property(mid,arr,k,x)){
                right = mid ; 
            }else {
                left = mid + 1 ;
            }
       }
        List<Integer> al = new ArrayList<Integer>();
        for (int i = left ; i< left+k ; i++){
            al.add(arr[i]);
        }
        return al;
    }
    public boolean property(int mid , int[] arr, int k , int x ){
        //either arr[mid] is ans, or arr[mid+k], which ever is closer to x
        // think like 
        if( x-arr[mid] <= arr[mid+k]-x ){
            return true;
        }else
            return false;
    }
}