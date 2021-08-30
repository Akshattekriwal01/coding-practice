class Solution {
    public int[] twoSum(int[] nums, int target) {
        Integer i = 0;        
        HashMap<Integer,Integer> map = new HashMap<>(); 
 
        while(i < nums.length) {
            if(map.containsKey(nums[i]))
               return new int[]{map.get(nums[i]).intValue(),i.intValue()};  

           Integer difference = target-nums[i];
        
           map.put(difference,i);
          i++;
    }

    return new int[]{};
    }
}