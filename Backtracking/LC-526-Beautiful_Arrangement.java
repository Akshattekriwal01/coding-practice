class Solution {
    public int countArrangement(int n) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int i = 0 ;
        while(i != n){
            list.add(++i);
        }
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        helper(result , list , new ArrayList<Integer>(), 1);
        return result.size();
    }
    public void helper(ArrayList<List<Integer>> result, ArrayList<Integer> list, ArrayList<Integer> sofar, int step){
        if(list.size() == 1){
            if( list.get(0) % step == 0 || step % list.get(0) == 0){
                result.add(sofar);
             }
        }else{
            int len = list.size();
            for(int k = 0 ; k < len ; k++){
                if( list.get(k) % step == 0 || step % list.get(k) == 0){
                    ArrayList<Integer> temp = new ArrayList<Integer>();
                    for(int j = 0 ;j < list.size() ; j ++){
                        if(j != k){
                            temp.add(list.get(j));
                        }
                    }
                    ArrayList<Integer> sofar1 = new ArrayList<Integer>();
                    for(Integer x : sofar){
                        sofar1.add(x);
                    }
                    sofar1.add(list.get(k));
                    helper(result, temp, sofar1,step+1 );
                }
            }
        }
    }
}
