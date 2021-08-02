import java.util.*; 
/*
 * Input: n = 6, edges = [[1, 4], [4, 5], [2, 3]], newEdges = [[1, 2, 5], [1, 3, 10], [1, 6, 2], [5, 6, 5]]
Output: 7
Explanation:
There are 3 connected components [1, 4, 5], [2, 3] and [6].
We can connect these components into a single component by connecting node 1 to node 2 and node 1 to node 6 at a minimum cost of 5 + 2 = 7.
*/

public class minCostAllNodes {
	public static void main(String[] args) {
		int[][] edges = {{1,4}, {4,5} ,{ 2,3}};
		int[][] newEdges = {{1,2,5} , {1,3,10} , { 1,6,2 }  ,{ 5,6,5} } ;
		int n = 6 ;
		System.out.println(cost(n ,edges, newEdges));
	}
	public static int cost(int n , int[][] edges, int[][] newEdges) {
		// rmwa ; 
		ArrayList<Edge>[] graph = new ArrayList[n+1];
		build(graph, edges, newEdges, n );
		// int { dest, anode , cost}
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) -> a[2] - b[2]);
		int totalCost = 0 ; 
		int[] arr = {1,0,0}; 
		pq.add(arr); 
		boolean[] visited = new boolean[n+1];
		visited[0] = true ; // at then end to check if all nodes were accessible
		//visited[1] = true ;
		while(!pq.isEmpty()) {
			int[] rem = pq.poll();
			if(visited[rem[0]]) continue ; 
			visited[rem[0]] = true ;
			totalCost += rem[2] ; 
			for(Edge neighbour : graph[rem[0]]) {
				if(!visited[neighbour.v]) {
					//visited[neighbour.v]= true  ; 
					int[] arr1 = {neighbour.v, rem[0] , neighbour.w};
					pq.add(arr1);
				}
			}
		}
		
		return totalCost ;
	}
	static class Edge{
		int v ; 
		int w ; 
		Edge(int v, int w){
			this.v = v ;
			this.w = w ;
		}
		public String toString() {
			return v+","+w;
		}
	}
	public static void build(ArrayList<Edge>[] graph , int[][] edges, int[][] newEdges ,int n) {
		for(int i = 0 ; i < graph.length ; i++) {
			graph[i] = new ArrayList<Edge>() ;
		}
		for(int[] arr : edges) {
			addEdge(graph , arr[0], arr[1] , 0 );
		}
		for(int[] arr : newEdges) {
			addEdge(graph , arr[0], arr[1] , arr[2] );
		}
		
		for(ArrayList<Edge> list : graph) {
			System.out.println(list);
		}
	}
	public static void addEdge(ArrayList<Edge>[] graph, int u , int v , int w) {
		graph[u].add(new Edge(v,w));
		graph[v].add(new Edge(u,w));
	}
}
