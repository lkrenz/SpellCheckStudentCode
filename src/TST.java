public class TST {
    Node root;

    public TST() {
        this.root = new Node('m');

    }

    public void addWord(String word) {
        Node node = this.root;
        int i = 0;
        while (i < word.length()) {
            char letter = word.charAt(i);

            if (node.getLetter() == letter) {
                i++;
                if (i == word.length() - 1) { // This is the problem, we don't want to auto write over the rest of the word.
                    node.setMiddle(word.charAt(i), true);
                    break;
                }
                else if (i == word.length()) {
                    node.setWord(true);
                    break;
                }
                node = node.getMiddle(word.charAt(i));
            }
            else {
                node = node.findChild(letter);
            }
        }
    }

    public boolean checkWord(String word) {
        Node node = this.root;
        int i = 0;
        while (i < word.length()) {
            char letter = word.charAt(i);
            char nodeLetter = node.getLetter();
            if (nodeLetter == letter) {
                i++;
                if (i == word.length() - 1) {
                    return node.middleIsWord();
                }
                else if(i == word.length()) {
                    return node.isWord();
                }
                node = node.getMiddle();
            }
            else if (nodeLetter > letter) {
                node = node.getLeft();
            }
            else {
                node = node.getRight();
            }
            if (node == null) {
                return false;
            }
        }
        return false;
    }

}
