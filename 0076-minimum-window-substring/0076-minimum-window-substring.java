class Solution {

    public String minWindow(String s, String t) {

        if (t.length() > s.length()) {
            return "";
        }

        Map<Character, Integer> frequencies = new HashMap<>();

        for (var c : t.toCharArray()) {
            frequencies.merge(c, 1, Integer::sum);
        }

        var count = frequencies.size();
        var minLength = Integer.MAX_VALUE;
        var left = 0;
        var right = 0;
        var result = "";

        while (right < s.length()) {

            var endChar = s.charAt(right++);
            
            if (frequencies.containsKey(endChar)) {
                frequencies.merge(endChar, -1, Integer::sum);
                if (frequencies.get(endChar) == 0) {
                    --count;
                }
            }

            if (count > 0) {
                continue;
            }

            while (count == 0) {

                var startChar = s.charAt(left++);

                if (frequencies.containsKey(startChar)) {

                    frequencies.merge(startChar, 1, Integer::sum);

                    if (frequencies.get(startChar) > 0) {
                        ++count;
                    }
                }
            }

            var distance = right - left;

            if (distance < minLength) {
                result = s.substring(left - 1, right);
                minLength = distance;
            }
        }

        return minLength != Integer.MAX_VALUE ? result : ""; 
    }
}