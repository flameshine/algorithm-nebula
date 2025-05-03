class Solution {

    public String reorganizeString(String s) {
        
        Map<Character, Integer> frequencies = new HashMap<>();

        for (var c : s.toCharArray()) {
            frequencies.merge(c, 1, Integer::sum);
        }

        Queue<Character> heap = new PriorityQueue<>((a, b) -> frequencies.get(b) - frequencies.get(a));

        heap.addAll(frequencies.keySet());

        if (frequencies.get(heap.peek()) > (s.length() + 1) / 2) {
            return "";
        }

        var result = new char[s.length()];
        var i = 0;

        while (!heap.isEmpty()) {

            var c = heap.poll();

            for (var j = 0; j < frequencies.get(c); j++) {

                if (i >= s.length()) {
                    i = 1;
                }

                result[i] = c;
                i += 2;
            }
        }

        return new String(result);
    }
}