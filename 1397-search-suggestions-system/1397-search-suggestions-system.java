class Solution {

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        
        var root = new TrieNode();

        for (var product : products) {
            insert(root, product);
        }

        List<List<String>> results = new ArrayList<>();

        for (var c : searchWord.toCharArray()) {
            if ((root = root.children[c - 'a']) == null) {
                break;
            }
            results.add(root.getTopThree());
        }

        while (results.size() < searchWord.length()) {
            results.add(List.of());
        }

        return results;
    }

    private void insert(TrieNode root, String word) {

        for (char c : word.toCharArray()) {

            if (root.children[c - 'a'] == null) {
				root.children[c - 'a'] = new TrieNode();
            }

            root = root.children[c - 'a'];

            root.addToPQ(word);
        }
    }

    private static class TrieNode {
    
    private TrieNode[] children;
    private PriorityQueue<String> pq;
    
        TrieNode() {
            this.children = new TrieNode[26];
            this.pq = new PriorityQueue<>((a,b) -> b.compareTo(a));
        }
    
        public void addToPQ(String word) {

            pq.add(word);

            if (pq.size() > 3) {
                pq.poll();
            }
        }
    
        public List<String> getTopThree() {

            List<String> topThree = new ArrayList<>();

            while (!pq.isEmpty()) {
                topThree.add(pq.poll());
            }

            Collections.reverse(topThree);

            return topThree;
        }
    }
}