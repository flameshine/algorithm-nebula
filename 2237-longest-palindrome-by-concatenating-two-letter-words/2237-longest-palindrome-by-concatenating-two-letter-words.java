class Solution {

    public int longestPalindrome(String[] words) {
        
        Map<String, Integer> frequencies = new HashMap<>();

        var result = 0;

        for (var w : words) {
            var reversed = reverse(w);
            if (frequencies.containsKey(reversed) && frequencies.get(reversed) > 0 ) {
                frequencies.merge(reversed, -1, Integer::sum);
                result += 4;
            } else {
                frequencies.merge(w, 1, Integer::sum);
            }
        }

        for (var e : frequencies.entrySet()) {
            var w = e.getKey();
            if (e.getValue() == 1 && w.charAt(0) == w.charAt(1)) {
                result += 2;
                break;
            }
        }

        return result;
    }

    private static String reverse(String s) {
        return new StringBuilder(s)
            .reverse()
            .toString();
    }
}