package exception;

public class illegalArgumentException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    private String errorCode;

    private boolean propertiesKey = true;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public boolean isPropertiesKey() {
        return propertiesKey;
    }

    public void setPropertiesKey(boolean propertiesKey) {
        this.propertiesKey = propertiesKey;
    }

    public illegalArgumentException() {
        super();
    }

    public illegalArgumentException(String message) {
        super(message);
    }

    public  illegalArgumentException(String errorCode, String message) {
        this(errorCode, message, true);
    }

    public illegalArgumentException(String errorCode, String message, boolean propertiesKey) {
        super(message);
        this.setErrorCode(errorCode);
        this.setPropertiesKey(propertiesKey);
    }

    public illegalArgumentException(String errorCode, String message, Throwable cause, boolean propertiesKey) {
        super(message, cause);
        this.setErrorCode(errorCode);
        this.setPropertiesKey(propertiesKey);
    }



}
