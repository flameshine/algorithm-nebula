class Solution {

    private static final List<String> ROWS = List.of(
        "qwertyuiop",
        "asdfghjkl",
        "zxcvbnm"
    );

    public String[] findWords(String[] words) {

        List<String> resultBuilder = new ArrayList<>();

        for (var word : words) {
            if (
                containsAllChars(ROWS.get(0), word) ||
                containsAllChars(ROWS.get(1), word) ||
                containsAllChars(ROWS.get(2), word)
            ) {
                resultBuilder.add(word);
            }
        }

        return resultBuilder.toArray(String[]::new);
    }

    private static boolean containsAllChars(String row, String word) {

        for (var c : word.toCharArray()) {
            if (row.indexOf(Character.toLowerCase(c)) == -1) {
                return false;
            }
        }

        return true;
    }
}