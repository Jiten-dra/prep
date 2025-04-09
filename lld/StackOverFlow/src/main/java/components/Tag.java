package components;

public class Tag {
    private String name;
    private int count;

    public Tag(String name) {
        this.name = name;
        this.count = 0;
    }

    public void incrementCount() {
        count++;
    }

    public int getCount() {
        return count;
    }

    public String getName() {
        return name;
    }
}
