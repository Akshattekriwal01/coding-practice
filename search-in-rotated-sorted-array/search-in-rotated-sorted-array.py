class Solution:
    def search(self, nums: List[int], target: int) -> int:
        pivot = self.findPivot(nums, target)
        if(pivot == len(nums) - 1 ):
            return self.bs(0,len(nums)-1, nums, target)
        if(target < nums[0]):
            return self.bs(pivot+1, len(nums)-1, nums, target)
        else:
            return self.bs(0, pivot, nums, target)
        
    
    def bs(self, left, right, nums, target):
       # print("l",left,right)
        while(left <= right): 
            mid = left + (right - left) // 2 
           # print(mid)
            if(nums[mid] == target):
                return mid
            elif(nums[mid] > target):
                right = mid - 1 
            else:
                left = mid + 1
            
        return -1 
        
        
    def findPivot(self,nums, target):
        left = 0 
        right = len(nums) - 1
        while(left < right):
            mid = left + (right - left + 1)//2
            if(nums[mid] >= nums[0]):
                left = mid 
            else:
                right = mid - 1 
        return left
        
        '''
        tempAns = 7
         f  f   f   f     t.   t. f.  f. f
        [4, 5 , 6, 6.2, 6.5 , 7, 0 , 1, 2]
        [4,1,2,3]
              
        '''