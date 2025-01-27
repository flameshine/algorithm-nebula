class Solution {

    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        Map<Character, Integer> s1Frequencies = new HashMap<>();

        for (var c : s1.toCharArray()) {
            s1Frequencies.merge(c, 1, Integer::sum);
        }

        Map<Character, Integer> substringFrequencies = new HashMap<>();

        for (var i = 0; i <= s2.length() - s1.length(); i++) {
            
            var substring = s2.substring(i, i + s1.length());

            for (char c : substring.toCharArray()) {
                substringFrequencies.merge(c, 1, Integer::sum);
            }
            
            if (s1Frequencies.equals(substringFrequencies)) {
                return true;
            } else {
                substringFrequencies.clear();
            }
        }
        
        return false;
    }
}