/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl.lab.interfaces;

/**
 * Interface allows objects to be sorted
 *
 * @author Gall Anonim
 * @version 1.1
 */
public interface Sortable {

    /**
     * Compares sortable objects
     *
     * @param item compared with the current object
     * @return true when current object is certified as smaller
     */
    boolean less(Sortable item);


    default Sortable min(Sortable[] elements) {
        if (isEmpty(elements)) {
            return null;
        } else {
            return elements[0];
        }
    }
    /**
     * Method supporting verification of elements
     * 
     * @param elements list of elements to verify
     * @return true in case of null or single element
     */
    private boolean isEmpty(Sortable[] elements) {
        return (elements == null) || (elements.length == 0);
    }
}
