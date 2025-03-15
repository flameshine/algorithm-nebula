class Solution {

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        
        Set<Integer> distinctNums1 = new HashSet<>();
        Set<Integer> distinctNums2 = new HashSet<>();

        for (var n : nums1) {
            distinctNums1.add(n);
        }

        for (var n : nums2) {
            distinctNums2.add(n);
        }

        List<Integer> nums1Difference = new ArrayList<>();
        List<Integer> nums2Difference = new ArrayList<>();

        for (var n : distinctNums2) {
            if (!distinctNums1.contains(n)) {
                nums1Difference.add(n);
            }
        }

        for (var n : distinctNums1) {
            if (!distinctNums2.contains(n)) {
                nums2Difference.add(n);
            }
        }

        return List.of(
            nums2Difference,
            nums1Difference
        );
    }
}