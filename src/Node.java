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

    public Node setMiddle(Node middle) {
        this.middle = middle;
        return this.middle;
    }

    public Node setChild(char letter) {
        if (letter == this.letter) {
            this.middle = new Node(letter);
            return this.middle;
        }
        else if(letter < this.letter) {
            this.left = new Node(letter);
            return this.left;
        }
        else {
            this.right = new Node(letter);
            return this.right;
        }

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
        this.middle = null;
        this.right = null;
        this.left = null;
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
