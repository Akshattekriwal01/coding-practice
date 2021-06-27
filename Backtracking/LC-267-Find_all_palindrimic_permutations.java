import java.util.*;
    class Solution {
        public List<String> generatePalindromes(String s) {
            // should have only one odd character. am'm'ma
            // can have any number even characters.  
            //take half of the even characters and make all it's permutation.
            
            // part 1
            // count character freq in  hashmap
            //  if even take half, if odd take freq/2
            List<String> al = new ArrayList<>();
            
            HashMap<Character,Integer> map = new HashMap<>();
            for(char c : s.toCharArray()){
                map.put(c,map.getOrDefault(c,0)+1);
            }
              StringBuilder str = new StringBuilder();  
            int oddCount = 0;
            String oddChar = ""; 
            for(char k : map.keySet()){
                int v = map.get(k);
                    int i = 0;
                if((v&1) != 0){
                    oddCount++;
                    oddChar = ""+k;
                }
                    while(i<v/2){
                        str.append(k);
                        i++;
                    }
            }
    
            if(oddCount > 1){
                return al; 
            }else{
                
                char[] arr = str.toString().toCharArray();
                Arrays.sort(arr);
                String st = String.valueOf(arr);
                    
                List<String> permutations = permute(st);
                int len = permutations.size();
                for(int i = 0 ; i<len ; i++ ){
                
               StringBuilder sb =  new StringBuilder(permutations.get(i));
                sb.reverse();
                
                StringBuilder sb1 =   new StringBuilder();
                    sb1.append(permutations.get(i));
                    sb1.append(oddChar);
                    sb1.append(sb);
                    al.add(sb1.toString());
                }
                return al;
            }
            // part2, find all the permutation of the above String. add the odd character, add reversersed permutation
        }
        public List<String> permute(String s){
            List<String> al = new ArrayList<>();
            helper(s,al,"");
            return al ;
        }
        public void helper(String s,List<String> al , String sofar){
            if(s.length() == 0 ) {
                al.add(sofar);
            }else{
                int len = s.length();
                String prev = "";
                for(int i = 0 ; i< len ; i++){
                    String sf = ""+s.charAt(i); 
                    if(!sf.equals(prev)){
                String remaining = s.substring(0,i)+s.substring(i+1);     // subtring function can also take input outside the length; 
                   //System.out.println(remaining);
                    helper(remaining, al, sofar+sf);
                    prev = sf;
                    }
                  
                }
            }
        }
    }
