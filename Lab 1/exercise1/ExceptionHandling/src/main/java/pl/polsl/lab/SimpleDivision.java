/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl.lab;

/**
 * Main class of the application realizing simple operation of division 
 *
 * @author Gall Anonim
 * @version 1.0
 */
public class SimpleDivision {
     /**
     * Main method of the application.
     *
     * @param args first arg - dividend, second arg - divisor
     */
    public static void main(String args[]) {
        int dividend, divisor;
        float ratio;

        dividend = Integer.parseInt(args[0]);
        divisor = Integer.parseInt(args[1]);
        ratio = dividend/divisor;
        System.out.println(dividend + " : " + divisor + " = " + ratio);
    }
}
