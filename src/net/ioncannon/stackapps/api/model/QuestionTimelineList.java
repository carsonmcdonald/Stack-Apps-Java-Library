package net.ioncannon.stackapps.api.model;

import java.util.Arrays;

/**
 */
public class QuestionTimelineList extends StackAppResponse
{
  private PostTimeline timelines[];

  public QuestionTimelineList()
  {
  }

  public QuestionTimelineList(long currentRateLimit, long maxRateLimit, PostTimeline[] timelines)
  {
    super(currentRateLimit, maxRateLimit);
    this.timelines = timelines;
  }

  // post_timelines
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
