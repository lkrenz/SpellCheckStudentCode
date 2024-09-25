public class Storage {
    Storage[] children;
    boolean isWord;

    public Storage(boolean isWord) {
        this.isWord = isWord;
        this.children = new Storage[27];
    }

    public Storage() {
        this.isWord = false;
        this.children = new Storage[27];
    }

    public void setChild(String value) {
        if (value.isEmpty()) {
            isWord = true;
            return;
        }
        int val = (int) value.charAt(0) - 97;
        if (val < 0) {
            val = 26;
        }
        if (val > 26) {
            return;
        }
        if (children[val] == null) {
            children[val] = new Storage();
        }
        String newValue;
        if (value.length() == 1) {
            newValue = "";
        }
        else {
            newValue = value.substring(1);
        }
        children[val].setChild(newValue);
    }

    public boolean checkWord(String value) {
        if (this.isWord && value.isEmpty()) {
            return true;
        }
        else if (value.isEmpty()) {
            return false;
        }
        String word;
        if (value.length() == 1) {
            word = "";
        }
        else {
            word = value.substring(1);
        }

        int val = (int) value.charAt(0) - 97;
        if (val < 0) {
            val = 26;
        }
        if (val > 26) {
            return false;
        }
        if (children[val] == null) {
            return false;
        }
        return children[val].checkWord(word);
    }
}