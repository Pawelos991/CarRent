/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.exceptions;

/**Class that describes the Mileage Exception
 *
 * @author Pawel
 * @version 1.4
 */
public class MileageException extends Exception {

    /**
     * Exception class constructor
     *
     * @param message display message
     */
    public MileageException(String message) {
        super(message);
    }
}
