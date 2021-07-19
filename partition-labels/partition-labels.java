class Solution {
    public List<Integer> partitionLabels(String s) {
      
        Map<Character,Pair> map = new LinkedHashMap<Character,Pair>() ; // maintains the order of insertion./ sorted by begining
        List<Integer> ans = new ArrayList<Integer>(); 
        for(int i = 0 ; i < s.length(); i++){
          char c = s.charAt(i);
            if(map.containsKey(c)){
                Pair p = map.get(c);
                p.end = i ; 
                map.put(c,p);
            }else{
                map.put(c,new Pair(i,i));
            }
        }
        
        // merge intervals ; 
        int i = 0 ; 
        int start = 0 ; 
        int prevFinish = 0 ; 
        
        for(Map.Entry<Character,Pair> entry : map.entrySet()){
            if(i == 0 ){
                start = entry.getValue().start;
                prevFinish = entry.getValue().end ;
            }else{
                int newStart = entry.getValue().start ;
                int finish = entry.getValue().end;
                if(newStart <= prevFinish){
                    prevFinish = Math.max(prevFinish,finish);   //the catch is here in merging
                }else{
                    ans.add(prevFinish-start+1);
                    start = newStart ; 
                    prevFinish = finish;
                }
            }
            i++;
        }
        ans.add(prevFinish - start + 1 );
        return ans;
        }
}
public class Pair{
    
    int start ; 
    int end ;
    Pair(int start, int end){
        this.start = start ; 
        this.end = end;
    }
}
