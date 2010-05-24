package net.ioncannon.stackapps.api.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;

/**
 */

@XmlRootElement
public class PostTimelineList extends StackAppResponse
{
  private PostTimeline timelines[];

  public PostTimelineList()
  {
  }

  public PostTimelineList(long currentRateLimit, long maxRateLimit, PostTimeline[] timelines)
  {
    super(currentRateLimit, maxRateLimit);
    this.timelines = timelines;
  }

  @XmlElement(name="post_timelines")
  public PostTimeline[] getTimelines()
  {
    return timelines;
  }

  public void setTimelines(PostTimeline[] timelines)
  {
    this.timelines = timelines;
  }

  @Override
  public String toString()
  {
    return "QuestionTimelineList{" +
        "timelines=" + (timelines == null ? null : Arrays.asList(timelines)) +
        '}';
  }
}