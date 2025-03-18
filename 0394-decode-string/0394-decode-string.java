class Solution {
    
    public String decodeString(String s) {

        Stack<String> fragments = new Stack<>();
        Stack<Integer> counts = new Stack<>();

        var builder = new StringBuilder();
        var number = 0;

        for (var c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                number = number * 10 + (c - '0');
            } else if (Character.isLetter(c)) {
                builder.append(c);
            } else if (c == '[') {
                
            }
        }
    }
}