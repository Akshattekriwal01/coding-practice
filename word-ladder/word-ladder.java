class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        boolean found = false ;
        for(String s : wordList){
            if(s.equals(endWord)) found = true;
            for(int i = 0 ; i < s.length() ; i++){
                String s1 = s.substring(0,i) + "*" + s.substring(i+1) ; 
                
                ArrayList<String> list = map.getOrDefault(s1, new ArrayList<String>());
                list.add(s) ;
                map.put(s1, list) ;
            }
        }
        if(!found) return 0;
    Set<String> visited = new HashSet<String>() ; 
    
    Queue<String> q = new LinkedList<String>() ; 
    visited.add(beginWord);
    q.add(beginWord);
    int count = 1 ; 
    while(!q.isEmpty()) {
        int len = q.size() ; 
        for(int i = 0 ; i < len ; i++){
            String s = q.poll() ;
            if( s.equals(endWord)){
                return count ; 
            }
            
            for(int k = 0 ; k < s.length() ; k++){
                
                String s2 = s.substring(0,k) + "*" + s.substring(k+1) ;
                if(map.containsKey(s2)){
                List<String> neighbours =  map.get(s2);
                 for(String n : neighbours){
                    if(!visited.contains(n)){
                        visited.add(n); 
                        q.add(n);
                    }   
                 }
              }
            } 
        }
        count++ ;
    }
     return 0 ;    
  }
}