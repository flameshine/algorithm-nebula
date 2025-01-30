class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateRecursively(result, 0, 0, "", n);
        return result;
    }

    private static void generateRecursively(List<String> result, int left, int right, String s, int n) {

        if (s.length() == n * 2) {
            result.add(s);
            return;
        }

        if (left < n) {
            generateRecursively(result, left + 1, right, s + "(", n);
        }

        if (right < left) {
            generateRecursively(result, left, right + 1, s + ")", n);
        }
    }
}