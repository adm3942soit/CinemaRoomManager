

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.System.out;
import static java.util.stream.Collectors.toList;


import java.io.BufferedReader;
import java.util.Scanner;

public class Main {
    public static int gcd(int a, int b) {
        while (b > 0) {
            int c = a % b;
            a = b;
            b = c;
        }
        return a;
    }

    public static int getNumberOfMaxParam(int a, int b, int c) {
        Map<Integer, Integer> pair = new HashMap<>();
        int tempMax = a;
        pair.clear();
        pair.put(a, 1);
        if (tempMax < b) {
            tempMax = b;
            pair.clear();
            pair.put(b, 2);
        }
        if (tempMax < c) {
            tempMax = c;
            pair.clear();
            pair.put(c, 3);
        }

        return pair.get(tempMax);
    }

    public static long sumInRange(int from, int to) {
        int sum = 0;
        for (int i = from; i < to; i++) {
            sum = sum + i;
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
/*
        final Scanner scanner = new Scanner(System.in);

        int from = scanner.nextInt();
        int to = scanner.nextInt();

        System.out.println(sumInRange(from, to));
*/

        /*
        out.println(gcd(1,1));
        out.println(gcd(3,6));
        out.println(gcd(3,7));
        out.println(gcd(6,2));
        out.println(gcd(1,3));
        out.println(gcd(4,6));
*/
/*
        Scanner scanner = new Scanner(System.in);

        final int a = scanner.nextInt();
        final int b = scanner.nextInt();
        final int c = scanner.nextInt();

        System.out.println(getNumberOfMaxParam(a, b, c));
*/

/*
        char[] array = new char[0];
        //char[] array1 = new char[10000000000000];
        char[] array2 = { 'a', 'b', 'c', 'd' };
        //char[] array3 = new char[-1];
        char[] array4 = new char[1];
*/
        /*
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
            if (i < 3) {
                continue;
            } else {
                for (int j = 0; j < 5; j++) {
                    System.out.println(j);
                }
            }
        }
*/
        /*
        int i = 0;
        while (i < 10) {
            i++;
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
        }
*/
        /*
        char c = '1' + '3';
        System.out.println(c);
*/
/*
        Scanner scanner = new Scanner(System.in);

        int i = 0;
        int[] digits = new int[4];
        while (scanner.hasNext()) {
            digits[i] = scanner.nextInt();
            i++;
            if (i == 4) break;
        }
        for (int digit : digits) {
            out.println(--digit);
        }
*/
/*
        String no = "NO";
        String yes = "YES";
        if (digits[0] + digits[1] > digits[2]) {
            if (digits[0] + digits[2] > digits[1]) {
                if (digits[1] + digits[2] > digits[0]) {
                    out.println(yes);
                    return;
                }
            }
        }
        out.println(no);
*/

/*        int n = 0;
        boolean complete = false;
        for (int digit : digits) {
            for (int j = 0; j < 3; j++) {

                try {
                    if (n != j) {
                        boolean x = (digit + digits[j]) == 20;
                        if (x) {
                            System.out.println("true");
                            complete = true;
                            break;
                        } else continue;
                    }
                } catch (Exception exception) {
                    System.out.println("false");
                    complete = true;
                    break;
                }


            }
            if (complete) break;
            n++;
        }
        if (!complete) {
            System.out.println("false");
        }
*/
/*
        if (digits[1] <= digits[0] && digits[0] <= digits[2]) {
            System.out.println("true");
        } else if (digits[2] <= digits[0] && digits[0] <= digits[1]) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
*/
/*
        if ((digits[0] > 0 && digits[1] <= 0 && digits[2] <= 0)
                ||
                (digits[1] > 0 && digits[0] <= 0 && digits[2] <= 0)
                ||
                (digits[2] > 0 && digits[0] <= 0 && digits[1] <= 0)
        ) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
*/
/*
        int digit;
        while (scanner.hasNext()) {
            digit = scanner.nextInt();
            if(digit>0 && digit<10){
                System.out.println("true");
            }else System.out.println("false");
            break;
        }
*/
/*
        int digit;
        boolean weekend;
        while (scanner.hasNext()) {
            digit = scanner.nextInt();
            if(scanner.hasNextBoolean()) {
                weekend = scanner.nextBoolean();
                if(weekend){
                    if(digit>=15 && digit<=25){
                        System.out.println("true");
                    }else System.out.println("false");
                    break;
                }else {
                    if(digit>=10 && digit<=20){
                        System.out.println("true");
                    }else System.out.println("false");
                    break;
                }
            }
        }
*/

        int rows;
        int columns;

        int[] res = input("Enter the number of rows:\n>", "Enter the number of seats in each row:\n>");
        rows = res[0];
        columns = res[1];
        String[][] seats = new String[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                seats[i][j] = "S";
            }
        }
        int choice = -2;
        int currentIncome = 0;
        int countSeats = rows * columns;
        int halfFrontRows = rows / 2;
        int secondHalfFrontRows = rows - halfFrontRows;
        int countPurchasedSeats = 0;
        int totalIncome = ((countSeats <= 60) ? (10 * countSeats) : (halfFrontRows * columns * 10 + secondHalfFrontRows * columns * 8));
        while (choice == -2) {
            choice = printMenu();
            if (choice == 0 || choice == -1) {
                return;
            } else if (choice == 2) {
                if (countPurchasedSeats < countSeats) {
                    int[] res1 = inputSeats("Enter a row number:\n>", "Enter a seat number in that row:\n>");
                    int row = res1[0] - 1;
                    int seat = res1[1] - 1;
                    while (res1[0] > rows || res1[1] > columns || seats[row][seat] == "B") {
                        if (res1[0] > rows || res1[1] > columns) {
                            out.println("Wrong input !");
                        } else {
                            out.println("That ticket has already been purchased!");
                        }
                        res1 = inputSeats("Enter a row number:\n>", "Enter a seat number in that row:\n>");
                        row = res1[0] - 1;
                        seat = res1[1] - 1;
                    }
                    seats[row][seat] = "B";
                    int price = (countSeats <= 60 ? 10 : (res1[0] > halfFrontRows ? 8 : 10));
                    out.println("Ticket price: $" + price);
                    currentIncome = currentIncome + price;
                    countPurchasedSeats++;
                } else {
                    out.println("All tickets has already been purchased!");
                }
                choice = -2;
            } else if (choice == 1) {
                printCinema(rows, columns, seats);
                choice = -2;
            } else {
                printStatistics(seats, currentIncome, totalIncome, countPurchasedSeats);
                choice = -2;
            }
        }

        //printCinema(res[0], res[1], -1, -1);
        //int[] res1 = input("Enter a row number:\n>", "Enter a seat number in that row:\n>");


        //out.println("Ticket price:");

        // printCinema(res[0], res[1], res1[0], res1[1]);


        //fizzBuzz(15);
/*
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\MyRepository\\Training\\temp.txt"));

        List<List<Integer>> arr = inputArray(bufferedReader);
        int[][] inputArray=convertToArray(arr, 6);
        printD2Array(inputArray);

        int result = hourglassSum(arr, 6);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
*/
/*
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            out.println(String.valueOf(isBalanced(in.next())));
        }
*/
/*
        final Scanner scanner = new Scanner(System.in); // 1
        final int a=0;                                    // 2
        final int b = scanner.nextInt() + a;            // 3
        int c = 0;                                // 4
        c = b;                                          // 5
        System.out.println(c + 1);
*/
/*
        String str1;
        String str2 = "123";
        if (str2.equals(str1 = "123")) {
            str2 = null;
        }

        str1 = str2;
        str2 = str1;

        System.out.println(str2);
*/
    }

    static void printStatistics(String[][] seats, int income, int totalIncome, int countPurchasedSeats) {
        int purchased = 0;
        double percent = 0.00;
        for (String[] rowSeats : seats) {
            for (String seat : rowSeats) {
                if (seat == "B") {
                    purchased++;
                    percent = ((double) countPurchasedSeats / (double) (seats.length * seats[0].length)) * 100;
                }
            }
        }

        out.println("Number of purchased tickets: " + purchased);
        out.println("Percentage: " + String.format("%.2f", percent) + "%");
        out.println("Current income: $" + income);
        out.println("Total income: $" + totalIncome);
    }

    public static void checkTheCode(String input) {
        boolean result = Boolean.parseBoolean(input);
        result = !result;
        String output = String.valueOf(result);
        System.out.println(output);
    }

    static Boolean isBalanced(String str) {
        Stack<Character> stk = new Stack<>();
        Map<Character, Character> bracketMap = new HashMap<>();
        bracketMap.put(')', '(');
        bracketMap.put('}', '{');
        bracketMap.put(']', '[');

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '[')
                stk.push(str.charAt(i));
            if (str.charAt(i) == ')' || str.charAt(i) == '}' || str.charAt(i) == ']') {
                if (stk.empty())
                    return false;
                if (stk.elementAt(0) == bracketMap.get(str.charAt(i)))
                    stk.pop();
            }
        }

        return (stk.empty() == true);
    }


    public static int hourglassSum(List<List<Integer>> arr, int n) {
        int[][] result = convertToArray(arr, n);

        return arrayMaximum(result, n);
    }

    public static int[][] convertToArray(List<List<Integer>> arr, int n) {
        int[][] result = new int[n][n];
        int i = 0, j = 0;
        for (List<Integer> integers : arr) {
            for (Integer integer : integers) {
                result[i][j] = integer;
                out.println("result[" + i + "][" + j + "] = " + result[i][j]);
                j++;
            }
            j = 0;
            i++;
        }
        printD2Array(result);
        return result;
    }

    public static List<List<Integer>> inputArray(BufferedReader bufferedReader) throws IOException {

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        return arr;
    }

    public static Integer arrayMaximum(int[][] arr, int n) {
        int max = Integer.MIN_VALUE;
        int tempMax = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i + 2 < n && j + 2 < n) {
                    tempMax += arr[i][j] + arr[i][j + 1] + arr[i][j + 2];
                    tempMax += arr[i + 1][j + 1];
                    tempMax += arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2];

                    if (max < tempMax) {
                        max = tempMax;
                    }

                    tempMax = 0;
                }
            }
        }
        return max;
    }

    public static void printD2Array(int[][] array) {
        out.println(Arrays.deepToString(array));
    }

    public static void fizzBuzz(int n) {
        for (int i = 1; i <= n; i++) {
            String outputString = "";
            double d = Double.valueOf(i);
            if (d % 3 == 0) {
                outputString = "Fizz";
            }
            if (d % 5 == 0) {
                if (outputString.isEmpty()) {
                    outputString = "Buzz";
                } else if (outputString.equals("Fizz")) {
                    outputString = "FizzBuzz";
                }
            }
            if (outputString.isEmpty()) {
                outputString = String.valueOf(i);
            }
            out.println(outputString);
            outputString = "";
        }
    }

    static int[] inputSeats(String msg1, String msg2) {
        int[] result = input(msg1, msg2);
        return result;
    }

    static int[] input(String msg1, String msg2) {
        out.print(msg1);
        int y = 0;
        while (true) {
            Scanner sc = new Scanner(System.in);
            try {
                y = sc.nextInt();
                break;
            } catch (Exception ex) {
                out.println("Input please only digit!");
            }
        }
        out.print(msg2);
        int x = 0;
        while (true) {
            Scanner sc = new Scanner(System.in);
            try {
                x = sc.nextInt();
                break;
            } catch (Exception ex) {
                out.println("Input please only digit!");
            }
        }
        int[] result = new int[2];
        result[0] = y;
        result[1] = x;
        return result;
    }

    static int printMenu() {
        out.println("");
        out.println("1. Show the seats");
        out.println("2. Buy a ticket");
        out.println("3. Statistics");
        out.println("0. Exit");
        int x = -1;
        while (true) {
            Scanner sc = new Scanner(System.in);
            try {
                x = sc.nextInt();
                break;
            } catch (Exception ex) {
                x = -1;
                out.println("Input please only digit!");
            }
        }
        return x;
    }

    static void printCinema(int countRows, int countColumns, String[][] seats) {
        out.println("Cinema:");
        int row = 0;
        while (row < (countRows + 1)) {
            int column = 0;
            while (column < (countColumns + 1)) {
                if (row == 0) {
                    if (column == 0) {
                        out.print("  ");
                        column++;
                        continue;
                    } else {
                        out.print(column + " ");
                        column++;
                        continue;
                    }
                } else {
                    if (column == countColumns + 1) {
                        out.print(column);
                        column = 0;
                        row++;
                        continue;
                    }
                    String output = "";
                    if (column == 0) {
                        output = "\n" + row + " ";
                    } else {
                        output = seats[row - 1][column - 1] + " ";
                    }
                    out.print(output);
                    column++;
                    continue;
                }
            }
            row++;
        }
        out.print("\n\r");

    }

    static void printCinema(int countRows, int countColumns, int currectRow, int currentColumn) {
        out.println("Cinema:");
        int row = 0;
        while (row < (countRows + 1)) {
            int column = 0;
            while (column < (countColumns + 1)) {
                if (row == 0) {
                    if (column == 0) {
                        out.print("  ");
                        column++;
                        continue;
                    } else {
                        out.print(column + " ");
                        column++;
                        continue;
                    }
                } else {
                    if (column == countColumns + 1) {
                        out.print(column);
                        column = 0;
                        row++;
                        continue;
                    }
                    String output = "";
                    if (column == 0) {
                        output = "\n" + row + " ";
                    } else output = "S" + " ";
                    if (currentColumn != -1 && column == currentColumn && currectRow != -1 && currectRow == row) {
                        output = "B" + " ";
                    }
                    out.print(output);
                    column++;
                    continue;
                }
            }
            row++;
        }
        out.print("\n");
    }
}

