public class TrieNode {
    private TrieNode[] children;

    public boolean isWord() {
        return isWord;
    }

    private boolean isWord;

    public TrieNode() {
        this.children = new TrieNode[255];
    }

    public TrieNode getChild(char index) {
        if (children[index] != null) {
            return children[index];
        }
        children[index] = new TrieNode();
        return children[index];
    }

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
