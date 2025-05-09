class Solution {
    
    public String countAndSay(int n) {

        if (n == 1) {
            return "1";
        }

        var s = countAndSay(n - 1);
        var builder = new StringBuilder();
        var count = 1;
        var current = s.charAt(0);

        for (var i = 1; i < s.length(); i++) {
            if (s.charAt(i) == current) {
                ++count;
            } else {

                builder.append(count)
                    .append(current);

                current = s.charAt(i);

                count = 1;
            }
        }

        builder.append(count)
            .append(current);

        return builder.toString();
    }
}