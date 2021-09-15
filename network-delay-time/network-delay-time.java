class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        //{v,weight}
        ArrayList<int[]>[] graph = new ArrayList[n+1]; 
        for(int i = 0 ; i <= n ; i++){
            graph[i] = new ArrayList<int[]>();
        }
       for(int[] e : times){
           graph[ e[0] ].add(new int[]{e[1], e[2]}) ;
 
       }
        return calculator(graph, k);
    }
    
    public int calculator( ArrayList<int[]>[] graph , int k){
        // {vrx,wsf,parent}
        boolean visited[] = new boolean[graph.length];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> { return a[1] - b[1] ; });
        int distance[] = new int[graph.length];
        int parent[] = new int[graph.length] ;
        
        pq.add(new int[]{k,0}) ;
        parent[k] = -1 ;
        Arrays.fill(distance, (int)1e9) ;
        distance[k] = 0 ;
        
        while(!pq.isEmpty()){
            int[] rem = pq.poll() ;
            
            int vtx = rem[0] , wsf = rem[1];
           // System.out.println(vtx);
            if(visited[vtx] && distance[vtx] >= wsf) continue ;
            
            visited[vtx] = true ;
         
            
             //{vtx,weight}
            for(  int[] e :graph[vtx]){
                int neighbour = e[0]; 
                int weight = e[1];
                if(!visited[neighbour] && wsf + weight < distance[neighbour]){
                    distance[neighbour] = wsf + weight ;
                    parent[neighbour] = vtx ;
                    pq.add(new int[]{neighbour,wsf + weight });
                }
            }
            
        }
        int max = 0 ;
        for(int i = 1 ;  i < distance.length ; i++){
           // System.out.print(distance[i]);
            max = Math.max(max, distance[i]);
        }
        return max == (int)1e9 ? -1 : max  ;
    }
}