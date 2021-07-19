import java.util.HashMap;
import java.util.*;

/**Given a list of points, find the nearest points that shares either an x or a y coordinate with the queried point.
The distance is denoted on a Euclidean plane: the difference in x plus the difference in y.
Input
numOfPoints, an integer representing the number of points;
points, a list of strings representing the names of each point [i];
xCoordinates, a list of integers representing the X coordinates of each point[i];
yCoordinates, a list of integers representing the Y coordinates of each point[i];
numOfQueriedPoints, an integer representing the number of points queried;
queriedPoints, a list of strings representing the names of the queried points.
Output
Return a list of strings representing the name of the nearest points that shares either an x or a y coordinate with the queried point.
Example 1:
Input:
numOfPoints = 3
points = ["p1","p2","p3"]
xCoordinates = [30, 20, 10]
yCoordinates = [30, 20, 30]
numOfQueriedPoints = 3
queriedPoints = ["p3", "p2", "p1"]
Output:
["p1", NONE, "p3"]
Example 2:
Input:
numOfPoints = 5
points = ["p1", "p2","p3", "p4", "p5"]
xCoordinates = [10, 20, 30, 40, 50]
yCoordinates = [10, 20, 30, 40, 50]
numOfQueriedPoints = 5
queriedPoints = ["p1", "p2", "p3", "p4", "p5"]
Output
[NONE, NONE, NONE, NONE, NONE]
 * */


public class nearestCity {
	// make a map of point names and coordintes; 
	// traverse thrugh the map and store x cordinate if already found then store its name ; 
	//if already has a name then store x co-rdinate name that is closer.
	
	public static void main(String[] args) {
			String[] names = {"p1","p2","p3"};
			int[] xArr = {30, 20, 10};
			int[] yArr = {30, 20, 30};
			String[] queriedPoints = {"p3", "p2", "p1"};
			HashMap<String, Point> map = new HashMap<>();
			for(int i = 0 ; i < names.length; i++) {
				Point p = new Point(xArr[i],yArr[i]);
				map.put(names[i],p);
			}
			HashMap<Integer,String> xMap = new HashMap<>();
			HashMap<Integer,String> yMap = new HashMap<>();
			
			for(int i = 0 ; i < xArr.length; i++) {
				if(xMap.containsKey(xArr[i])) {
					String point = xMap.get(xArr[i]);
					Point p = smaller(names[i], point, )
				}else {
					xMap.put( xArr[i], names[i]);
				}
			}
			
		}
	
		
}
class Point {
	int x ; 
	int y ; 
	 Point(int x , int y ) {
		this.x =   x ; 
		this.y =   y ;
	}
}

// can i just  assume that i have this trivial api? i'll be happy to code at the end.
//being able to horizonatslly apply my skillset to another domain
// care about ability