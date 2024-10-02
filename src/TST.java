public class TST {
    Node root;

    public TST() {
        this.root = new Node('a');

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
        node.setWord(true);
    }

    public boolean checkWord(String word) {
        Node node = this.root;
        int i = 0;
        while (i < word.length()) {
            char letter = word.charAt(i);
            if (node.getLetter() == letter) {
                System.out.println(node.getLetter());
                node = node.getMiddle();
                i++;
            }
            else if (node.getLetter() > letter) {
                node = node.getRight();
            }
            else {
                node = node.getLeft();
            }
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
