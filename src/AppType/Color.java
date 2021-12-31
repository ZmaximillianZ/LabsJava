package AppType;

public final class Color {
    public static final String white = "white";
    public static final String black = "black";
    public static final String green = "green";
    public static final String yellow = "yellow";
    public static final String red = "red";
    public static final String blue = "blue";
    public static final String pink = "pink";
    public static final String orange = "orange";

    public static String[] colors() {
        return new String[]{white, black, green, yellow, red, blue, pink, orange};
    }

    private Color() { }
}
