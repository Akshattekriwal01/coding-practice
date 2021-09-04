class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> al = new ArrayList<>() ;
        helper(al, "(", 1 , 0, n);
        return al;
    }
    
    void helper(ArrayList<String> al , String sofar , int countA, int countB, int n ){
        
        if(countB > countA){
            return ;
        }else if(sofar.length() == 2*n ){
            al.add(sofar);
            return ;
        }else{
            
            if(countA< n)
             helper(al, sofar+"(", countA+1, countB,n);
            
            
            helper(al, sofar+")", countA , countB+1,n) ;
            
            return ;
            
        }
        
    }
}


/*
given n a's and n b's i have to pemute them such that at ith poitions number of a's >= b's ;

aaabbb
aababb
aabbab
abaabb
ababab


*/