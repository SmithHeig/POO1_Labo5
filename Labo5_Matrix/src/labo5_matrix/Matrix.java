/*
 * @brief class rerpésentant des matrices
 * @date 25.10.2017
 * @authors Adrien Alleman et James Smith
 */

package labo5_matrix;

/**
 * @brief Class representant des matrices contenant des booleens.
 */
public class Matrix {
   private boolean[][] matrix;
   /**
    * @brief Constructeur de la matrice
    * @param n = taille de la matrice (n x n)
    * @param args = argument devant être des booléens pour remplir la matrice.
    * 
    * @remark dans le cas ou le paramètre args est vide, la matrice sera remplie aléatoirement
    */
   Matrix(int n, boolean ... args){
    System.out.println("First Constructor used!");
      // Check du bon nombre d'arguments
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
      System.out.println("Second Constructor used!");
      // Initialisation de la matrice avec la valeur par défaut 0
      matrix = new boolean[n][n];
      // Remplissage de la matrice
      for(int i = 0; i < n; ++i){
         for(int j = 0; j < n; ++j){
            matrix[i][j] = (boolean)(Math.random() >= 0.5);
         }
      }
      //System.out.println("TEST");
      //System.out.println(this.toString());
   }
   
   /**
    * @brief retourne la matrice sous forme de String
    * @return matrice sous forme de string
    * @remark les booleens sont noté en format numérique
    */
   public String toString(){
      String print = new String();
      for(boolean[] line : matrix){
         for(boolean cell : line){
            print += (cell ? "1" : "0") + " ";
            //System.out.println(cell);
         }
         print += "\n";
      }
      return print;
   }
   
   /**
    * @brief Permet d'appliquer des opérateurs sur les matrices
    * @param b seconde matrice avec les quelles réalisé les opérations
    * @param o opérateur de l'opération à effectuer
    * @return la matrice résultante à l'opération
    */
   public Matrix applyOperator(Matrix b, Operator o){
      if(matrix.length != b.matrix.length){
         throw new RuntimeException("Attempt to work with two matrix of different size!");
      }
      
      boolean[] matrixOr = new boolean[matrix.length * matrix.length];
      
      for(int i = 0; i < matrix.length; ++i){
         for(int j = 0; j < matrix.length; ++j){
            matrixOr[i + matrix.length * j] = o.apply(matrix[i][j], b.matrix[i][j]);
         }
      }
      return new Matrix(matrix.length, matrixOr);
   }
   
   /**
    * @brief Affichage de la matrice
    */
   public void print(){
       System.out.println(this);
   }
   
   /* --{ VERSION NON FACTORISEE }--
   
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
   */
}
