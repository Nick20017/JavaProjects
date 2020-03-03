import java.util.Scanner;

public class Watches {
    private int[] args;

    public Watches () {
        args = new int[4];
        try {
            inputArray("first", 0);
            inputArray("second", 1);
            inputArray("third", 2);
            inputArray("fourth", 3);
        } catch(Exception e) {
            errorMessage();
        }
    }

    public Watches(int[] arr) {
        args = arr;
    }

    public Watches(int first, int second, int third, int fourth) {
        args = new int[] {
                first, second, third, fourth
        };
    }

    public void convertToWatches() {
        for(int n = 0; n < args.length; n++) {
            if(args[n] < 0 || args[n] > 9) {
                errorMessage();
                return;
            }
        }

        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        for(int n = 0; n < args.length; n++) {
            if(args[n] == 0)
                count0++;
            else if(args[n] == 1)
                count1++;
            else if(args[n] == 2)
                count2++;
            else if(args[n] == 3)
                count3++;
        }
        if(count3 > 3) {
            errorMessage();
            return;
        }

        if(count0 == 4 || count1 == 4 || count2 == 4)
            return;

        int[] _count = new int[6]; // number of 4 5 6 7 8 9
        for(int n = 0; n < _count.length; n++)
            _count[n] = 0;
        for(int n = 0; n < args.length; n++) {
            if(args[n] == 4)
                _count[0]++;
            else if(args[n] == 5)
                _count[1]++;
            else if(args[n] == 6)
                _count[2]++;
            else if(args[n] == 7)
                _count[3]++;
            else if(args[n] == 8)
                _count[4]++;
            else if(args[n] == 9)
                _count[5]++;
        }
        for(int n = 0; n < _count.length; n++) {
            if(_count[n] == 4) {
                errorMessage();
                return;
            }
        }

        boolean[] is = {
                false, false, false
        }; // {(count2 >= 1), (count1 >= 1), (count0 >= 1)}

        int lessThanSix = 0;
        int lessThanThree = 0;
        if(count2 > 1) {
            for(int n = 0; n < args.length; n++) {
                if(args[n] < 6)
                    lessThanSix++;
            }
            if(lessThanSix < 3) { // 2 9 2 8
                errorMessage();
                return;
            }

            is[0] = true;
        } else if(count2 == 1) {
            for(int n = 0; n < args.length; n++) {
                if(args[n] < 4)
                    lessThanThree++;
                else if(args[n] < 6)
                    lessThanSix++;
            }

            // 2 7 9 6 || 2 3 7 6
            if(lessThanThree == 1 && lessThanSix == 0 || lessThanThree == 2 && lessThanSix == 0) {
                errorMessage();
                return;
            }

            is[0] = true;
        } else if(count1 > 1) {
            is[1] = true;
        } else if(count1 == 1) {
            for(int n = 0; n < args.length; n++) {
                if(args[n] < 6)
                    lessThanSix++;
            }

            // 1 9 8 7
            if(lessThanSix < 2) {
                errorMessage();
                return;
            }

            is[1] = true;
        } else if(count0 >= 0) {
            for(int n = 0; n < args.length; n++) {
                if(args[n] < 6)
                    lessThanSix++;
            }

            // 0 9 6 8
            if(lessThanSix < 2) {
                errorMessage();
                return;
            }

            is[2] = true;
        } else {
            errorMessage();
            args = null;
            return;
        }

        sort();
        int[] watches = new int[args.length];
        if(is[0]) { // count2 >= 1
            find(watches, 0, 2);
            find(watches, 1, 3);
            find(watches, 2, 5);
            find(watches, 3, 9);
        } else if(is[1]) { // count1 >= 1
            find(watches, 0, 1);
            find(watches, 1, 9);
            find(watches, 2, 5);
            find(watches, 3, 9);
        } else if(is[2]) { // count0 >= 1
            find(watches, 0, 0);
            find(watches, 1, 9);
            find(watches, 2, 5);
            find(watches, 3, 9);
        }
        // Starts from 0
        args = watches;
    }

    private void find(int[] arr /* output array */, int i /* index to put a value to */, int num /* max number allowed */) {
        for(int n = 0; n < args.length; n++) {
            if(args[n] >= 0 && args[n] <= num) {
                arr[i] = args[n];
                args[n] = -1;
                return;
            }
        }
    }

    private void sort() {
        int temp;
        for(int i = 0; i < args.length; i++) {
            for(int j = i; j < args.length; j++) {
                if(args[i] < args[j]) {
                    temp = args[i];
                    args[i] = args[j];
                    args[j] = temp;
                }
            }
        }
    }

    public String ToString() {
        String str = "";

        str += args[0];
        str += args[1];
        str += ":";
        str += args[2];
        str += args[3];

        return str;
    }

    public int[] getArray() {
        return args;
    }

    public void printArray() {
        for(int n = 0; n < args.length; n++) {
            System.out.print(args[n] + " ");
        }
    }

    private void inputArray(String index, int i) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter " + index +" number: ");
        args[i] = scan.nextInt();
    }

    public void errorMessage() {
        for(int n = 0; n < args.length; n++) {
            args[n] = 0;
        }
        System.out.println("You've entered wrong value!!! Get out of here, it's not for you! ;P");
    }
}
