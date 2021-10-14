class Solution {
    public int firstUniqChar(String s) {
       HashMap<Character, Integer> map = new HashMap<>(); 
        for(int i = 0 ; i < s.length(); i++){
            char ch = s.charAt(i);
            if(!map.containsKey(ch)){
                map.put(ch, i);
            }
        }
        
        HashMap<Character, Integer> map2 = new HashMap<>(); 
         for(int i = 0 ; i < s.length(); i++){
                char ch = s.charAt(i);
             if(map2.containsKey(ch)){
                map2.put(ch, map2.get(ch) + 1);
            }else{
                 map2.put(ch, 1);
             }
        }
        
        int min = 1000000 ;
        System.out.println(map2);
        System.out.println(map);
        for( Character ch : map2.keySet()){
            if(map2.get(ch) == 1){
                min = Math.min(min , map.get(ch));
            }
        }
        if(min == 1000000) return -1 ;
        return min ;
        
        
    }
}