class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        int max = 0, count =0;
        for(int[] i:rectangles){ 
            int side = Math.min(i[0],i[1]);
            if(side >max){
                max=side;
                count=1;
            }
            else if(side==max)
                    count++;
        }
        return count;
    }
}