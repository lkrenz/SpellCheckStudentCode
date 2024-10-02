public class Trie {
    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = this.root;
        for (int i = 0; i < word.length(); i++) {
            node = node.getChild(word.charAt(i));
        }
        node.setWord();
    }

    public boolean isWord(String word) {
        TrieNode node = this.root;
        for (int i = 0; i < word.length(); i++) {
            node = node.checkChild(word.charAt(i));
            if (node == null) {
                return false;
            }
        }
        if (node.isWord()) {
            return true;
        }
        return false;
    }


}
