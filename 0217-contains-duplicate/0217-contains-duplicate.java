class Solution {

    public boolean containsDuplicate(int[] nums) {
        
        Set<Integer> seen = new HashSet<>();

        for (var n : nums) {
            if (!seen.add(n)) {
                return true;
            }
        }

        return false;
    }
}