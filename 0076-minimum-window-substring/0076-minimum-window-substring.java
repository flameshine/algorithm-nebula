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
        var i = 0;
        var j = 0;
        var result = "";

        while (j < s.length()) {

            var endChar = s.charAt(j++);
            
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

                var startChar = s.charAt(i++);

                if (frequencies.containsKey(startChar)) {

                    frequencies.merge(startChar, 1, Integer::sum);

                    if (frequencies.get(startChar) > 0) {
                        ++count;
                    }
                }
            }

            if (j - i < minLength) {
                result = s.substring(i - 1, j);
                minLength = j - i;
            }
        }

        return minLength != Integer.MAX_VALUE ? result : ""; 
    }
}