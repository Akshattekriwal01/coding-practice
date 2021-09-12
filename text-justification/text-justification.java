class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<String>() ;
      
        List<String> temp = new ArrayList<String>();
        int currLength  = 0 ; 
        int i = 0 ;
        while( i < words.length ){
            if( (temp.size() > 0 && currLength + words[i].length() + 1 > maxWidth) || currLength + words[i].length() > maxWidth){
                int totalLength = currLength ;
                int numOfWord = 0 ; 
                for(String s : temp){
                    numOfWord++ ; 
                }
                int numRequiredSpace = numOfWord - 1 ;
                int totalSpace = maxWidth - totalLength + (numOfWord - 1); 
             //   System.out.println(totalLength);
                int[] spaceCount = new int[numRequiredSpace] ;
                if(numRequiredSpace > 0 ){
                    Arrays.fill(spaceCount, totalSpace / numRequiredSpace) ;
                    totalSpace = totalSpace % numRequiredSpace ;
                    int j = 0 ;
                    while(totalSpace != 0 ){
                        spaceCount[j]++ ;
                        totalSpace -- ;
                        j++; 
                    }
                }  
                String s = temp.get(0) ; 
                for(int m = 1 ; m < temp.size(); m++){
                    for(int k = 0 ; k < spaceCount[m-1]  ; k++){
                        s += " " ;
                    }
                    s += temp.get(m);
                }
                if(numRequiredSpace == 0){
                     int remainingSpace = maxWidth - s.length(); 
                        while(remainingSpace != 0 ){
                            s+=" ";
                            remainingSpace -- ;
                        }
                }
                ans.add(s);
                temp.clear();
                currLength = 0 ;
            }
            
                temp.add(words[i]);
                currLength += words[i].length(); 
                if(temp.size() > 1 ){
                    currLength ++ ;
                }  
            i++ ;
        }
        
         String s = temp.get(0);
        
             for(i = 1 ;i < temp.size() ; i++){
                 s+=(" "+ temp.get(i));
             }
        int remainingSpace = maxWidth - s.length(); 
            while(remainingSpace != 0 ){
                s+=" ";
                remainingSpace -- ;
            }
        ans.add(s);
        return ans;
    }
}