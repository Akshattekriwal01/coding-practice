class Solution {
    public int lengthOfLongestSubstring(String s) {
       int j = 0 ; 
       int i = 0 ; 
        int count = 0 ;
        int max = 0 ;
        Map<Character, Integer> map = new HashMap<Character, Integer>(); 
        while(j < s.length()){
            char ch = s.charAt(j);
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch)+1);
                ++count ;
            }else{
                map.put(ch, 1);
            }
           
          // System.out.println(count);
            
            while(count > 0 ){
                char c = s.charAt(i);
                if(map.get(c) > 1){
                     map.put(c, map.get(c) - 1); 
                    count-- ;
                }else{
                    map.remove(c);
                }
              i++;  
            }
            
            max = Math.max(max, j-i+1);
            
            j++;
        }
        return max ;
    }
}

