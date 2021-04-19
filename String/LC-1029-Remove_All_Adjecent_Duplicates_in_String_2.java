//O(n) - 25 mins
class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Integer> reps = new Stack<Integer>();
        Stack<Character> chars = new Stack<Character>();
        char[] str = s.toCharArray();
        int rep = 1;
        chars.push(str[0]);
        reps.push(rep);
        int i = 1;
        while(i<str.length){
            if(!chars.empty() && str[i] == chars.peek()){
                  chars.push(str[i]);
                    reps.push(reps.peek() + 1); 
                 
                if(reps.peek() == k){
                    int o = 0;
                    while(o != k){
                        reps.pop();
                        chars.pop();
                        o++;
                    }
            }
            
        }else{
                 chars.push(str[i]);
                    reps.push( 1); 
            }
               i++;
    }
        
        StringBuilder res = new StringBuilder();
        while(!chars.empty()){
            res.append(chars.pop());
        }
        
    return res.reverse().toString();
}
}
    
    
    //deeedbbcccbdaa
    //char stack - > [d d 
    // reps stack -> [1 2 
