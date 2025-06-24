class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {
        
        Set<Integer> intersection = new HashSet<>();

        for (var num : nums1) {
            intersection.add(num);
        }

        Set<Integer> unique2 = new HashSet<>();

        for (var num : nums2) {
            unique2.add(num);
        }

        intersection.retainAll(unique2);

        var result = new int[intersection.size()];
        var i = 0;

        for (var n : intersection) {
            result[i++] = n;
        }

        return result;
    }
}