class Solution {

    public List<String> cellsInRange(String s) {

        if (s == null || s.isBlank()) {
            return List.of();
        }

        var firstLetter = s.charAt(0);
        var lastLetter = s.charAt(3);
        var firstRow = s.charAt(1) - '0';
        var lastRow = s.charAt(4) - '0';

        List<String> result = new ArrayList<>();

        for (var c = firstLetter; c <= lastLetter; ++c) {
            for (var i = firstRow; i <= lastRow; ++i) {
                var letter = c + "";
                result.add(letter + i);
            }
        }

        return result;
    }
}