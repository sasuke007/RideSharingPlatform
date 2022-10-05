package exception;

public class RideAlreadyPresentException extends RideSharingPlatformExceptions{
  public RideAlreadyPresentException(String message, String error){
    super(message, error);
  }
}
