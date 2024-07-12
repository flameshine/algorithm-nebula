class Solution {

    public int minOperations(String[] logs) {
        
        var result = 0;

        for (var log : logs) {

            switch (log) {
                case "../" -> {
                    if (result > 0) {
                        --result;
                    }
                }
                case "./" -> { }
                default -> { ++result; }
            }
        }

        return result;
    }
}