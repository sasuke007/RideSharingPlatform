package exception;

public class RideSharingPlatformExceptions extends RuntimeException{
  private String error;
  private String message;

  public RideSharingPlatformExceptions(String message, String error){
    super(message);
    this.error = error;
    printException();
  }

  public void printException(){
    System.out.println("Exception ->  " + error);
    this.printStackTrace();
  }
}
