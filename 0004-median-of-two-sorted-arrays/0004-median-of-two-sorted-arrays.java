class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        var n1 = nums1.length;
        var n2 = nums2.length;

        if (n1 > n2) {
            return findMedianSortedArrays(nums2, nums1);
        }

        var n = n1 + n2;
        var half = (n1 + n2 + 1) >> 1;
        var left = 0;
        var right = n1;

        while (left <= right) {

            var n1Middle = (left + right) >> 1;
            var n2Middle = half - n1Middle;
            var n1LeftPartition = n1Middle > 0 ? nums1[n1Middle - 1] : Integer.MIN_VALUE;
            var n1RightPartition = n1Middle < n1 ? nums1[n1Middle] : Integer.MAX_VALUE;
            var n2LeftPartition = n2Middle > 0 ? nums2[n2Middle - 1] : Integer.MIN_VALUE;
            var n2RightPartition = n2Middle < n2 ? nums2[n2Middle] : Integer.MAX_VALUE;

            if (n2LeftPartition <= n1RightPartition && n1LeftPartition <= n2RightPartition) {
                if (n % 2 == 1) {
                    return (double) Math.max(n1LeftPartition, n2LeftPartition);
                } else {
                    return (Math.max(n1LeftPartition, n2LeftPartition) + Math.min(n1RightPartition, n2RightPartition)) / 2d;
                }
            } else if (n1LeftPartition > n2RightPartition) {
                right = n1Middle - 1;
            } else {
                left = n1Middle + 1;
            }
        }

        return -1;
        
    }
}