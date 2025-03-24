class Solution {

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        
        var pairs = new int[spells.length];

        Arrays.sort(potions);

        for (var i = 0; i < spells.length; i++) {

            var spell = spells[i];
            var left = 0;
            var right = potions.length - 1;

            while (left <= right) {

                var middle = left + (right - left) / 2;
                var product = (long) spell * potions[middle];

                if (product >= success) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            }

            pairs[i] = potions.length - left;
        }

        return pairs;
    }
}