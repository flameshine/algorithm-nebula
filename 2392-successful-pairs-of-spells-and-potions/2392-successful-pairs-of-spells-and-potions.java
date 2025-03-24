class Solution {

    public int[] successfulPairs(int[] spells, int[] potions, long success) {

        Arrays.sort(potions);

        TreeMap<Long, Integer> map = new TreeMap<>();

        map.put(Long.MAX_VALUE, potions.length);

        for (var i = potions.length - 1; i >= 0; i--) {
            map.put((long) potions[i], i);
        }

        for (var i = 0; i < spells.length; i++) {
            var required = (success + spells[i] - 1) / spells[i];
            spells[i] = potions.length - map.ceilingEntry(required).getValue();
        }

        return spells;
    }
}