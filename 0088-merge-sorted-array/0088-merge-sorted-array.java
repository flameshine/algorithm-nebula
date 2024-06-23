class Solution {
    
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        var nums1Pointer = m - 1;
        var nums2Pointer = n - 1;
        var resultPointer = m + n - 1;

        while (nums2Pointer >= 0) {
            if (nums1Pointer >= 0 && nums1[nums1Pointer] > nums2[nums2Pointer]) {
                nums1[resultPointer--] = nums1[nums1Pointer--];
            } else {
                nums1[resultPointer--] = nums2[nums2Pointer--];
            }
        }
    }
}
