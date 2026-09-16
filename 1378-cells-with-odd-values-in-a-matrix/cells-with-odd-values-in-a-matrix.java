class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        int matrix[][] = new int [m][n];
        int count = 0;
        for(int k = 0 ; k < indices.length ; k++){
            int r = indices[k][0];
            int c = indices[k][1];
            for(int i = 0 ; i < n ; i++){
                matrix[r][i]++;
            }
            for(int j = 0 ; j < m ; j++){
                matrix[j][c]++;
            }
        }
         for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(matrix[i][j] % 2 != 0){
                    count++;
                }
            }
         }
        return count;
    }
}