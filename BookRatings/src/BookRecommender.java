import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.lang.Math;

public class BookRecommender {
    public static void main(String[] args) throws FileNotFoundException {
        String[] Q = loadBooks("books.txt");
        int[][] R = loadRatings("ratings.txt");
        int[] S = RatingUsers("books.txt");
        double[] T = similarityScores(S,R);
        System.out.println(score(T,R,0));

        System.out.println("We think you would enjoy " + Q + " the most."); //can't figure out how to print the index of the highest book.

    }

    public static double cosineSimilarity(int[] A, int[] B) {

        int sumA = 0;
        int sumB = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != -1) {
                sumA += (A[i] * A[i]);
            }
            if (B[i] != -1) {
                sumB += (B[i] * B[i]);
            }
        }
        double pA = Math.sqrt(sumA);
        double pB = Math.sqrt(sumB);

        int both = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != -1 && B[i] != -1) {
                both += (A[i] * B[i]);
            }
        }
        return both / (pA * pB);
    }//cosine similarity method

    public static double score(double[] A, int[][] B, int x) { //A = userScores. B = bookRatings. x = index of book

        double sumScoreWeightProduct = 0;
        double sumWeights = 0;

        for (int i = 0; i < B[i].length; i++) {
            if (B[i][x] != -1) {
                sumScoreWeightProduct += (B[i][x] * A[i]);
                sumWeights += A[i];
            }
        }
        return sumScoreWeightProduct / sumWeights;
    } //weighted average method

    public static String[] loadBooks(String fileName){
        String[] B = new String[20];

        try {
            Scanner book = new Scanner(new File("C:\\Users\\erikg\\IdeaProjects\\BookRatings\\src\\books.txt"));
           // String line = null;
            int i = 0;
            while(book.hasNextLine() && i < B.length){
                B[i] = book.nextLine();
                i++;
            }
            book.close();
        }catch(IOException c){
            System.out.println("Error");
        }
        return B;
    } //loads in book file

    public static int[][] loadRatings(String filename) throws FileNotFoundException {
        Scanner input = new Scanner(new File("C:\\Users\\erikg\\IdeaProjects\\BookRatings\\src\\ratings.txt"));

        int[][] rating = new int[30][20];
        int r = -1;

        while (input.hasNextLine()) {
            r++;
            String line = input.nextLine();
            Scanner lineScan = new Scanner(line);
            int n = 0;
            while (lineScan.hasNextInt()) {
                rating[r][n] = lineScan.nextInt();
                n++;
            }
        }
        return rating;
    } //loads in rating

    public static double[] similarityScores(int[] A, int[][] B) {
        double[] similar = new double[B.length];
        for (int i = 0; i < B.length; i++) {
            similar[i] = cosineSimilarity(A, B[i]);
        }
        return similar;
    } //calculates similarity

    public static int[] RatingUsers(String filename) throws FileNotFoundException{
        String[] Books = loadBooks(filename);
        Scanner userIn = new Scanner(System.in);
        int[] nums = new int[20];

        for (int i = 0; i < nums.length; i++){
            System.out.println("Enter rating for " + Books[i] + ":");
            nums[i] = userIn.nextInt();
            if (nums[i] > 5 || nums[i] < -1 || nums[i] == 0){
                System.out.println("Error, must be between 0 and 5 or -1 if unread");
                i--;
            }
        }
        return nums;
    } //user input for their book ratings


}