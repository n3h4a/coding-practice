class Solution {
    public int oddCells(int m, int n, int[][] indices) {

        int[] rows = new int[m];
        int[] cols = new int[n];

        for(int k = 0; k < indices.length; k++){

            int r = indices[k][0];
            int c = indices[k][1];

            rows[r]++;
            cols[c]++;
        }

        int count = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){

                if((rows[i] + cols[j]) % 2 != 0){
                    count++;
                }

            }
        }

        return count;
    }
}