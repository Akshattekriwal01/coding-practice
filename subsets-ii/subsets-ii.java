class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        helper(nums,ans,new ArrayList<Integer>(), 0);
        return ans; 
    }
    public void helper(int[]nums , List<List<Integer>> ans , List<Integer> sofar, int start ){
        ans.add(new ArrayList<Integer>(sofar));
        for(int i = start ; i< nums.length ; i++ ){
            if(i>start && nums[i] == nums[i-1]) continue;
                sofar.add(nums[i]);
                helper(nums, ans, sofar, i+1 );
                sofar.remove(sofar.size()-1);
            }
    }
}