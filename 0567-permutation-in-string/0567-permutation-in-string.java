class Solution {

    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        var frequencies1 = new int[26];
        var frequencies2 = new int[26];

        for (var i = 0; i < s1.length(); i++) {
            frequencies1[s1.charAt(i) - 'a']++;
            frequencies2[s2.charAt(i) - 'a']++;
        }

        if (matches(frequencies1, frequencies2)) {
            return true;
        }

        for (var i = s1.length(); i < s2.length(); i++) {

            frequencies2[s2.charAt(i) - 'a']++;
            frequencies2[s2.charAt(i - s1.length()) - 'a']--;

            if (matches(frequencies1, frequencies2)) {
                return true;
            }
        }

        return false;
    }

    private static boolean matches(int[] frequencies1, int[] frequencies2) {

        for (var i = 0; i < 26; i++) {
            if (frequencies1[i] != frequencies2[i]) {
                return false;
            }
        }

        return true;
    }
}