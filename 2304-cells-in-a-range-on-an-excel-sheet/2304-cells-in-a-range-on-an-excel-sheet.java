import java.util.regex.Pattern;

class Solution {

    private static final Pattern PATTERN = Pattern.compile(
        "([A-Z])([1-9]):([A-Z])([1-9])"
    );

    public List<String> cellsInRange(String s) {
        
        var matcher = PATTERN.matcher(s);

        if (!matcher.matches()) {
            return List.of();
        }

        var firstLetter = matcher.group(1).charAt(0);
        var lastLetter = matcher.group(3).charAt(0);
        var firstRow = Integer.parseInt(matcher.group(2));
        var lastRow = Integer.parseInt(matcher.group(4));

        List<String> result = new LinkedList<>();

        for (var c = firstLetter; c <= lastLetter; ++c) {
            for (var i = firstRow; i <= lastRow; ++i) {
                var letter = c + "";
                result.add(letter + i);
            }
        }

        return result;
    }
}