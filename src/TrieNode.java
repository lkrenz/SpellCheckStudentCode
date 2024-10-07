public class TrieNode {
    private final TrieNode[] children;
    private boolean isWord;

    // Creates a new TrieNode
    public TrieNode() {
        this.children = new TrieNode[255];
    }

    public boolean isWord() {
        return isWord;
    }

    // Returns the child at the given index, initializing if necessary
    public TrieNode getChild(char index) {
        if (children[index] != null) {
            return children[index];
        }
        children[index] = new TrieNode();
        return children[index];
    }

    // Returns child if it exists
    public TrieNode checkChild(char index) {
        if (children[index] != null) {
            return children[index];
        }
        return null;
    }

    public void setWord() {
        this.isWord = true;
    }
}
