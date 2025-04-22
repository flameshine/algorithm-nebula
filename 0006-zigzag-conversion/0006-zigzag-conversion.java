class Solution {

    public String convert(String s, int numRows) {

        var chars = s.toCharArray();
        var rows = new StringBuilder[numRows];

        for (var i = 0; i < rows.length; i++) {
            rows[i] = new StringBuilder();
        }

        var i = 0;

        while (i < chars.length) {
            
            for (var j = 0; j < numRows && i < chars.length; j++) {
                rows[j].append(chars[i++]);
            }

            for (var j = numRows - 2; j >= 1 && i < chars.length; j--) {
                rows[j].append(chars[i++]);
            }
        }

        return String.join("", rows);
    }
}