/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labo5_matrix;

/**
 *
 * @author dname
 */
public class Or extends Operator{
    
    @Override
    public boolean apply(boolean left, boolean right){
        return left | right;
    }
}
