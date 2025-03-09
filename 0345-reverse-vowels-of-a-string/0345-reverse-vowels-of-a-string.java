class Solution {

    public String reverseVowels(String s) {
        
        var left = 0;
        var right = s.length() - 1;
        var chars = s.toCharArray();

        while (left < right) {

            var leftChar = chars[left];
            var rightChar = chars[right];
            var isLeftVowel = isVowel(Character.toLowerCase(leftChar));
            var isRightVowel = isVowel(Character.toLowerCase(rightChar));

            if (isLeftVowel && isRightVowel) {
                chars[left] = rightChar;
                chars[right] = leftChar;
            } else if (isLeftVowel) {
                --right;
                continue;
            } else if (isRightVowel) {
                ++left;
                continue;
            }
            
            ++left;
            --right;
        }

        return new String(chars);
    }

    private static boolean isVowel(char c) {
        return 'a' == c || 'e' == c || 'i' == c || 'o' == c || 'u' == c;
    }
}