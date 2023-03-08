package fr.eni.bll;


public class BLLException extends Exception {
    
<<<<<<< HEAD
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
=======
    private static final long serialVersionUID = 1L;
>>>>>>> refs/heads/master

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
