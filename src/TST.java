public class TST {
    Node root;

    public TST() {
        this.root = new Node();
    }

    public void addWord(String word) {
        Node node = root;
        int i = 0;
        while (true) {
            node = node.findChild(word.charAt(i));
            if (node.)
        }
    }
}
