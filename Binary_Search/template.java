import java.util.*;

class template{
    // 1. Looking for target element in the sorted array
    public int template1(int[] nums , int target){
        int left = 0 ; int right = nums.length -1 ;

        while(left <= right){
            int mid = left + (right - left )/2;
            if(nums[mid]== target){
                return mid;
            }else if(nums[mid] > target){
                right = mid -1;
            }else {
                left = mid+1;
            }
        }
        return -1 ;// element not found in the array
    }

    // 2a. Looking for the first element that satisfies certain properties. 
    // [F,F,T,T,T] <- returns first occurance of True 
    public int template2a(int[] nums ){
        int left = 0 ; int right = nums.length-1; //! add +1 if the answer can be outside [left,right ] when none of the values in the boudry gives true;

        while(left < right ){
            int mid = left + (right - left)/2;  //!round down. 
            if(property(mid,nums)){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        // left == right so you can return anything it will work
        return left ; // returns n in case of [F,F,F,F,F] / returns n when what what you are looking for is not present in the array 
    }

    public boolean property(int i , int[] nums){
            // example find first occurance of non- smaller number than 7;
             return nums[i] >= 7;       
    }
    // 2b. Looking for the first element that satisfies certain properties. 
    // [F,F,T,T,T] <- returns first occurance of True 
    public int template2b(int[] nums ){
        int left = 0 ; int right = nums.length-1; //! add +1 if the answer can be outside [left,right ] when none of the values in the boudry gives true;

        while(left < right ){
            int mid = left + (right - left+1)/2;  //! ROUND UP WHEN doing mid-1 
            if(property(mid,nums)){
                left = mid;
            }else{
                right = mid-1;
            }
        }
        return left ; // returns n in case of [F,F,F,F,F] / returns n when what what you are looking for is not present in the array 
    }

}