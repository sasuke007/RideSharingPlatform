package exception;

public class UserAlreadyPresentException extends RideSharingPlatformExceptions{
  public UserAlreadyPresentException(String message, String error){
    super(message, error);
  }
}
