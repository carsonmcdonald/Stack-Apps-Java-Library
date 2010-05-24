package net.ioncannon.stackapps.api.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import java.util.Arrays;

/**
 */

@XmlRootElement
public class UserTimelineList extends StackAppResponse
{
  private UserTimeline userTimelines[];

  public UserTimelineList()
  {
  }

  public UserTimelineList(long currentRateLimit, long maxRateLimit, UserTimeline[] userTimelines)
  {
    super(currentRateLimit, maxRateLimit);
    this.userTimelines = userTimelines;
  }

  @XmlElement(name="user_timelines")
  public UserTimeline[] getTimelines()
  {
    return userTimelines;
  }

  public void setTimelines(UserTimeline[] userTimelines)
  {
    this.userTimelines = userTimelines;
  }

  @Override
  public String toString()
  {
    return "UserTimelineList{" +
        "userTimelines=" + (userTimelines == null ? null : Arrays.asList(userTimelines)) +
        '}';
  }
}
