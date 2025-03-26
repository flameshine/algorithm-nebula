class Solution {
    
    public List<String> letterCombinations(String digits) {

        if (digits == null || digits.isBlank()) {
            return List.of();
        }
        
        var keyboard = Map.of(
            '2', "abc",
            '3', "def",
            '4', "ghi",
            '5', "jkl",
            '6', "mno",
            '7', "pqrs",
            '8', "tuv",
            '9', "wxyz"
        );

        List<String> result = new ArrayList<>();

        backtrack(digits, 0, new StringBuilder(), result, keyboard);

        return result;
    }

    private void backtrack(
        String digits,
        int index,
        StringBuilder combination,
        List<String> accumulator,
        Map<Character, String> keyboard
    ) {

        if (index == digits.length()) {
            accumulator.add(combination.toString());
            return;
        }

        var letters = keyboard.get(digits.charAt(index));

        for (var letter : letters.toCharArray()) {
            combination.append(letter);
            backtrack(digits, index + 1, combination, accumulator, keyboard);
            combination.deleteCharAt(combination.length() - 1);
        }
    }
}