class Solution {
    int[] parent; 
    public boolean equationsPossible(String[] equations) {
    parent = new int [26];
    
    for(int i = 0 ; i < 26 ; i++){
        parent[i] = i;
    }
        
    for(String equation : equations){
        char a = equation.charAt(0);
        char b = equation.charAt(3);
        if(equation.charAt(1) == '='){
            int p1 = findParent(a - 'a');
            int p2 = findParent(b - 'a');
            if(p1 != p2)
                merge(p1,p2);
        }
    }
        
    for(String equation : equations){
         char a = equation.charAt(0);
        char b = equation.charAt(3);
        if(equation.charAt(1) == '!'){
            if(findParent(a-'a') == findParent(b-'a')){
                return false ;
            }
        } 
    }
        return true ;
    }
    
    private void merge(int p1, int p2){
        if( p1 < p2){
            parent[p2] = p1 ;
        }else{
            parent[p1] = p2 ;
        }
    }
    private int findParent(int v){
       if(parent[v] == v) return v ;
        else{
            // path compression, inverse ackerman function
            parent[v] = findParent(parent[v]) ;
            return parent[v];
        }
    }
}