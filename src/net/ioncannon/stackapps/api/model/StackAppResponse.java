package net.ioncannon.stackapps.api.model;

/**
 *
 * Header values:
 *   X-RateLimit-Current
 *   X-RateLimit-Max
 */
public class StackAppResponse
{
  private long currentRateLimit;
  private long maxRateLimit;

  public StackAppResponse()
  {
  }

  public StackAppResponse(long currentRateLimit, long maxRateLimit)
  {
    this.currentRateLimit = currentRateLimit;
    this.maxRateLimit = maxRateLimit;
  }

  public long getCurrentRateLimit()
  {
    return currentRateLimit;
  }

  public void setCurrentRateLimit(long currentRateLimit)
  {
    this.currentRateLimit = currentRateLimit;
  }

  public long getMaxRateLimit()
  {
    return maxRateLimit;
  }

  public void setMaxRateLimit(long maxRateLimit)
  {
    this.maxRateLimit = maxRateLimit;
  }

  @Override
  public String toString()
  {
    return "StackAppResponse{" +
        "currentRateLimit=" + currentRateLimit +
        ", maxRateLimit=" + maxRateLimit +
        '}';
  }
}
