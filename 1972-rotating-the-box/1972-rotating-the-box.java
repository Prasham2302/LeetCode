class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int row = boxGrid.length;
        int col = boxGrid[0].length;
        for (int i = 0;i<row;i++) {
            int empty = col-1;
            for (int j = col-1;j>=0;j--) {
                if (boxGrid[i][j] == '*') {
                    empty = j-1;
                } else if (boxGrid[i][j] == '.') {
                    continue;
                } else {
                    boxGrid[i][j] = '.';
                    boxGrid[i][empty] = '#';
                    empty--;
                }
            }
        }
        // System.out.println(Arrays.deepToString(boxGrid));
        char[][] rotated = new char[col][row];
        for (int i = 0;i<row;i++) {
            for (int j = col-1;j>=0;j--) {
                rotated[j][row-i-1] = boxGrid[i][j];
            }
        }
        return rotated;
    }
}