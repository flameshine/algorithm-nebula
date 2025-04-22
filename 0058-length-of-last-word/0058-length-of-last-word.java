class Solution {

    public int lengthOfLastWord(String s) {

        if (s.isBlank()) {
            return 0;
        }
        
        var start = s.length() - 1;

        while (!Character.isLetter(s.charAt(start))) {
            --start;
        }

        var result = 0;

        while (start != -1 && Character.isLetter(s.charAt(start--))) {
            ++result;
        }

        return result;
    }
}