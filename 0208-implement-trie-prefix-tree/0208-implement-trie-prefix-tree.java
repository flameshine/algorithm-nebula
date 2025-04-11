class Trie {

    private final Node root;

    public Trie() {
        this.root = new Node();
    }
    
    public void insert(String word) {
        root.insert(word, 0);
    }
    
    public boolean search(String word) {
        return root.search(word, 0);
    }
    
    public boolean startsWith(String prefix) {
        return root.startsWith(prefix, 0);
    }

    private static class Node {

        private Node[] nodes;
        private boolean isEnd;

        Node() {
            this.nodes = new Node[26];
        }

        private void insert(String word, int index) {

            if (index >= word.length()) {
                return;
            }

            var i = word.charAt(index) - 'a';

            if (nodes[i] == null) {
                nodes[i] = new Node();
            }

            if (index == word.length() - 1) {
                nodes[i].isEnd = true;
            }

            nodes[i].insert(word, index + 1);
        }

        private boolean search(String word, int index) {

            if (index >= word.length()) {
                return false;
            }

            var node = nodes[word.charAt(index) - 'a'];

            if (node == null) {
                return false;
            }

            if (index == word.length() - 1 && node.isEnd) {
                return true;
            }

            return node.search(word, index + 1);
        }

        private boolean startsWith(String prefix, int index) {

            if (index >= prefix.length()) {
                return false;
            }

            var node = nodes[prefix.charAt(index) - 'a'];

            if (node == null) {
                return false;
            }

            if (index == prefix.length() - 1) {
                return true;
            }

            return node.startsWith(prefix, index + 1);
        }
    }
}