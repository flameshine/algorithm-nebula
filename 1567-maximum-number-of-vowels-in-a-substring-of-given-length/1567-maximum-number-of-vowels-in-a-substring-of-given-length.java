class Solution {

    public int maxVowels(String s, int k) {

        var vowels = 0;

        for (var i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                ++vowels;
            }
        }

        var result = vowels;

        for (var i = k; i < s.length(); i++) {

            if (isVowel(s.charAt(i - k))) {
                --vowels;
            }

            if (isVowel(s.charAt(i))) {
                ++vowels;
            }

            result = Math.max(result, vowels);
        }

        return result;
    }

    private static boolean isVowel(char c) {
        return 'a' == c ||
            'e' == c ||
            'i' == c ||
            'o' == c ||
            'u' == c;
    }
}