import java.util.Scanner;

public class Tasks {
    private static Scanner scan = new Scanner(System.in);

    public static void Task1() {
        System.out.print("Enter any number of characters: ");
        StringBuilder str = new StringBuilder(scan.nextLine());

        String ch = str.substring(str.length()-1, str.length());
        int count = 0;
        for(int i = 0; i < str.length(); i++) {
            if (str.substring(i, i + 1).compareTo(ch) == 0)
                count++;
        }

        System.out.println("Number of '" + ch + "' is " + count);
    }

    public static void Task2() {
        System.out.print("Enter any number of characters: ");
        StringBuilder str = new StringBuilder(scan.nextLine());
        System.out.println(str.reverse());
    }

    public static void Task3() {
        System.out.print("Enter any number of characters: ");
        StringBuilder str = new StringBuilder(scan.nextLine());

        boolean check = false;
        if(str.length() % 2 != 0) {
            String s1 = str.substring(0, str.length() / 2);
            String s2 = str.reverse().substring(0, str.length() / 2);
            if(s1.compareTo(s2) == 0)
                check = true;
        } else {
            String s1 = str.substring(0, str.length() / 2);
            String s2 = str.reverse().substring(0, str.length() / 2);
            if(s1.compareTo(s2) == 0)
                check = true;
        }

        if(check)
            System.out.println(str.reverse() + " is palindrome!");
        else
            System.out.println(str.reverse() + " is not palindrome!");
    }

    public static void Task4() {
        System.out.print("Enter any number of characters: ");
        StringBuilder str = new StringBuilder(scan.nextLine());

        int sum = 0;
        for(int i = 0; i < str.length(); i++) {
            if(str.substring(i, i+1).toCharArray()[0] > '0' && str.substring(i, i+1).toCharArray()[0] < '9') {
                sum +=  Integer.parseInt(str.substring(i, i+1));
            }
        }

        System.out.println("Sum of numbers given is " + sum);
    }

    public static void Task5() {
        System.out.print("Enter expression: ");
        StringBuilder expression = new StringBuilder(scan.nextLine());
        Integer[] brackets = {0 /* Left */, 0 /* Right */};

        for(int i = 0; i < expression.length(); i++) {
            if(expression.substring(i, i+1).toCharArray()[0] == '(')
                brackets[0]++;
            else if(expression.substring(i, i+1).toCharArray()[0] == ')')
                brackets[1]++;
        }

        if(brackets[0] == brackets[1])
            System.out.println("OK");
        else
            System.out.println("Wrong brackets pairing!");
    }

    public static void Task6() {
        System.out.print("Enter any number of characters to encode: ");
        StringBuilder str = new StringBuilder(scan.nextLine());
        System.out.print("Enter character's move: ");
        int move = scan.nextInt();

        String encode = "";
        char temp;
        for(int i = 0; i < str.length(); i++) {
            temp = str.substring(i, i+1).toCharArray()[0];
            if((int)temp + move > (int)'z' && temp != ' ') {
                encode += (char)((int)'a' + (move - ((int)'z' - (int)temp) - 1));
            } else if((int)temp + move < (int)'a' && temp != ' ') {
                encode += (char)((int)'z' - (move + ((int)temp - (int)'a') + 1));
            } else {
                encode += (char)((int)temp + move);
            }
        }

        System.out.println("Encoded string: " + encode);
    }
}
