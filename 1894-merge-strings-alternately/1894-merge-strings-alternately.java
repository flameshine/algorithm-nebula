class Solution {

    public String mergeAlternately(String word1, String word2) {
        
        var word1Index = 0;
        var word2Index = 0;
        var flag = true;
        var result = new StringBuilder();

        while (word1Index < word1.length() && word2Index < word2.length()) {

            if (flag) {
                result.append(word1.charAt(word1Index++));
            } else {
                result.append(word2.charAt(word2Index++));
            }

            flag = !flag;
        }

        if (word1Index == word1.length()) {
            result.append(word2.substring(word2Index));
        } else if (word2Index == word2.length()) {
            result.append(word1.substring(word1Index));
        }

        return result.toString();
    }
}