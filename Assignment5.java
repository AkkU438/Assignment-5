import java.util.Scanner;
import java.util.Random;
import java.io.*;
import java.util.NoSuchElementException;




public class Assignment5 {
    public static void main(String[] args) throws Exception {

        int[][] matrix1, matrix2, matrix3;
        System.out.println("Hello, welcome to matrix multiplier");
        System.out.println("Enter 1 to use two files, or 2 to use random matrices");
        Scanner userInput = new Scanner(System.in);

        while (!userInput.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer: ");
            userInput.next(); // Discard invalid input
        }
        int userNum1 = userInput.nextInt(); // Now safe to read the integer

        if (userNum1 == 1) {

           Scanner scanner = new Scanner(System.in);
            System.out.println("Please print out the name of the first file");
            String filename1 = scanner.nextLine();
            System.out.println("Please print out the name of the second file");
            String filename2 = scanner.nextLine();
            try {Scanner scanner1 = new Scanner(new File(filename1));
            Scanner scanner3 = new Scanner(new File(filename2));
            int rows = scanner1.nextInt();
            int cols = scanner1.nextInt();
           
            matrix1 = new int[rows][cols];
            
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrix1[i][j] = scanner1.nextInt();
                    
                }
            }
            int rows2 = scanner3.nextInt();
            int cols2 = scanner3.nextInt();
            matrix2 = new int[rows2][cols2];
            for (int i = 0; i < rows2; i++) {
                for (int j = 0; j < cols2; j++) {
                    
                    matrix2[i][j] = scanner3.nextInt();
                }
            }
            matrix3 = new int[matrix1.length][matrix2[0].length];
            for (int i = 0; i < matrix1.length; i++) {
                for (int j = 0; j < matrix2[0].length; j++) {
                    int sum = 0;
                    for (int k = 0; k < matrix1[0].length; k++) { // Inner loop for dot product
                        sum += matrix1[i][k] * matrix2[k][j];
                    }
                    matrix3[i][j] = sum;
                }
            }
            System.out.println("Matrix 3:");
        for (int i = 0; i < rows; i++) {
            System.out.print("[");
            for (int j = 0; j < cols2; j++) {
                System.out.print(matrix3[i][j] + " ");
            }
            System.out.println("]");
        }
        writeMatrixToFile(matrix3, "matrix3.txt");
            
            System.out.println("Matrices written to files successfully!");
        } catch (IOException e) {
            System.out.println("Error writing files to matrix: " + e.getMessage());
        }
        
            



        } else{
        System.out.println("Please enter a number (will be used to determine the amount of rows)");
        Scanner userInput2 = new Scanner(System.in);
        int userNum2 = userInput2.nextInt();
        int size = userNum2;
        matrix1 = new int[size][size];
        matrix2 = new int[size][size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix2[i][j] = random.nextInt(10);
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix1[i][j] = random.nextInt(10);
            }
        }
        try {
            writeMatrixToFile(matrix1, "matrix1.txt");
            writeMatrixToFile(matrix2, "matrix2.txt");
            System.out.println("Matrices written to files successfully!");
        } catch (IOException e) {
            System.out.println("Error writing matrices to files: " + e.getMessage());
        }
        matrix3 = new int[matrix1.length][matrix2[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                int sum = 0;
                for (int k = 0; k < matrix1[0].length; k++) {
                    sum += matrix1[i][k] * matrix2[k][j];
                }
                matrix3[i][j] = sum;
            }
        }
        System.out.println("Matrix 3:");
        for (int i = 0; i < size; i++) {
            System.out.print("[");
            for (int j = 0; j < size; j++) {
                System.out.print(matrix3[i][j] + " ");
            }
            System.out.println("]");
        }
        try {
            writeMatrixToFile(matrix3, "matrix3.txt");
            
            System.out.println("Matrices written to files successfully!");
        } catch (IOException e) {
            System.out.println("Error writing matrices to files: " + e.getMessage());
        }
        

        }

    }
    public static void writeMatrixToFile(int[][] matrix, String filename) throws IOException {
    BufferedWriter writer = new BufferedWriter(new FileWriter(filename));

    for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix[i].length; j++) {
            writer.write(matrix[i][j] + " "); // Write each element with a space
        }
        writer.newLine(); // Move to the next line after each row
    }

    writer.close();
}
}
