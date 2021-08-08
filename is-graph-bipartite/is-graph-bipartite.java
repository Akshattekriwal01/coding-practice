class Solution {
    // remember when you get a graph in this form, the graph is already made for you. 
    public boolean isBipartite(int[][] graph) {
        // because this is a single source algorithm, we need to run it for all the sources. 
          int[] visited = new int[graph.length]; 
        Arrays.fill(visited, -1 ) ; // all are unvisited in the beggining; 
        
        for(int i = 0 ; i < graph.length ; i++){
            if(visited[i] == -1 ){
                boolean ans = isBipartite(graph, i , visited); 
                if(!ans) return false ;
            }
        }
        return true ; 
        
    }
    public boolean isBipartite(int[][] graph ,int src , int[] visited){
        Queue<Integer> q = new LinkedList<Integer>() ; 
      // jist of this question is to check if the current level color != color of node then it cannot be bipartite
        // if the graph doesnt have cycle then it cannot be bipartitie. 
        
        
    // let have 2 colors. red = 0 ans green = 1 ; ans univisted = -1 ; 
        // current color = (prevcolor + 1 ) % 2
        q.add(src);
        int colorOflevel = 0 ;
        while(!q.isEmpty()){
            int size = q.size() ; 
            while(size-- > 0){
                int rem = q.poll() ; 
                
                // already visited means there is a cycle.
                if(visited[rem] > -1){
                    if(colorOflevel != visited[rem] ){
                        // means the graph is non bipartite. 
                        return false ; // only one case when the graph is non bipartite when there is cycle of odd length;
                    }
                    continue; 
                }
                visited[rem] = colorOflevel ;
                
                for(int n : graph[rem]){
                    if(visited[n] == -1){
                        q.add(n);
                    }
                }
            }
            colorOflevel = (colorOflevel+1) % 2 ;
        }
        return true ;
    }
    // the test case where there is more than one connected component ;
    
}