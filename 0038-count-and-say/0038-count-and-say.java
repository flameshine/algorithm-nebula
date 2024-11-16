class Solution {

    public String countAndSay(int n) {
        
        if (n == 1) {
            return "1";
        }

        var s = countAndSay(n - 1);
        var builder = new StringBuilder();

        for (var i = 0; i < s.length(); i++) {

            var count = 1;
            var c = s.charAt(i);

            while (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                ++count;
                ++i;
            }

            builder.append(count)
                .append(c);
        }

        return builder.toString();
    }
}