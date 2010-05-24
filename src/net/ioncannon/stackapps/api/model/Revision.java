package net.ioncannon.stackapps.api.model;

import javax.xml.bind.annotation.XmlElement;
import java.util.Arrays;

/**
 */
public class Revision
{
  private String body;
  private String comment;
  private long creationDate;
  private boolean question;
  private boolean rollback;
  private String lastBody;
  private String lastTitle;
  private String lastTags[];
  private String revisionGuid;
  private long revisionNumber;
  private String tags[];
  private String title;
  private String revisionType;
  private boolean setCommunityWiki;
  private User user;
  private long postId;

  public Revision()
  {
  }

  public Revision(String body, String comment, long creationDate, boolean question, boolean rollback, String lastBody, String lastTitle, String[] lastTags, String revisionGuid, long revisionNumber, String[] tags, String title, String revisionType, boolean setCommunityWiki, User user, long postId)
  {
    this.body = body;
    this.comment = comment;
    this.creationDate = creationDate;
    this.question = question;
    this.rollback = rollback;
    this.lastBody = lastBody;
    this.lastTitle = lastTitle;
    this.lastTags = lastTags;
    this.revisionGuid = revisionGuid;
    this.revisionNumber = revisionNumber;
    this.tags = tags;
    this.title = title;
    this.revisionType = revisionType;
    this.setCommunityWiki = setCommunityWiki;
    this.user = user;
    this.postId = postId;
  }

  public String getBody()
  {
    return body;
  }

  public void setBody(String body)
  {
    this.body = body;
  }

  public String getComment()
  {
    return comment;
  }

  public void setComment(String comment)
  {
    this.comment = comment;
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

  @XmlElement(name="is_question")
  public boolean isQuestion()
  {
    return question;
  }

  public void setQuestion(boolean question)
  {
    this.question = question;
  }

  @XmlElement(name="is_rollback")
  public boolean isRollback()
  {
    return rollback;
  }

  public void setRollback(boolean rollback)
  {
    this.rollback = rollback;
  }

  @XmlElement(name="last_body")
  public String getLastBody()
  {
    return lastBody;
  }

  public void setLastBody(String lastBody)
  {
    this.lastBody = lastBody;
  }

  @XmlElement(name="last_title")
  public String getLastTitle()
  {
    return lastTitle;
  }

  public void setLastTitle(String lastTitle)
  {
    this.lastTitle = lastTitle;
  }

  @XmlElement(name="last_tags")
  public String[] getLastTags()
  {
    return lastTags;
  }

  public void setLastTags(String[] lastTags)
  {
    this.lastTags = lastTags;
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

  @XmlElement(name="revision_number")
  public long getRevisionNumber()
  {
    return revisionNumber;
  }

  public void setRevisionNumber(long revisionNumber)
  {
    this.revisionNumber = revisionNumber;
  }

  public String[] getTags()
  {
    return tags;
  }

  public void setTags(String[] tags)
  {
    this.tags = tags;
  }

  public String getTitle()
  {
    return title;
  }

  public void setTitle(String title)
  {
    this.title = title;
  }

  @XmlElement(name="revision_type")
  public String getRevisionType()
  {
    return revisionType;
  }

  public void setRevisionType(String revisionType)
  {
    this.revisionType = revisionType;
  }

  @XmlElement(name="set_community_wiki")
  public boolean isSetCommunityWiki()
  {
    return setCommunityWiki;
  }

  public void setSetCommunityWiki(boolean setCommunityWiki)
  {
    this.setCommunityWiki = setCommunityWiki;
  }

  public User getUser()
  {
    return user;
  }

  public void setUser(User user)
  {
    this.user = user;
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

  @Override
  public String toString()
  {
    return "Revision{" +
        "body='" + body + '\'' +
        ", comment='" + comment + '\'' +
        ", creationDate=" + creationDate +
        ", question=" + question +
        ", rollback=" + rollback +
        ", lastBody='" + lastBody + '\'' +
        ", lastTitle='" + lastTitle + '\'' +
        ", lastTags=" + (lastTags == null ? null : Arrays.asList(lastTags)) +
        ", revisionGuid='" + revisionGuid + '\'' +
        ", revisionNumber=" + revisionNumber +
        ", tags=" + (tags == null ? null : Arrays.asList(tags)) +
        ", title='" + title + '\'' +
        ", revisionType='" + revisionType + '\'' +
        ", setCommunityWiki=" + setCommunityWiki +
        ", user=" + user +
        ", postId=" + postId +
        '}';
  }
}
