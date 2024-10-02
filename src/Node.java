public class Node {

    private Node left;

    public Node getLeft() {
        return left;
    }

    public Node getMiddle() {
        return middle;
    }

    public Node getRight() {
        return right;
    }

    private Node middle;
    private Node right;

    public char getLetter() {
        return letter;
    }

    private char letter;

    public boolean isWord() {
        return word;
    }

    public void setWord(boolean word) {
        this.word = word;
    }

    private boolean word;

    public Node(char letter) {
        this.letter = letter;
    }

    public Node(char letter, boolean word) {
        this.letter = letter;
        this.word = word;
    }

    public Node() {}

    public Node findChild(char letter) {
        if (letter == this.letter) {
            return this.middle;
        }
        else if(letter < this.letter) {
            return this.left;
        }
        else {
            return this.right;
        }
    }



}
