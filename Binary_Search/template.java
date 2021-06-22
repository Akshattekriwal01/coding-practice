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

    // 2. Looking for the first element that satisfies certain properties. 
    // [F,F,T,T,T] <- returns first occurance of True 
    public int template2(int[] nums ){
        int left = 0 ; int right = nums.length-1; //! add +1 if the answer can be outside [left,right ] when none of the values in the boudry gives true;

        while(left < right ){
            int mid = left + (right - left)/2;
            if(property(mid,nums)){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return left ; // returns n in case of [F,F,F,F,F]
    }

    public boolean property(int i , int[] nums){
            // example find first occurance of non- smaller number than 7;
             return nums[i] >= 7;       
    }

}