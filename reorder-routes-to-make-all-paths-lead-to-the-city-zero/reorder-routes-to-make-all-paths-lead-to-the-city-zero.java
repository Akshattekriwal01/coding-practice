class Solution {
    public int minReorder(int n, int[][] connections) {
        int answer = 0 ; 
        // neighbours are all the nodes who either connect to you or you connect to them . 
        ArrayList<Edge>[] graph = new ArrayList[n] ;
        for(int i = 0 ; i < n ; i++){
            graph[i] = new ArrayList<Edge>() ; 
        }
        boolean visited[] = new boolean[n] ; 
        for(int[] edges : connections){
            int src = edges[0] ; 
            int dest = edges[1] ; 
            graph[src].add(new Edge(dest,1));
            graph[dest].add(new Edge(src,-1));
        }
        
        Queue<Integer> q = new LinkedList<>(); 
        q.add(0) ; 
        visited[0] = true ;
        while(!q.isEmpty()){
            int rem =  q.poll() ; 
            
            for(Edge e : graph[rem]){
                if(!visited[e.v]){
                    visited[e.v] = true ;
                    if(e.dir > 0 ){ // means there is an outgoing edge to the neighbour
                        answer ++ ;
                    }else{  // means there is an incomming edge to the neighbour ;

                    }
                    q.add(e.v);
                }
            }
        }
        return answer ;
    }
    class Edge{
        int v ;
        int dir ; 
        
        // 1 for incomming 
        //-1 for outgoing 
        
        public Edge(int v, int dir){
            this.v = v ; 
            this.dir = dir ;
        }
    }
}

