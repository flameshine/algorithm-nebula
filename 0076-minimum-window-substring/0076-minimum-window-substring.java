class Solution {

    public String minWindow(String s, String t) {

        if (t.length() > s.length()) {
            return "";
        }
        
        var map = new int[128];
        var count = t.length();
        var left = 0;
        var right = 0;
        var minStart = 0;
        var minLength = Integer.MAX_VALUE;

        for (var c : t.toCharArray()) {
            map[c]++;
        }

        while (right < s.length()) {

            if (map[s.charAt(right++)]-- > 0) {
                --count;
            }

            while (count == 0) {

                if (right - left < minLength) {
                    minStart = left;
                    minLength = right - left;
                }

                if (map[s.charAt(left++)]++ == 0) {
                    ++count;
                }
            }
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLength);
    }
}