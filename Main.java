public class Main {

    public static void main(String[] args) {
        var st = new Static(1, "Str");
        System.out.println("a: " + st.a);
        System.out.println("b: " + st.b);
        System.out.println("sa: " + Static.sa);
        System.out.println("sb: " + Static.sb);
    }
}
