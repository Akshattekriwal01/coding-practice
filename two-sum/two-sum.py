class Solution:
    def twoSum(self, nums: List[int], target: int):
        mapp = dict()
        
        for i in range(len(nums)):
            if(target - nums[i] in mapp):
                return [i, mapp[target-nums[i]]]
            else:
                mapp[nums[i]] = i
            
        
        