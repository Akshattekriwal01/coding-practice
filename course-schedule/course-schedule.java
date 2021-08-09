class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // kahns algorithm , return false if there is a cycle. 
        
        
        // we know that in khans algorithm there is a cycle if there is node with indegree!=0 at the end. 
        
        
        // time complexity is O(v+e)
        // space complexity is O(v)
        
        
        //[0-->1]
        //[1-->2]
        ArrayList<Integer>[] graph = new ArrayList[numCourses]; 
        for(int i = 0 ; i < numCourses ; i++){
            graph[i] = new ArrayList<Integer>() ;
        }
        
        int[] indegree = new int[numCourses]; 
        
        for(int i = 0 ; i < prerequisites.length ; i++){
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
           
        }
        for(int i = 0 ; i < numCourses ; i++){
            for(int v : graph[i]){
                indegree[v]++ ;
            }
        }
        
        Queue<Integer> q = new LinkedList<Integer>() ; 
        for(int i = 0 ; i <  indegree.length ; i++){
            if (indegree[i] == 0 ){
                q.add(i);
            }
        }
        
        int count = 0 ; 
        while(!q.isEmpty()){
            int rem = q.poll() ; 
            // answer is calculated here. 
            count++;
            for(int neighbour : graph[rem]){
                if(--indegree[neighbour] == 0){
                    q.add(neighbour); // add this relaxing node to the queue. 
                }
            }
            
        }
        return count == numCourses ;
    }
}