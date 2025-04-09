class Solution {

    public int longestCommonSubsequence(String text1, String text2) {
        
        var length1 = text1.length();
        var length2 = text2.length();
        var dp = new int[length1 + 1][length2 + 1];

        for (var i = 1; i <= length1; i++) {
            for (var j = 1; j <= length2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[length1][length2];
    }
}