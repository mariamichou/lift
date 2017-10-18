package enumeration;

public enum Direction {

    UP(1, "Up"),
    DOWN(0, "Down");

    int id;
    String value;

    Direction() {
        this.id = 0;
        this.value = "Down";
    }

    Direction(int id, String value) {
        this.id = id;
        this.value = value;
    }
}
