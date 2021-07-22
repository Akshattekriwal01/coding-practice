class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Comparator<String> comp = new Comparator<String>(){
            public int compare(String a , String b){
                String[] arr = a.split("\\s+",2);
                String[] arr1 = b.split("\\s+",2);
                
                boolean aIsDigit = Character.isDigit( arr[1].charAt(0) );
                boolean bIsDigit = Character.isDigit( arr1[1].charAt(0) );
                if(aIsDigit && bIsDigit) return 0 ; 
                if(!aIsDigit && bIsDigit) return -1 ;
                if(aIsDigit && !bIsDigit) return 1 ; 
               // when return 1 then first token is put after the second token by comparator
                String a1 =arr[1];
                String b1 =arr1[1];
               
                int ans = a1.compareTo(b1);
                if(ans == 0 ){
                    return arr[0].compareTo(arr1[0]);
                }else return ans ;
            }
        };
        Arrays.sort(logs,comp);
        return logs ;
    }
}