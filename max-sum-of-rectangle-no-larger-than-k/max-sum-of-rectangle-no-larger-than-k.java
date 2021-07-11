class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        // for calculating these kinds of values it is more preffered to make another matrix of  size m+1,n+1 for padding;
//         int m = matrix.length ; 
//         int n = matrix[0].length ; 
//         int[][] psum = new int[m+1][n+1];
//         for(int i = 1 ; i < psum.length ; i++){
//             for(int j = 1 ; j < psum[0].length ; j++){
//                 psum[i][j] = psum[i-1][j] + psum[i][j-1] - psum[i-1][j-1] + matrix[i-1][j-1];
//             }
//         }
   
        
        
//     display(psum);        
//         return 0 ; 
        int m = matrix.length;
        int n = matrix[0].length;
        int res = Integer.MIN_VALUE;
        
        int[][] psum = new int[m + 1][n + 1];
        
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                psum[i][j] = psum[i - 1][j] + psum[i][j - 1] - psum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
        
        for(int si = 0; si < m; si++){
            for(int sj = 0; sj < n; sj++){
                //si, sj
                for(int ei = si; ei < m; ei++){
                    for(int ej = sj; ej < n; ej++){
                        //ei, ej
                        //find sum of rectangle si,sj ends with ei,ej
                        int sum = psum[ei + 1][ej + 1] - psum[ei + 1][sj] - psum[si][ej + 1] + psum[si][sj];
                        if(sum <= k){
                            res = Math.max(res, sum);
                        }
                    }
                }
            }
        }
        return res;  
    }
  }
    
//     public void display(int[][] matrix ){
//         for(int[] arr : matrix){
//             for(int i : arr){
//                 System.out.print(i+", ");
//             }
//             System.out.println();
//         }
//     }
//}

// int sum = psum[ei + 1][ej + 1] - psum[ei + 1][sj] - psum[si][ej + 1] + psum[si][sj];