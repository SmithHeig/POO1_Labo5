/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labo5_matrix;

/**
 *
 * @author James
 */
public class Matrix {
   private boolean[][] matrix;
   
   Matrix(int n, boolean ... args){
      // Check du bon nombre d'argument
      if(args.length != n*n){
         throw new RuntimeException("Wrong nomber of arguments");
      }
      
      // Initialisation de la matrice
      int i = 0, j = 0;
      matrix = new boolean[n][n];
      // Remplissage de la matrice
      for(boolean b: args){
         matrix[i][j] = b;
         if(++i >= n){
            ++j;
            i = 0;
         }
      }
   }
   
   Matrix(int n){
      // Initialisation de la matrice avec la valeur par défaut 0
      matrix = new boolean[n][n];
      // Remplissage de la matrice
      for(boolean[] line : matrix){
         for(boolean cell : line){
            cell = Math.random() >= 0.5;
         }
      }
   }
   
   public String toString(){
      String print = new String();
      for(boolean[] line : matrix){
         for(boolean cell : line){
            print += cell + " ";
         }
         print += "\n";
      }
      return print;
   }
   
   public Matrix or(Matrix b){
      if(matrix.length != b.matrix.length){
         throw new RuntimeException("Compare two matrix with not the same size!");
      }
      
      boolean[] matrixOr = new boolean[matrix.length * matrix.length];
      
      for(int i = 0; i < matrix.length; ++i){
         for(int j = 0; j < matrix.length; ++j){
            matrixOr[i + matrix.length * j] = matrix[i][j] | b.matrix[i][j];
         }
      }
      return new Matrix(matrix.length, matrixOr);
   }
   
   public Matrix and(Matrix b){
      if(matrix.length != b.matrix.length){
         throw new RuntimeException("Compare two matrix with not the same size!");
      }
      
      boolean[] matrixAnd = new boolean[matrix.length * matrix.length];
      
      for(int i = 0; i < matrix.length; ++i){
         for(int j = 0; j < matrix.length; ++j){
            matrixAnd[i + matrix.length * j] = matrix[i][j] & b.matrix[i][j];
         }
      }
      return new Matrix(matrix.length, matrixAnd);
   }
   
   public Matrix xor(Matrix b){
      if(matrix.length != b.matrix.length){
         throw new RuntimeException("Compare two matrix with not the same size!");
      }
      
      boolean[] matrixXOr = new boolean[matrix.length * matrix.length];
      
      for(int i = 0; i < matrix.length; ++i){
         for(int j = 0; j < matrix.length; ++j){
            matrixXOr[i + matrix.length * j] = matrix[i][j] ^ b.matrix[i][j];
         }
      }
      return new Matrix(matrix.length, matrixXOr);
   }
}
