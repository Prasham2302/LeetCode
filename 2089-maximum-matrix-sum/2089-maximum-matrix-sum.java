class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long count = 0;
        long min  = Long.MAX_VALUE;
        long sum = 0;
        for (int i = 0;i<matrix.length;i++) {
            for(int j = 0;j<matrix[0].length;j++) {
                if (matrix[i][j] < 0) 
                    count++;
                sum += Math.abs(matrix[i][j]);
                min = Math.min(Math.abs(matrix[i][j]), min);
            }
        }
        return count % 2 == 0 ? sum : ( sum - (2 * min) );
    }
}