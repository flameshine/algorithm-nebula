class Solution {

    public int compress(char[] chars) {

        var result = 0;
    
        for (var i = 0; i < chars.length;) {

            var current = chars[i];
            var count = 0;

            while (i < chars.length && chars[i] == current) {
                ++count;
                ++i;
            }

            chars[result++] = current;

            if (count <= 1) {
                continue;
            }

            for (var c : String.valueOf(count).toCharArray()) {
                chars[result++] = c;
            }
        }

        return result;
    }
}