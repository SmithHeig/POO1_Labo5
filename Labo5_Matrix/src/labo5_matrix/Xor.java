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
public class Xor extends Operator{
    
    public boolean apply(boolean left, boolean right){
        return left ^ right;
    }
}