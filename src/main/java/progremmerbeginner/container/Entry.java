package progremmerbeginner.container;

public class Entry <k,y>{

    private k key;

    private y value;

    public k getKey() {
        return key;
    }

    public void setKey(k key) {
        this.key = key;
    }

    public y getValue() {
        return value;
    }

    public void setValue(y value) {
        this.value = value;
    }
}
