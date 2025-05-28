class Solution {

    public String[] shortestSubstrings(String[] arr) {
        
        Map<String, Integer> substringFrequencies = new HashMap<>();

        for (var s : arr) {
            
            Set<String> seen = new HashSet<>();

            for (var i = 0; i < s.length(); i++) {
                for (var j = i + 1; j <= s.length(); j++) {

                    var substring = s.substring(i, j);

                    if (seen.add(substring)) {
                        substringFrequencies.merge(substring, 1, Integer::sum);
                    }
                }
            }
        }

        var result = new String[arr.length];

        for (var i = 0; i < arr.length; i++) {
            
            var s = arr[i];
            var shortest = "";

            for (var j = 0; j < s.length(); j++) {
                for (var k = j + 1; k <= s.length(); k++) {
                    
                    var substring = s.substring(j, k);

                    if (substringFrequencies.get(substring) == 1) {
                        if (shortest == "" || substring.length() < shortest.length() || (substring.length() == shortest.length() && substring.compareTo(shortest) < 0)) {
                            shortest = substring;
                        }
                    }
                }
            }

            result[i] = shortest;
        }

        return result;
    }
}