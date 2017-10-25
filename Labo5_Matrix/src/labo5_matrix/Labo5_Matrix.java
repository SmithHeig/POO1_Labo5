/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package labo5_matrix;
/**
 * @author James
 */
public class Labo5_Matrix {
   /**
    * @param args the command line arguments
    */
   public static void main(String[] args) {
       
        System.out.println("Premiere matrice A :");
        int n = 4;
        Matrix first = new Matrix(n);
        first.print();

        //une seconde matrice pour tester les opérateurs;
        System.out.println("Deuxieme matrice B :");
        Matrix second = new Matrix(n);
        second.print();

        // test de l'opérateur or
        System.out.println("Matrice A or B :");
        Or or = new Or();
        Matrix resultOr = first.applyOperator(second, or);
        resultOr.print();

        // test de l'opérateur and
        System.out.println("Matrice A and B :");
        And and = new And();
        Matrix resultAnd = first.applyOperator(second, and);
        resultAnd.print();

        System.out.println("Matrice A xor B :");
        Xor xor = new Xor();
        Matrix resultXor = first.applyOperator(second, xor);
        resultXor.print();
        
   }
}
