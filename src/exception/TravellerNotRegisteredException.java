package exception;

public class TravellerNotRegisteredException extends RideSharingPlatformExceptions{
  public TravellerNotRegisteredException(String message, String error){
    super(message, error);
  }
}
