/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiplicamatrius;
import java.util.*;
/**
 *
 * @author nuriatorquetluna
 */
public class MultiplicaMatrius {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

    System.out.println("Enter Row of Matrix A");
    int Rowa = s.nextInt();

    System.out.println("Enter Column of Matrix A");
    int Cola = s.nextInt();

    System.out.println("Enter Row of Matrix B");
    int Rowb = s.nextInt();

    System.out.println("Enter Column of Matrix B");
    int Colb = s.nextInt();

    int[][] A = new int[Rowa][Cola];
    int[][] B = new int[Rowb][Colb];

    int [][]C= new int[Rowa][Colb];
    //int[][] C = new int;
    System.out.println("Enter Values of Matrix A");

    for(int i =0 ; i< A.length ; i++) {
        for(int j = 0 ; j<A.length;j++) {
            A[i][j] = s.nextInt();
        }

    }

    System.out.println("Enter Values of Matrix B");

    for(int i =0 ; i< B.length ; i++) {
        for(int j = 0 ; j<B.length;j++) {
            B[i][j] = s.nextInt();
        }
    }




    if(Cola==Rowb) {
        for(int i = 0;i < A.length;i++){
              for(int j = 0;j < A.length;j++){
                 C[i][j]=0;
                 for(int k = 0;k < B.length;k++){
                    C[i][j] += A[i][k] * B[k][j];
                 }
              }
           }
    }
    else {
        System.out.println("Cannot multiply");
    }









    // Printing matrix A
    /*
    for(int i =0 ; i< A.length ; i++) {
        for(int j = 0 ; j<A.length;j++) {
        System.out.print(A[i][j]+ "\t");
        }
        System.out.println();
    }
    */

    for(int i =0 ; i< A.length ; i++) {
        for(int j = 0 ; j<A.length;j++) {
        System.out.print(C[i][j]+ "\t");
        }
        System.out.println();
    }

}
    }
    

