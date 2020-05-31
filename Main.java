public class Main {

    public static void main(String[] args) {
        try {
            System.out.println(TryCatch.sum(6, 6));
        } catch(NullPointerException e) {
            System.out.println(e);
            e.fillInStackTrace();
        } catch (CantSumException e) {
            System.out.println(e);
            e.fillInStackTrace();
        } finally {
            System.out.println("Done");
        }
    }
}
