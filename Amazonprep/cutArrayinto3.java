import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
//https://leetcode.com/discuss/interview-question/976039/amazon-oa-load-balancer
/*
"""
Your server has received a package of N incoming requests. Handling the K-th request 
(for K from 0 to N − 1) will take A[K] seconds.
The load balancer has to drop two acquired requests and distribute the rest of them 
between three workers in such a way that each worker receives a contiguous fragment of 
requests to handle, and finishes handling them in exactly the same moment as the other 
workers. No two workers should receive the same request to compute.
The load balancer's distribution of requests is performed by selecting two requests that
 will be dropped, and which will split the array into three contiguous parts that will 
 be allocated to the workers. More precisely, if requests 2 and 5 are chosen by the 
 load balancer from a package of 9 requests, then:
the 0-th to 1-st requests will be handled by the first worker,
the 3-rd to 4-th requests will be handled by the second worker,
the 6-th to 8-th requests will be handled by the third worker.
Such a distribution will be correct if each worker receives requests equalling the 
same total amount of handling time.
Write a function solution that, given an array A of N integers representing the time
 of execution of consecutive tasks, returns true if it is possible for the load balancer
  to choose two requests that will determine an even distribution of requests among three 
  workers, or false otherwise.
Examples:
Given A = [1, 3, 4, 2, 2, 2, 1, 1, 2], the function should return true, as choosing 
requests 2 and 5 results in a distribution giving 4 seconds of handling time to each
 worker, as explained in the following image:
image
Given A = [1, 1, 1, 1, 1, 1], the function should return false.
Given A = [1, 2, 1, 2, ..., 1, 2] of length 20,000, the function should return true.
Write an efficient algorithm for the following assumptions:
N is an integer within the range [5..100,000];
each element of array A is an integer within the range [1..10,000].
"""
 * */
public class cutArrayinto3 {
    public static void main(String args[]) { 
//	int[] arr = {2, 4, 5, 3, 3, 9, 2, 2, 2};
    	int[] arr1 = {2, 4, 5, 3, 3, 9, 2, 2, 2};
    	int[] arr2 = {1, 1, 1, 1, 1, 1};
    	assertEquals(true, balance(arr1));
    	assertEquals(false, balance(arr2));
    
}
    // 2pointer -
    public static boolean balance(int[] arr) {
    int lSum = arr[0] ; 
    int rSum = arr[arr.length - 1] ;
    	
    int l = 1 ;
    int r = arr.length - 2 ;
    int total = Arrays.stream(arr).sum();
    while(l < r) {
	    int midSum = total - lSum - arr[l] - rSum - arr[r];
	    	if(midSum == lSum && lSum == rSum) {
	    		return true;
	    	}else if(lSum <= rSum){
	    		lSum += arr[l] ;
	    		l++;
	    	}else {
	    		rSum += arr[r] ; 
	    		r-- ;
	    	}
    	}
    return false;
    }
}
/* https://github.com/Akshattekriwal01/leetcode/blob/master/Amazon%20OA.%20Load%20Balancer.py
 *     def canBalance(self, requests: List[int]) -> bool:
        total = sum(requests)
        lsum, rsum = requests[0], requests[-1]
        l, r = 1, len(requests) - 2
        while l < r:
            msum = total - lsum - rsum - requests[l] - requests[r]
            if msum < min(lsum, rsum):
                return False
            elif lsum == rsum == msum:
                return True
            elif lsum <= rsum:
                lsum += requests[l]
                l += 1
            else:
                rsum += requests[r]
                r -= 1
        return False

 * 
 * */
/* Solution from leetcode
import java.util.*;

public class Solution {
	public boolean loadBalance(int[] arr) {
		int sum = 0;
		int len = arr.length;
		if(len < 5){
		    return false;
		}
		for(int i =0;i<len;i++) {
		    sum += arr[i];
		}
		int prefixSum = arr[0], suffixSum = arr[len-1];
		int left = 1, right = len - 2;
		boolean flag = false;
		while(left < right - 1) {
		    int midSum = sum - prefixSum - suffixSum - arr[left] - arr[right];
		    if(prefixSum == midSum && suffixSum == midSum) {
		        flag = true;
		        break;
		    } else {
		        if(prefixSum < suffixSum) {
		            prefixSum += arr[left];
		            left++;
		        } else if(prefixSum > suffixSum) {
		            suffixSum += arr[right];
		            right--;
		        } else {
		            prefixSum += arr[left];
		            suffixSum += arr[right];
		            left++;
		            right--;
		        }
		    }
		}
		return flag;
	}
}
*/