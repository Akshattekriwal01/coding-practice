/*
brute force generate all possible paranthesis of length 3 and checks which one is valid. 
number of b at any point cannot exceed number of a at that point. 
number of a cannot exceed n at any point ; 

aaabbb
ababab
aababb
aabbab
abaabb


abb x
aaaa x number a a exceeded 3
abaaa x
aabaa x
aaaba x
ababb x
aabbb x
ababaa x 
aabbaa x 
abaaba  x
aababa x
aaabba x
ababab valid
aabbab valid
abaabb valid
aababb valid
aaabbb valid
=========================================
N = 2
A=3
B=3
aaabbb


*/

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>(); 
        helper(ans , "(", n , 1 , 0);
        return ans;
    }
    public void helper(List<String> ans, String sofar, int n , int countA , int countB){
        if(sofar.length() == n*2){
            if (countA == n && countB == n){
                ans.add(sofar);
            }
            return ; 
        }else{
            if(countA < n){
            String s1 = sofar+"(";
            helper(ans,s1,n,countA+1,countB);
            }
          
            if(countB < countA){
            String s2 = sofar+")";
            helper(ans,s2,n,countA,countB+1);
            }
   
        }
        return ;
    }
}




































