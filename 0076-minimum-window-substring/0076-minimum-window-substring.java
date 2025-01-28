class Solution {

    public String minWindow(String s, String t) {

        if (t.length() > s.length()) {
            return "";
        }

        Map<Character, Integer> frequencies = new HashMap<>();

        for (var c : t.toCharArray()) {
            frequencies.merge(c, 1, Integer::sum);
        }

        Map<Character, Integer> windowFrequencies = new HashMap<>();

        var actual = 0;
        var needed = t.length();
        var minLength = Integer.MAX_VALUE;
        var left = 0;
        var result = "";

        for (var right = 0; right < s.length(); right++) {

            var c = s.charAt(right);

            windowFrequencies.merge(c, 1, Integer::sum);

            if (frequencies.containsKey(c) && frequencies.get(c) >= windowFrequencies.get(c)) {
                ++actual;
            }

            while (actual == needed) {

                if (right - left + 1 < minLength) {
                    result = s.substring(left, right + 1);
                    minLength = right - left + 1;
                }

                var leftmost = s.charAt(left);

                windowFrequencies.merge(leftmost, -1, Integer::sum);

                if (frequencies.containsKey(leftmost) && windowFrequencies.get(leftmost) < frequencies.get(leftmost)) {
                    --actual;
                }

                ++left;
            }
        }

        return minLength != Integer.MAX_VALUE ? result : ""; 
    }
}