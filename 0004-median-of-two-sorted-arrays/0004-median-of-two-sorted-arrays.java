class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        int half = total / 2;
        if (nums1.length > nums2.length){
            int[] temp = nums2;
            nums2 = nums1;
            nums1 = temp;
        }
        int left = 0, right = nums1.length - 1;
        System.out.println(Arrays.toString(nums1));
        while (true) {
            int m1 = ( left  + right )  >> 1;
            int m2 = half - m1 - 2;
            int left1 = Integer.MIN_VALUE, left2 = Integer.MIN_VALUE;
            int right1 = Integer.MAX_VALUE, right2 = Integer.MAX_VALUE;
            if (m1 >= 0)
                left1 = nums1[m1];
            if (m2 >= 0)
                left2 = nums2[m2];
            // System.out.println(m1 +" "+(nums1.length - 1));
            if (m1 + 1 < nums1.length)
                right1 = nums1[m1 + 1];
            if (m2 < nums2.length - 1)
                right2 = nums2[m2 + 1];
        
            // System.out.println("index: " + left +"  "+right);
            // System.out.println("nums1: " + left1 +"  "+right1);
            // System.out.println("nums2: " + left2 +"  "+right2);
            if (left1 <= right2 && left2 <= right1){
                if (total % 2 == 0){
                    return ((double) (Math.min(right2, right1) + Math.max(left1, left2))) / 2; 
                }
                return (double) (Math.min(right1, right2));
            }
            else if (left1 > right2) {
                right = m1 - 1;
            }
            else {
                left = m1 + 1;
            }
        }
    }
}