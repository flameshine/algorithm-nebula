class Solution {

    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        int[] sChars = new int[26];
        int[] tChars = new int[26];

        for (var i = 0; i < s.length(); i++) {
            sChars[s.charAt(i) - 'a']++;
            tChars[t.charAt(i) - 'a']++;
        }

        return Arrays.equals(sChars, tChars);
    }
}