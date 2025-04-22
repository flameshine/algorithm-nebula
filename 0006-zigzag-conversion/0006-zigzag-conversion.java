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

        for (var j = 1; j < rows.length; j++) {
            rows[0].append(rows[j]);
        }

        return rows[0].toString();
    }
}