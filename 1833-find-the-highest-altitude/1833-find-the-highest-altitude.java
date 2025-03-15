class Solution {

    public int largestAltitude(int[] gain) {
        
        var current = 0;
        var result = 0;

        for (var i = 0; i < gain.length; i++) {
            current += gain[i];
            result = Math.max(result, current);
        }

        return result;
    }
}