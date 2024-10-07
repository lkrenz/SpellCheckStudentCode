public class Node {

    private Node left;

    public Node getLeft() {
        return left;
    }

    public Node getMiddle() {
        return middle;
    }

    public Node getMiddle(char letter) {
        if (this.middle == null) {
            this.middle = new Node(letter);
        }
        return middle;
    }

    public boolean middleIsWord() {
        if (middle != null) {
            return middle.isWord();
        }
        return false;
    }


    public Node getRight() {
        return right;
    }

    public void setMiddle(char letter, boolean isWord) {
        if (this.middle != null) {
            middle.setWord(true);
        }
        else {
            middle = new Node(letter, isWord);
        }
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

    public Node(char letter, boolean isWord) {
        this.letter = letter;
        this.middle = null;
        this.right = null;
        this.left = null;
        this.word = isWord;
    }

    public Node() {}

    public Node findChild(char letter) {
        if (letter == this.letter) {
            if (this.middle == null) {
                this.middle = new Node(letter);
            }
            return this.middle;
        }
        else if(letter < this.letter) {
            if (this.left == null) {
                this.left = new Node(letter);
            }
            return this.left;
        }
        else {
            if (this.right == null) {
                this.right = new Node(letter);
            }
            return this.right;
        }
    }



}
