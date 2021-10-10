package za.ac.nwu.accountsystem.domain.exception;

public class PersistenceReadException extends RuntimeException{
    public PersistenceReadException(String msg){
        super(msg);
    }
}