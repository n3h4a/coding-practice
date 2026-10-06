class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {

        List<Integer> ans = new ArrayList<>();

        int m = matrix.length;
        int n = matrix[0].length;

        for(int i = 0; i < m; i++) {

            int min = Integer.MAX_VALUE;
            int col = 0;

            // find row minimum
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] < min) {
                    min = matrix[i][j];
                    col = j;
                }
            }

            boolean isLucky = true;

            // check column maximum
            for(int k = 0; k < m; k++) {
                if(matrix[k][col] > min) {
                    isLucky = false;
                    break;
                }
            }

            if(isLucky) {
                ans.add(min);
            }
        }

        return ans;
    }
}