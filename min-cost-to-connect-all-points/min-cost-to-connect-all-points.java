// minimum length of wire needed to connect all points

class Solution {
    int[] parent ; 
    public int minCostConnectPoints(int[][] points) {
        // MST using kruskal's algorithm ;
        
        ArrayList<int[]> edges = new ArrayList<int[]>() ;
        
        for(int i = 0 ; i < points.length ; i++ ){
            for(int j = i+1 ; j < points.length ; j++ ){
                int[] edge = { i , j , calcDistance(points[i], points[j])};
                edges.add(edge);
            }
        }
        parent = new int[points.length];
        for(int i = 0 ; i < points.length ; i++){
            parent[i] = i ;
        }
        
        Collections.sort(edges, (a,b) -> a[2]-b[2]);
        
        int cost = 0 ;
        
        for(int[] edge : edges){
           int p1 =  findParent(edge[0]);
           int p2 =  findParent(edge[1]);
            
            if(p1 != p2){
                parent[p1] = p2 ;
                cost += edge[2];
            }
        }
        return cost ;
    }
    
    private int findParent(int v){
        if(parent[v] == v) return v ;
        else{
            parent[v] = findParent(parent[v]);
            return parent[v];
        }
    }
    
    private int calcDistance(int[] p1 , int[] p2 ){
        return Math.abs(p1[0]- p2[0]) + Math.abs(p1[1] -  p2[1]);
    }
        
}

