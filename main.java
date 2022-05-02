import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;

public class main {
    // bubbleSort Function
    static void userInput() {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Enter N : ");
        File myObj = new File("input.txt");
        try {
            if (myObj.createNewFile()) {
            }
        } catch (IOException e) {
            System.out.println("Error");
        }
        int n = myScanner.nextInt();
        for (int i = 0; i < n; i++) {
            try {
                FileWriter myWriter = new FileWriter("INPUT.txt");
                for (i = 0; i < n; i++) {
                    double temp = myScanner.nextDouble();
                    myWriter.write(String.valueOf(temp) + "\n");
                }
                myWriter.close();
            } catch (IOException e) {
                System.out.println("Error");
            }

        }
    }

    static double[] readFile() throws Exception {
        // pass the path to the file as a parameter
        File file = new File("input.txt");
        Scanner sc = new Scanner(file);
        String str = "";
        while (sc.hasNextLine())
            str = str + sc.nextLine() + "\n";

        String[] arrStr = str.split("\n");
        int length = arrStr.length;
        double[] arrDouble = new double[length];

        for (int i = 0; i < length; i++) {
            arrDouble[i] = Double.valueOf(arrStr[i].trim());
            System.out.print(arrDouble[i] + "     ");
        }
        System.out.println();
        return arrDouble;
    }

    static void bubbleSort(double arr[], String path) throws Exception {
        File OUTPUT = new File(path);
        if (OUTPUT.createNewFile()) {
            System.out.println("");
        }
        FileWriter myWriter = new FileWriter(path);
        long start = System.nanoTime();

        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    double temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            for (int k = 0; k < n; k++) {
                myWriter.write(String.valueOf(arr[k]) + "     ");
            }
            myWriter.write("\n");
        }
        long end = System.nanoTime();
        long timer = end - start;
        System.out.println();
        System.out.println("Processing in " + timer / 1000000 + " ms");
        myWriter.write("Processing in " + timer / 1000000 + " ms");
        myWriter.close();
    }

    // selectionSort Function
    static void selectionSort(double arr[], String path) throws Exception {
        File OUTPUT = new File(path);
        if (OUTPUT.createNewFile()) {
            System.out.println("");
        }
        FileWriter myWriter = new FileWriter(path);
        long start = System.nanoTime();
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {

            int minIndex = i;

            for (int j = i + 1; j < n; j++)
                if (arr[j] < arr[minIndex])
                    minIndex = j;

            double temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;

            for (int k = 0; k < n; k++) {
                myWriter.write(String.valueOf(arr[k]) + "     ");
            }
            myWriter.write("\n");

        }
        long end = System.nanoTime();
        long timer = end - start;
        System.out.println();
        System.out.println("Processing in " + timer / 1000000 + " ms");
        myWriter.write("Processing in " + timer / 1000000 + " ms");
        myWriter.close();
    }

    // insertionSort Function
    static void insertionSort(double arr[], String path) throws Exception {
        File OUTPUT = new File(path);
        if (OUTPUT.createNewFile()) {
            System.out.println("");
        }
        FileWriter myWriter = new FileWriter(path);
        long start = System.nanoTime();
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            double current = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > current) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = current;

            for (int k = 0; k < n; k++) {
                myWriter.write(String.valueOf(arr[k] + "     "));
            }
            myWriter.write("\n");

        }
        long end = System.nanoTime();
        long timer = end - start;
        System.out.println();
        System.out.println("Processing in " + timer / 1000000 + " ms");
        myWriter.write("Processing in " + timer / 1000000 + " ms");
        myWriter.close();
    }

    // linearSearch Function
    static void linearSearch(double arr[], double k, String path) throws Exception {
        File OUTPUT = new File(path);
        if (OUTPUT.createNewFile()) {
            System.out.println("");
        }
        FileWriter myWriter = new FileWriter(path);

        int n = arr.length;

        System.out.print("Index : ");
        myWriter.write("Index : ");
        for (int i = 0; i < n; i++) {
            if (arr[i] >= k) {
                myWriter.write(String.valueOf(i) + "   ");
                System.out.print(i + " ");
            }

        }
        System.out.println();
        myWriter.write('\n');
        myWriter.close();
    }

    // binarySearch Function
    static int binarySearch(double arr[], double value) {
        int n = arr.length;
        int l = 0, r = arr.length - 1;
        // Sort array
        for (int i = 1; i < n; ++i) {
            double current = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > current) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = current;
        }
        // binarySearch
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] == value) {
                return m;
            }
            if (arr[m] < value) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) throws Exception {
        Scanner myScanner = new Scanner(System.in);
        int i;
        double k;
        /* INPUT */
        double[] a;

        System.out.println();
        // PROCESSING
        System.out.println("Select : ");
        System.out.println("1 : Enter Array  ");
        System.out.println("2 : readFile ");
        System.out.println("3 : bubbleSort ");
        System.out.println("4 : selectionSort ");
        System.out.println("5 : insertionSort ");
        System.out.println("6 : linearSearch ");
        System.out.println("7 : binarySearch ");
        char conti = 'Y';
        while (conti == 'Y' || conti == 'y') {
            conti = 'N';

            System.out.print("Yout selection: ");

            switch (myScanner.nextInt()) {
                case 1:
                    userInput();
                    System.out.print("Do you want to continue ? (Y/N) : ");
                    conti = myScanner.next().charAt(0);
                    break;
                case 2:
                    readFile();
                    System.out.print("Do you want to continue ? (Y/N) : ");
                    conti = myScanner.next().charAt(0);
                    break;
                case 3:
                    a = readFile();
                    bubbleSort(a, "OUTPUT1.txt");
                    System.out.println("Result wrote in file ");
                    System.out.print("Do you want to continue ? (Y/N) : ");
                    conti = myScanner.next().charAt(0);

                    break;
                case 4:
                    a = readFile();
                    selectionSort(a, "OUTPUT2.txt");
                    System.out.println("Result wrote in file ");
                    System.out.print("Do you want to continue ? (Y/N) : ");
                    conti = myScanner.next().charAt(0);
                    break;
                case 5:
                    a = readFile();
                    insertionSort(a, "OUTPUT3.txt");
                    System.out.println("Result wrote in file ");
                    System.out.print("Do you want to continue ? (Y/N) : ");
                    conti = myScanner.next().charAt(0);
                    break;
                case 6:
                    a = readFile();
                    System.out.println();
                    System.out.print("Enter value to search (linearSearch): ");
                    k = myScanner.nextDouble();
                    linearSearch(a, k, "OUTPUT4.txt");
                    System.out.println("Result wrote in file ");
                    System.out.print("Do you want to continue ? (Y/N) : ");
                    conti = myScanner.next().charAt(0);
                    break;
                case 7:
                    File OUTPUT = new File("OUTPUT5.txt");
                    if (OUTPUT.createNewFile()) {
                        System.out.println("");
                    }
                    a = readFile();
                    FileWriter myWriter = new FileWriter("OUTPUT5.txt");
                    System.out.println();
                    System.out.print("Enter value to search (binarySearch): ");
                    k = myScanner.nextDouble();
                    myWriter.write(String.valueOf(binarySearch(a, k)));

                    System.out.println("Sorted array: ");
                    for (i = 0; i < a.length; i++) {
                        System.out.print(a[i] + "     ");
                    }
                    System.out.println("Index : " + binarySearch(a, k));
                    myWriter.close();
                    System.out.print("Do you want to continue ? (Y/N) : ");
                    conti = myScanner.next().charAt(0);
                    break;
                default:
                    System.out.println("Wrong selection !!!");
                    System.out.print("Do you want to continue ? (Y/N) : ");
                    conti = myScanner.next().charAt(0);
            }
        }
    }

}
