package net.ioncannon.stackapps.api.model;

import javax.xml.bind.annotation.XmlElement;

/**
 */
public class RepChange
{
  private long userId;
  private long postId;
  private String postType;
  private String title;
  private long positiveRep;
  private long negativeRep;
  private long onDate;

  public RepChange()
  {
  }

  public RepChange(long userId, long postId, String postType, String title, long positiveRep, long negativeRep, long onDate)
  {
    this.userId = userId;
    this.postId = postId;
    this.postType = postType;
    this.title = title;
    this.positiveRep = positiveRep;
    this.negativeRep = negativeRep;
    this.onDate = onDate;
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

  public String getTitle()
  {
    return title;
  }

  public void setTitle(String title)
  {
    this.title = title;
  }

  @XmlElement(name="postivie_rep")
  public long getPositiveRep()
  {
    return positiveRep;
  }

  public void setPositiveRep(long positiveRep)
  {
    this.positiveRep = positiveRep;
  }

  @XmlElement(name="negative_rep")
  public long getNegativeRep()
  {
    return negativeRep;
  }

  public void setNegativeRep(long negativeRep)
  {
    this.negativeRep = negativeRep;
  }

  @XmlElement(name="on_date")
  public long getOnDate()
  {
    return onDate;
  }

  public void setOnDate(long onDate)
  {
    this.onDate = onDate;
  }

  @Override
  public String toString()
  {
    return "RepChange{" +
        "userId=" + userId +
        ", postId=" + postId +
        ", postType='" + postType + '\'' +
        ", title='" + title + '\'' +
        ", positiveRep=" + positiveRep +
        ", negativeRep=" + negativeRep +
        ", onDate=" + onDate +
        '}';
  }
}
