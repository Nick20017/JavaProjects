public class Static {
    public int a;
    public String b;

    public static int sa;
    public static String sb;

    public Static(int a) {
        this.a = a;
    }

    public Static(int a, String b) {
        this(a);
        this.b = b;
    }

    static {
        sa = 5;
        sb = "Some string";
    }
}
