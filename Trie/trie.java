package Trie;

class Trie {

    final private Node root;  
    //final because it wont change, and also cannot be accessed from any where else. 
    public Trie() {
        root = new Node();
    }
    
    // because the word length can be huge 2000, we should not do this recursively.
    public void insert(String word) {
        if(word == null|| word.length() == 0){return ;}
        Node curr = root; // reference variable;
        int i = 0;
        while(i<word.length()){
            char c = word.charAt(i);
            if(!curr.hasChild(c)){
                curr.addChild(c);
            }
            curr = curr.getChild(c);
            ++i;
        }
        curr.markEnd();
        
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node curr = root;
       
        for(int i =0 ; i < word.length() ; i++){
           char ch = word.charAt(i) ;
           if(curr.getChild(ch)!= null){
               curr = curr.getChild(ch);
           }else return false;
        }
        return curr.isEnd();
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node curr = root;
        for(int i= 0 ; i < prefix.length(); i++){
          char ch = prefix.charAt(i) ;
           if(curr.getChild(ch)!= null){
               curr = curr.getChild(ch);
           }else return false; 
        }
        return true;
    }
}

    class Node{
     private Node[] children;
     private boolean end ;
        
     public Node(){
        children = new Node[26];
        end = false;
     }
     public void addChild(char ch){
         children[ch - 'a'] = new Node();
     }
     public boolean hasChild(char ch){
      return children[ch-'a'] == null ? false : true;  
    } 
     public Node getChild(char ch){
         return children[ch-'a'] ;
     }
     public void markEnd() {
         end = true;
     } 
     public boolean isEnd(){
         return end ;
     }
   }


