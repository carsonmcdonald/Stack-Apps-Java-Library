package net.ioncannon.stackapps.api.model;

import javax.xml.bind.annotation.XmlElement;

/**
 */
public class UserTimeline
{
  private long userId;
  private String timelineType;
  private long postId;
  private String postType;
  private long commentId;
  private String action;
  private long creationDate;
  private String description;
  private String detail;

  public UserTimeline()
  {
  }

  public UserTimeline(long userId, String timelineType, long postId, String postType, long commentId, String action, long creationDate, String description, String detail)
  {
    this.userId = userId;
    this.timelineType = timelineType;
    this.postId = postId;
    this.postType = postType;
    this.commentId = commentId;
    this.action = action;
    this.creationDate = creationDate;
    this.description = description;
    this.detail = detail;
  }

  @XmlElement(name="user_id")
  public long getUserId()
  {
    return userId;
  }

  public void setUserId(long userId)
  {
    this.userId = userId;
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

  @XmlElement(name="post_type")
  public String getPostType()
  {
    return postType;
  }

  public void setPostType(String postType)
  {
    this.postType = postType;
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

  public String getAction()
  {
    return action;
  }

  public void setAction(String action)
  {
    this.action = action;
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

  public String getDescription()
  {
    return description;
  }

  public void setDescription(String description)
  {
    this.description = description;
  }

  public String getDetail()
  {
    return detail;
  }

  public void setDetail(String detail)
  {
    this.detail = detail;
  }

  @Override
  public String toString()
  {
    return "UserTimeline{" +
        "userId=" + userId +
        ", timelineType='" + timelineType + '\'' +
        ", postId=" + postId +
        ", postType='" + postType + '\'' +
        ", commentId=" + commentId +
        ", action='" + action + '\'' +
        ", creationDate=" + creationDate +
        ", description='" + description + '\'' +
        ", detail='" + detail + '\'' +
        '}';
  }
}
