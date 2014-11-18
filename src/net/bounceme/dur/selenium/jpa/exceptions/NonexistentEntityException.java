package net.bounceme.dur.selenium.jpa.exceptions;

import javax.persistence.EntityNotFoundException;

public class NonexistentEntityException extends Exception {

    public NonexistentEntityException(String string) {
    }

   public  NonexistentEntityException(String string, EntityNotFoundException enfe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
