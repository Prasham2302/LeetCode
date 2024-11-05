class Solution {
    public boolean judgeCircle(String moves) {
        int up = 0, left = 0;
        for (int i = 0;i<moves.length();i++) {
            char curr = moves.charAt(i);
            switch (curr){
                case 'U':
                    up++;
                    break;
                case 'D':
                    up--;
                    break;
                case 'L':
                    left++;
                    break;
                case 'R':
                    left--;
                    break;
                default:
                    break;
            }
        }
        return up == 0 && left == 0;
    }
}

