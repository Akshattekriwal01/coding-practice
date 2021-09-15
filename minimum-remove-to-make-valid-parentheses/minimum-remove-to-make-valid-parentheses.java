class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<Integer>() ;
        boolean visited[] = new boolean[s.length()] ;
         
        
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i) ;
            if(ch == '('){
            stack.push(i);    
            }else if(ch == ')'){
             if(!stack.isEmpty() && s.charAt(stack.peek()) == '('){
                 int top = stack.pop() ;
                 visited[top] = true ;
                 visited[i] = true ;
             }
            }else{
                visited[i] = true ;
            }
        }
         StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < visited.length ; i++){
            if (visited[i]){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString() ;
    }
}