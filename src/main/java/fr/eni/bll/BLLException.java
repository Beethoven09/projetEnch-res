package fr.eni.bll;


public class BLLException extends Exception {
    
    public BLLException(String message) {
        super(message);
    }

    public BLLException(String message, Throwable cause) {
        super(message, cause);
    }
    
    @Override
    public String toString() {
        if (getCause() != null) {
            return super.toString() + " - Cause : " + getCause();
        }
        return super.toString();
    }
}
