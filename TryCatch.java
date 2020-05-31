public class TryCatch {
    public static int sum(Integer a, Integer b) throws CantSumException {
        if(a != b)
            return a + b;
        else
            throw new CantSumException("Could not sum a and b! a must not be equal to b");
    }
}
