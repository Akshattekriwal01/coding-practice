class Solution {
    public int[] arrayRankTransform(int[] arr) {
        // make a hashmap element - [position array];
        // iterate hashmap and put in minheap,
        // pop assign rank and set in the array ;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        HashMap<Integer, List<Integer> > map = new HashMap<Integer, List<Integer>>();
        for(int i = 0 ; i < arr.length ; i++){
            if(map.containsKey(arr[i])){
                List<Integer> list = map.get(arr[i]);
                list.add(i);
                map.put(arr[i],list);
            }else{
                List<Integer> ll = new ArrayList<Integer>() ;
                ll.add(i);
                map.put(arr[i], ll);
            }
        }
        
        for(int n : map.keySet()){
            pq.add(n);
        }
        
        int rank = 1 ;
        while(!pq.isEmpty()){
            int n = pq.poll(); 
            List<Integer> list = map.get(n);
            for(int k : list){
                arr[k] = rank;
            }
            rank++;
        }
        return arr ;
    }
}