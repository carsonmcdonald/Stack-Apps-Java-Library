package net.ioncannon.stackapps.api.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;

/**
 */

@XmlRootElement
public class PostTimelines
{
  private PostTimeline postTimelines[];

  public PostTimelines()
  {
  }

  public PostTimelines(PostTimeline[] postTimelines)
  {
    this.postTimelines = postTimelines;
  }

  @XmlElement(name="post_timelines")
  public PostTimeline[] getPostTimelines()
  {
    return postTimelines;
  }

  public void setPostTimelines(PostTimeline[] postTimelines)
  {
    this.postTimelines = postTimelines;
  }

  @Override
  public String toString()
  {
    return "PostTimelines{" +
        "postTimelines=" + (postTimelines == null ? null : Arrays.asList(postTimelines)) +
        '}';
  }

  public static class PostTimeline
  {
    private String timelineType;
    private long postId;
    private long commentId;
    private String revisionGuid;
    private long creationDate;
    private User user;
    private User owner;
    private String action;
    private String postRevisionUrl;
    private String postUrl;
    private String postCommentUrl;

    public PostTimeline()
    {
    }

    public PostTimeline(String timelineType, long postId, long commentId, String revisionGuid, long creationDate, User user, User owner, String action, String postRevisionUrl, String postUrl, String postCommentUrl)
    {
      this.timelineType = timelineType;
      this.postId = postId;
      this.commentId = commentId;
      this.revisionGuid = revisionGuid;
      this.creationDate = creationDate;
      this.user = user;
      this.owner = owner;
      this.action = action;
      this.postRevisionUrl = postRevisionUrl;
      this.postUrl = postUrl;
      this.postCommentUrl = postCommentUrl;
    }

    @XmlElement(name="timeline_type")
    public String getTimelineType()
    {
      return timelineType;
    }

    public void setTimelineType(String timelineType)
    {
      this.timelineType = timelineType;
    }

    @XmlElement(name="post_id")
    public long getPostId()
    {
      return postId;
    }

    public void setPostId(long postId)
    {
      this.postId = postId;
    }

    @XmlElement(name="comment_id")
    public long getCommentId()
    {
      return commentId;
    }

    public void setCommentId(long commentId)
    {
      this.commentId = commentId;
    }

    @XmlElement(name="revision_guid")
    public String getRevisionGuid()
    {
      return revisionGuid;
    }

    public void setRevisionGuid(String revisionGuid)
    {
      this.revisionGuid = revisionGuid;
    }

    @XmlElement(name="creation_date")
    public long getCreationDate()
    {
      return creationDate;
    }

    public void setCreationDate(long creationDate)
    {
      this.creationDate = creationDate;
    }

    public User getUser()
    {
      return user;
    }

    public void setUser(User user)
    {
      this.user = user;
    }

    public User getOwner()
    {
      return owner;
    }

    public void setOwner(User owner)
    {
      this.owner = owner;
    }

    public String getAction()
    {
      return action;
    }

    public void setAction(String action)
    {
      this.action = action;
    }

    @XmlElement(name="post_revision_url")
    public String getPostRevisionUrl()
    {
      return postRevisionUrl;
    }

    public void setPostRevisionUrl(String postRevisionUrl)
    {
      this.postRevisionUrl = postRevisionUrl;
    }

    @XmlElement(name="post_url")
    public String getPostUrl()
    {
      return postUrl;
    }

    public void setPostUrl(String postUrl)
    {
      this.postUrl = postUrl;
    }

    @XmlElement(name="post_comment_url")
    public String getPostCommentUrl()
    {
      return postCommentUrl;
    }

    public void setPostCommentUrl(String postCommentUrl)
    {
      this.postCommentUrl = postCommentUrl;
    }

    @Override
    public String toString()
    {
      return "PostTimeline{" +
          "timelineType='" + timelineType + '\'' +
          ", postId=" + postId +
          ", commentId=" + commentId +
          ", revisionGuid='" + revisionGuid + '\'' +
          ", creationDate=" + creationDate +
          ", user=" + user +
          ", owner=" + owner +
          ", action='" + action + '\'' +
          ", postRevisionUrl='" + postRevisionUrl + '\'' +
          ", postUrl='" + postUrl + '\'' +
          ", postCommentUrl='" + postCommentUrl + '\'' +
          '}';
    }
  }
}
