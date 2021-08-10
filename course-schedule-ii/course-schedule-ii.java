class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
         List<List<Integer>> graph  = build(numCourses, prerequisites);
        int[] visitedPath = new int[numCourses];
        List<Integer> ans = new ArrayList<Integer>();
        for(int i = 0 ; i < numCourses ; i++){
            if(visitedPath[i] == 0){
              if( dfs(i,ans,visitedPath,graph)){
                  int[] arr = {};
                  return arr ;
              }
            }
        }
        int[] arr = new int[numCourses];
        for(int i = 0 ;i < ans.size() ; i++){
            arr[i] = ans.get(i);
        }
        
        return arr;
    }
    // 1 -> visited and on path, 2 -> visited
    public boolean dfs(int v , List<Integer> ans , int[] visitedPath,List<List<Integer>> graph ){
        visitedPath[v] = 1 ;
        boolean cycle = false ;
        for(int i = 0 ; i < graph.get(v).size() ; i++ ){
            int neighbour = graph.get(v).get(i);
            if(visitedPath[neighbour] == 1){
                return true;
            }else{
                if(visitedPath[neighbour] == 0) // means not visited{
                cycle = cycle || dfs(neighbour, ans , visitedPath, graph);
                    if(cycle) return true ;
                }
            }
         ans.add(v);
         visitedPath[v] = 2 ;
        return cycle ;
        }
        
    public List<List<Integer>> build(int n , int[][] edges){
      List<List<Integer>> graph = new ArrayList<List<Integer>>();
        for(int i = 0 ; i < n ; i++){
            graph.add(new ArrayList<Integer>());
        }
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
        }
        return graph ;
    }
   // public List<Integer> dfs()
}