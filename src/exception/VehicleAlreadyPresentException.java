package exception;

public class VehicleAlreadyPresentException extends RideSharingPlatformExceptions{
  public VehicleAlreadyPresentException(String message, String error){
    super(message, error);
  }
}
