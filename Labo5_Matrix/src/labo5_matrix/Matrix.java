/*
 * @brief class rerpésentant des matrices
 * @date 25.10.2017
 * @authors Adrien Alleman et James Smith
 * @file Matrix.java
 */

package labo5_matrix;

/**
 * @brief Class representant des matrices contenant des booleens.
 */
public class Matrix {
   private boolean[][] matrix;
   /**
    * @brief Constructeur de la matrice avec données
    * @param n = taille de la matrice (n x n)
    * @param args = argument devant être des booléens pour remplir la matrice.
    */
   Matrix(boolean ... args){
      System.out.print("Premier constructeur utilisé avec " + args.length + " arguments.\n");
      int n = (int)Math.sqrt(args.length);
      // Check du bon nombre d'arguments (on veut une matrice carée)
      if((double)n != Math.sqrt(args.length)){
         throw new RuntimeException("You shall not pass... The wrong nomber of arguments!");
      }
      
      // Initialisation de la matrice
      int i = 0, j = 0;
      matrix = new boolean[n][n];
      // Remplissage de la matrice
      for(boolean b: args){
        matrix[i][j] = b;
        if(++j >= n){
          ++i;
          j = 0;
        }
      }
   }
   
   /**
    * @brief Constructeur de la matrice sans données
    * @param n taille de la matrice (n x n)
    * @remark les valeurs de la matrice sont généré aléatoirement
    */
   Matrix(int n){
      System.out.print("deuxième constructeur utilisé pour une matrice " + n + "x" + n + "\n");
      // Initialisation de la matrice avec la valeur par défaut 0
      matrix = new boolean[n][n];
      // Remplissage de la matrice
      for(int i = 0; i < n; ++i){
         for(int j = 0; j < n; ++j){
            matrix[i][j] = (boolean)(Math.random() >= 0.5);
         }
      }
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
         }
         print += "\n";
      }
      return print;
   }
   
   /**
    * @brief Permet d'appliquer des opérateurs sur les matrices
    * @param matrixB seconde matrice avec les quelles réalisé les opérations
    * @param operator opérateur de l'opération à effectuer
    * @return la matrice résultante à l'opération
    */
   public Matrix applyOperator(Matrix matrixB, Operator operator){
      if(matrix.length != matrixB.matrix.length){
         throw new RuntimeException("You shall not pass... two matrix of different size!");
      }
      
      // tableau à une dimension car constructeur ne permet pas un tableau à 2D
      boolean[] tabBoolean = new boolean[matrix.length * matrix.length];
      
      for(int i = 0; i < matrix.length; ++i){
         for(int j = 0; j < matrix.length; ++j){
            tabBoolean[i + matrix.length * j] = operator.apply(matrix[i][j], matrixB.matrix[i][j]);
         }
      }
      
      return new Matrix(tabBoolean);
   }
   
   /**
    * @brief Affichage de la matrice
    */
   public void print(){
       System.out.println(this);
   }
}
