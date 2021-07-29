/* https://leetcode.com/discuss/interview-question/373006
 * 
 * 
 * Given a map Map<String, List<String>> userSongs with user names as keys and a list of all 
 * the songs that the user has listened to as values.

Also given a map Map<String, List<String>> songGenres, with song genre as keys and a 
list of all the songs within that genre as values. The song can only belong to only one genre.


 

Example 1:

Input:
userSongs = {  
   "David": {"song1", "song2", "song3", "song4", "song8"},
   "Emma":  {"song5", "song6", "song7"}
},
songGenres = {  
   "Rock":    ["song1", "song3"],
   "Dubstep": ["song7"],
   "Techno":  ["song2", "song4"],
   "Pop":     ["song5", "song6"],
   "Jazz":    ["song8", "song9"]
}
Output: {  
   "David": {"Rock", "Techno"},
   "Emma":  {"Pop"}
}

Explanation:
David has 2 Rock, 2 Techno and 1 Jazz song. So he has 2 favorite genres.
Emma has 2 Pop and 1 Dubstep song. Pop is Emma's favorite genre.
Example 2:

Input:
userSongs = {  
   "David": {"song1", "song2"},
   "Emma":  {"song3", "song4"}
},
songGenres = {}

Output: {  
   "David": {},
   "Emma":  {}
}
The task is to return a map Map<String, List<String>>, where the key is a user name and 
the value is a list of the user's favorite genre(s). Favorite genre is the most listened to genre. 
A user can have more than one favorite genre if he/she has listened to the same number of songs 
per each of the genres.

map song to genre; 
for every user make a count map
count and maintian max genre. 
iterate through count and add the max genres to a map; 


 * */
import java.util.* ;
public class musicGenres {
	public static void main(String[] args) {
		Map<String, List<String>> userMap = new HashMap<String, List<String>>();
		Map<String, List<String>> genreMap =  new HashMap<String, List<String>>();
		List<String> al = new ArrayList<String>() ; 
		String[] arr = {"song1", "song2", "song3", "song4", "song8"};
		al.addAll(Arrays.asList(arr));
		userMap.put("David", new ArrayList<String>(al));
		String[] arr1 =  {"song5", "song6", "song7"} ;
		al.clear() ; 
		al.addAll(Arrays.asList(arr1));
		userMap.put("Emma", new ArrayList<String>(al));
		
		String[] arr2 =    {"song1", "song3"};
		String[] arr21 =  {"song7"};
		String[] arr22 =   {"song2", "song4"};
		String[] arr23 =     {"song5", "song6"};
	    String[] arr24 =    {"song8", "song9"};
	    al.clear();
	    al.addAll(Arrays.asList(arr2));
	    genreMap.put("Rock",new ArrayList<String>(al));
	    al.clear();
	    al.addAll(Arrays.asList(arr21));
	    genreMap.put("Dubstep",new ArrayList<String>(al));
	    al.clear();
	    al.addAll(Arrays.asList(arr22));
	    genreMap.put("Techno",new ArrayList<String>(al));
	    al.clear();
	    al.addAll(Arrays.asList(arr23));
	    genreMap.put("Pop",new ArrayList<String>(al));
	    al.clear();
	    al.addAll(Arrays.asList(arr24));
	    genreMap.put("Jazz",new ArrayList<String>(al));
	    genreMap.clear();
	    System.out.println(favoritegenre(userMap,genreMap));
	}
	
	/*

for every user make a count map of genre
count and maintian max genre. 
iterate through count and add the max genres to a map; 

HANLDE EDGE CASES; 
	 * 
	 * 
	 * */
	 public static Map<String, List<String>> favoritegenre(Map<String, List<String>> userMap, Map<String, List<String>> genreMap) {
		 Map<String, List<String>> ans = new HashMap<String, List<String>>();
		 
		 Map<String, String> genreOfSong = new HashMap<String, String > () ;
		 
		 for(String key : genreMap.keySet()) {
			 List<String> songs = genreMap.get(key); 
			 for(String song : songs) {
				 if(!genreOfSong.containsKey(song)) {
					 genreOfSong.put(song, key);
				 }
			 } 
		 }
		 for(String user : userMap.keySet()) {
			
			 ans.put(user, new ArrayList<String>());
			 
			 Map<String, Integer> countGenre = new HashMap<String, Integer>() ; 
			 int max = -1  ;
			 List<String> songs = userMap.get(user);
			 // frequency of max genre found ;
			 for(String song : songs) {
				 String genre  = genreOfSong.get(song) ;
				 if(genre == null) continue; // If the song doesnt belong to any genre then this can be null ;
				 int count = countGenre.getOrDefault(genre, 0) + 1 ;
				 countGenre.put(genre,count );
				 max = Math.max(max,  count );	 
			 }
			
			 for(String genre : countGenre.keySet()) {
				
				 if(countGenre.get(genre) == max) {
					 System.out.println(countGenre);
					 ans.get(user).add(genre);
				 }
			 }
			
			 
		 }
		 
		 
		 return ans ;
	 }
}












/*	leetcode solution ;
 * class Solution {
   public Map<String, List<String>> favoritegenre(Map<String, List<String>> userMap, Map<String, List<String>> genreMap) {
   	Map<String, List<String>> res = new HashMap<>();
   	Map<String, String> songstogenre = new HashMap<>();
   	
   	for(String genre : genreMap.keySet()) {
   		List<String> songs = genreMap.get(genre);
   		for(String song : songs) {
   			songstogenre.put(song, genre);
   		}
   	}
       Map<String, Integer> count = new HashMap();
   	int max = 0;
   	for(String user : userMap.keySet()) {
           count = new HashMap();
           max = 0;
           res.put(user, new ArrayList());
   		List<String> songs = userMap.get(user);
   		for(String song : songs) {
   			String genre = songstogenre.get(song);
   			int c = count.getOrDefault(genre, 0) + 1;
   			count.put(genre, c);
               max = Math.max(c, max);
   		}
           for (String key : count.keySet()) {
               if (count.get(key) == max) {
                   res.get(user).add(key);
               }
           }
   	}
   	return res;
   }
}*/



































