package net.ioncannon.stackapps.api.client;

/**
 */
public class StackAppError extends Error
{
  public StackAppError()
  {
  }

  public StackAppError(String message)
  {
    super(message);
  }

  public StackAppError(String message, Throwable cause)
  {
    super(message, cause);
  }

  public StackAppError(Throwable cause)
  {
    super(cause);
  }
}
