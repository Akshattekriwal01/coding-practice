class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        helper(ans, new ArrayList<Integer>(), k,n,1);
        return ans;
    }
    
    public void helper( List<List<Integer>> ans, List<Integer> sofar , int depth , int target, int index ){
       // System.out.println(sofar);
        if(depth == 0){
            if(target == 0){
                ans.add(new ArrayList<Integer>(sofar));
            }
            return ;
        }else{
            
            for(int i = index ; i <= 9 ; i++){
                if(target - i < 0){
                    break;
                }
                if(target - i >= 0){
                    sofar.add(i);
                    helper(ans,sofar,depth-1,target-i, i + 1);
                    sofar.remove(sofar.size()-1);
                }
                
            }
            return ;   
        }
    }
}