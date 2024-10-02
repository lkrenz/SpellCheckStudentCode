public class TST {
    Node root;

    public TST() {
        this.root = new Node();
    }

    public void addWord(String word) {
        Node node = this.root;
        int i = 0;
        while (i < word.length()) {
            char letter = word.charAt(i);
            Node child = node.findChild(letter);

            if (child == null) {
                child = new Node(letter);
                node = child;
                i++;
            }
            else {
                node = child;
            }
        }
    }

    public boolean checkWord(String word) {
        Node node = this.root;
        int i = 0;

        while (node != null) {
            char letter = word.charAt(i);
            Node child = node.findChild(letter);
            if (child)

        }
    }

}
