// Run time of Constructor is O(n),next and hasnext take constant time
// space complexity is O(n).

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
           List<Integer> al ;
        int count ;
    public NestedIterator(List<NestedInteger> nestedList) {
        al = new ArrayList<Integer>();
        count = 0;
         helper(nestedList);
        
    }
     public void helper(List<NestedInteger> nestedList){
          if(nestedList.size() == 0){
              
          }else{
                for(int i = 0 ; i < nestedList.size(); i++){
                    if(nestedList.get(i).isInteger()){
                  al.add(nestedList.get(i).getInteger());
                    }else{
                        helper(nestedList.get(i).getList());
                    }
                }         
          }
      }

    @Override
    public Integer next() {
         return al.get(count++);
    }

    @Override
    public boolean hasNext() {
       return count < al.size();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
