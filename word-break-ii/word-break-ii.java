class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<String>() ; 
        helper(s, wordDict, "" , res) ;
        return res ;
    }
    
    public void helper(String s, List<String> wordDict, String sofar, List<String> res){
        if(s.equals("")){
            res.add(sofar.trim());
        }else{
            for(int i = 0 ; i < wordDict.size() ; i++){
                String word = wordDict.get(i);
                if(word.length() <= s.length() && word.equals( s.substring(0, word.length() ) )) {
                    String s1 = s.substring(wordDict.get(i).length() ) ; 
                    String sofar1 = sofar + " " + wordDict.get(i) ;
                    helper(s1, wordDict, sofar1 , res);
                }
            }
        }
    }
}