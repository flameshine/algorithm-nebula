class Solution {

    public boolean closeStrings(String word1, String word2) {
        
        var frequencies1 = new int[26];
        var frequencies2 = new int[26];

        for (var i = 0; i < word1.length(); i++) {
            frequencies1[word1.charAt(i) - 'a']++;
        }

        for (var i = 0; i < word2.length(); i++) {
            frequencies2[word2.charAt(i) - 'a']++;
        }

        for (var i = 0; i < 26; ++i) {
            if (frequencies1[i] > 0 && frequencies2[i] == 0 || frequencies2[i] > 0 && frequencies1[i] == 0) {
                return false; 
            }
        }

        Arrays.sort(frequencies1);
        Arrays.sort(frequencies2);

        return Arrays.equals(frequencies1, frequencies2);
    }
}