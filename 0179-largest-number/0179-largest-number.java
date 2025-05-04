class Solution {

    public String largestNumber(int[] nums) {
        
        var strings = new String[nums.length];

        for (var i = 0; i < nums.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strings, (a, b) -> (b + a).compareTo(a + b));

        return strings[0].equals("0") ? "0" : String.join("", strings);
    }
}