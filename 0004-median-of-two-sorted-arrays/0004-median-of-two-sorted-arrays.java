class Solution {

    public double findMedianSortedArrays(int[] a, int[] b) {
        
        var n1 = a.length;
        var n2 = b.length;

        if (n1 > n2) {
            return findMedianSortedArrays(b, a);
        }

        var n = n1 + n2;
        var half = (n1 + n2 + 1) / 2;
        var left = 0;
        var right = n1;

        while (left <= right) {

            var aMiddle = (left + right) >> 1;
            var bMiddle = half - aMiddle;
            var aLeftPartition = aMiddle > 0 ? a[aMiddle - 1] : Integer.MIN_VALUE;
            var aRightPartition = aMiddle < n1 ? a[aMiddle] : Integer.MAX_VALUE;
            var bLeftPartition = bMiddle > 0 ? b[bMiddle - 1] : Integer.MIN_VALUE;
            var bRightPartition = bMiddle < n2 ? b[bMiddle] : Integer.MAX_VALUE;

            if (aLeftPartition <= bRightPartition && bLeftPartition <= aRightPartition) {

                if (n % 2 == 1) {
                    return (double) Math.max(aLeftPartition, bLeftPartition);
                } else {
                    return (Math.max(aLeftPartition, bLeftPartition) + Math.min(aRightPartition, bRightPartition)) / 2d;
                }

            } else if (aLeftPartition > bRightPartition) {
                right = aMiddle - 1;
            } else {
                left = aMiddle + 1;
            }
        }

        return -1;
    }
}