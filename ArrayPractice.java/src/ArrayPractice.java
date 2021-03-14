import java.security.spec.RSAOtherPrimeInfo;
import java.util.Arrays;

/**
 *
 * Erik Gill-Fisher
 */
public class ArrayPractice {
    public static void main(String[] args) {
        int[] A = new int[5];
        int[] B = {10, 30, 50};
        int[] C = {1, 1, 7, 1, 5, 9, 11, 100, 1, 1};
        int[] D = {15, 17, 19, 21, 23, 21, 27, 29, 31};
        int[] E = {1,5,7,9,11,13,15};
        int[] F = {9,10,35,99,4,99};
        int[] G = {22,4,82,44,63,99,7,29,42,19};
        int[] H = {1,7,9,11,67,32,11,24};
        int[] I = {2,4,3,6,8};
        int[] J = {4,7,29,77,2};
        int[] K = {3,5,7,189,500};
        int[] L = {2,4,6,8,20,21,24,35};
        int[] M = {10,11,12,1,2,3,4,5};
        int[] N = {10,20,30,40,50};
        int[] O = {10,20,50,60,70};
        int[] P = {10,11,12,1,2,3,4,5};
        int[] Q1 = {10,20,30};
        int[] Q2 = {1,2,3};
        int[] R = {10, 20, 30, 40, 50};
        int[] S = {1,1,2,3,3,4,5,6,6,7,8,8,9,10};

        initialize(A,10);
        System.out.println(average(B));
        System.out.println(numOccurrences(C, 1));
        System.out.println(find(D,21));
        System.out.println(findN(E,7,1));
        System.out.println(findLast(F,99));
        System.out.println(largest(G));
        System.out.println(indexOfLargest(H));
        System.out.println(indexOfLargestOdd((I)));
        copy(J);
        System.out.println(Arrays.toString(copyN(K, 4)));
        copyOdds(L);
        remove(M, 4);
        shiftLeft(N);
        System.out.println(isSortedAscending(O));
        System.out.println(sortedAscendingRun(P,-1));
        System.out.println(copyAll(Q1,Q2));
        reverse(R); //reverses array R
        System.out.println(uniques(S));
        
    }

    public static void initialize(int A[], int initialValue) {

        Arrays.fill(A, initialValue);
        System.out.println(Arrays.toString(A));
    } //A

    public static double average(int[] A) {
        int sum = 0;
        for (int i = 0; i < A.length; i++)
            sum += A[i];

        double avg = (double) sum / A.length;

        return avg;
    } //B

    public static int numOccurrences(int A[], int x) {
        int count = 0; //sets count = 0

        for (int i = 0; i < A.length; i++)
            if (x == A[i])
                count++;

        return count;
    } //C

    public static int find(int A[], int x) {

        for (int i = 0; i < A.length; i++) {
            if (A[i] == x) {
                return i;
            }
        }
        return -1;
    }

    public static int findN(int A[], int item, int n) {

        for (int i = 0; i < A.length; i++) {
            if (A[i] == item && i < n) {
                return i;
            }
        }
        return -1;
    } //E

    public static int findLast ( int A[], int x){ //F

        for (int i = A.length - 1; i >= 0 ; i--) {
            if (A[i] == x) {
                return i;
            }
        }
        return -1;
    }

    public static int largest ( int A[]){ //G
        int max = A[0];
        for(int i = 1; i < A.length; i++){
            if(A[i] > max){
                max = A[i];
            }
        }

        return max;
    }

    public static int indexOfLargest ( int A[]){ //H
        int max = 0;
        int index = 0;

        for(int i = 0; i < A.length; i++){
            if(max < A[i]){
                max = A[i];
                index = i;
            }
        }
        return index;
    }

    /*
     * returns the index of the largest odd number in the array A references or -1 if the array
     * contains no odd numbers
     */
    public static int indexOfLargestOdd ( int A[]){ //I
        int max = 0;
        int index = 0;

        for(int i = 0; i < A.length; i++) {
            if(max < A[i] && max % 2 != 0){
                max = A[i];
                index = i;
                }
            return index;

        }
        return -1;
    }

    public static int[] copy ( int A[]){ //J

        int[] newJ = Arrays.copyOf(A, A.length);
        System.out.println(Arrays.toString(newJ));

        return newJ;
    }

    public static int[] copyN ( int A[], int n){ //K
        if (n <= 0){
            return null;
        }else {
            int[] k2 = Arrays.copyOf(A,n);
            return k2;
        }
    }

    public static int[] copyOdds ( int[] A) { //L
        int[] C = new int[A.length];
        int M = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 != 0) {
                C[M] = A[i];
                M++;
            }
        }
        if(0 >= M)
            return null;

        return copyN(C,M);
    }

    public static int remove ( int[] A, int x) {//M
       int[] newA = new int[A.length - 1];
        for(int i = 0, k = 0; i < A.length; i++){
            if (i == x){
                continue;
            }
            newA[k++] = A[i];

        }
        System.out.println(Arrays.toString(newA));
        System.out.print(x);

        if (x < 0 || x > A.length)
        {
            return -1;
        }
        return -1;
    }

    public static void shiftLeft ( int[] A) { //N
        if(A != null && A.length > 0){
            for(int i = 0; i < A.length - 1; i++)
                A[i] = A[i+1];
            A[A.length - 1] = 0;
        }
        System.out.println(Arrays.toString(A));
    }

    /*
     * returns true if A is in sorted ascending order and false otherwise
     */
    public static boolean isSortedAscending ( int[] A){ //O
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] > A[i + 1]) {
                return false; // It is proven that the array is not sorted.
            }
        }

        return true;
    }

    public static int sortedAscendingRun ( int[] A, int x){ //P
        if(x < 0 || x > A.length)
            return -1;

        int count = 1;
        int current = A[x];
        for(int i = x+1; i < A.length; i++){
            if(A[i] > current){
                current = A[i];
                count++;
            }else{
                break;
            }
        }
        return count;
    }

    public static int[] copyAll ( int A[], int B[]){

        int [] copy = new int[A.length + B.length];
        int count = 0;

        for(int i = 0; i < A.length; i++){
            copy[i] = A[i];
            count ++;
        }

        for( int j = 0; j < B.length; j++){
            copy[count++] = B[j];
        }
        for(int i = 0; i < copy.length; i++)
            System.out.print(copy[i]+ " ");
        return copy;
    } //Q

    public static void reverse (int... A){
        int i = 0;
        for (i = 0; i < A.length / 2; i++) {
            int rev = A[i];
            A[i] = A[A.length - 1 - i];
            A[A.length - 1 - i] = rev;
            System.out.println(Arrays.toString(A));
        }

    } //R

    public static int[] uniques ( int A[]){
        int B[] = new int[A.length];

        int count = 0;
        for (int i = 0; i < A.length; i++) {
            if (numOccurrences(B, A[i]) == 0) {
                B[count] = A[i];
                count++;
            }
        }
        int c[] = copyN(B, count);
        System.out.println(c);
        return B;
    } //S
}

