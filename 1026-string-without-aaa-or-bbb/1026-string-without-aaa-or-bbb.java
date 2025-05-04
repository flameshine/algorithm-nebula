class Solution {

    public String strWithout3a3b(int a, int b) {
        
        var builder = new StringBuilder();

        while (a > 0 || b > 0) {

            var s = builder.toString();

            if (s.endsWith("aa")) {
                builder.append("b");
                --b;
            } else if (s.endsWith("bb")) {
                builder.append("a");
                --a;
            } else if (a > b) {
                builder.append("a");
                --a;
            } else {
                builder.append("b");
                --b;
            }
        }

        return builder.toString();
    }
}