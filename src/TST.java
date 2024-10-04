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

            if (node.getLetter() == letter) {
                i++;
                if (i == word.length() - 1) {
                    node.setMiddle(new Node(word.charAt(i)));
                    break;
                }
                node = node.getMiddle(word.charAt(i));
            }
            else {
                node = node.findChild(letter);
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
