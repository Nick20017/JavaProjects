public class Main {

    public static void main(String[] args) {
        var st1 = new Static(1, "Str");
        System.out.println("a: " + st1.a);
        System.out.println("b: " + st1.b);
        System.out.println("sa: " + Static.sa);
        System.out.println("sb: " + Static.sb);
        
        var st2 = new Static(1);
        System.out.println("a: " + st2.a);
        System.out.println("b: " + st2.b);
        System.out.println("sa: " + Static.sa);
        System.out.println("sb: " + Static.sb);
    }
}
