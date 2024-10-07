public class Trie {
    private final TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    // Adds words to the trie
    public void addWord(String word) {
        TrieNode node = this.root;
        for (int i = 0; i < word.length(); i++) {
            node = node.getChild(word.charAt(i));
        }
        node.setWord();
    }

    // Checks if a given word is in the trie
    public boolean checkWord(String word) {
        TrieNode node = this.root;

        // Iterates until reaching the end of the word or a leaf
        for (int i = 0; i < word.length(); i++) {
            node = node.checkChild(word.charAt(i));
            if (node == null) {
                return true;
            }
        }
        return !node.isWord();
    }


}
