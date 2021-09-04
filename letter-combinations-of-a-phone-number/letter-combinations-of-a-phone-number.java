class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.equals("") ) return new ArrayList<String>() ;
        HashMap<Integer, String> map = new HashMap<>() ; 
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        ArrayList<String> al = new ArrayList<String>() ; 
        
        helper(al, "", 0,map , digits);
        
        return al;
    
    }
    
    public void helper(ArrayList<String> al ,String temp, int idx,  HashMap<Integer, String> map , String digits){
        if(idx == digits.length()){
            al.add(temp);
            return  ;
        }
        
       String s =  map.get(Integer.parseInt(""+digits.charAt(idx))) ; 
        
        for( int i = 0 ;i < s.length() ; i++){
                String t = temp + s.charAt(i);
                helper(al, t , idx+1 , map , digits );
        }
                
        }
}