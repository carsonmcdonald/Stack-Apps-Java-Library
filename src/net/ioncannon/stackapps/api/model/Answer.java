package net.ioncannon.stackapps.api.model;

import javax.xml.bind.annotation.XmlElement;
import java.util.Arrays;

/**
 */
public class Answer
{
  private long answerId;
  private boolean accepted;
  private String answerCommentsUrl;
  private long questionId;
  private long lockedDate;
  private User owner;
  private long creationDate;
  private long lastEditDate;
  private long lastActivityDate;
  private long upVoteCount;
  private long downVoteCount;
  private long viewCount;
  private long score;
  private boolean communityOwner;
  private String title;
  private String body;
  private Comment comments[];

  public Answer()
  {
  }

  public Answer(long answerId, boolean accepted, String answerCommentsUrl, long questionId, long lockedDate, User owner, long creationDate, long lastEditDate, long lastActivityDate, long upVoteCount, long downVoteCount, long viewCount, long score, boolean communityOwner, String title, String body, Comment[] comments)
  {
    this.answerId = answerId;
    this.accepted = accepted;
    this.answerCommentsUrl = answerCommentsUrl;
    this.questionId = questionId;
    this.lockedDate = lockedDate;
    this.owner = owner;
    this.creationDate = creationDate;
    this.lastEditDate = lastEditDate;
    this.lastActivityDate = lastActivityDate;
    this.upVoteCount = upVoteCount;
    this.downVoteCount = downVoteCount;
    this.viewCount = viewCount;
    this.score = score;
    this.communityOwner = communityOwner;
    this.title = title;
    this.body = body;
    this.comments = comments;
  }

  @XmlElement(name="answer_id")
  public long getAnswerId()
  {
    return answerId;
  }

  public void setAnswerId(long answerId)
  {
    this.answerId = answerId;
  }

  public boolean isAccepted()
  {
    return accepted;
  }

  public void setAccepted(boolean accepted)
  {
    this.accepted = accepted;
  }

  public String getAnswerCommentsUrl()
  {
    return answerCommentsUrl;
  }

  public void setAnswerCommentsUrl(String answerCommentsUrl)
  {
    this.answerCommentsUrl = answerCommentsUrl;
  }

  @XmlElement(name="question_id")
  public long getQuestionId()
  {
    return questionId;
  }

  public void setQuestionId(long questionId)
  {
    this.questionId = questionId;
  }

  @XmlElement(name="locked_date")
  public long getLockedDate()
  {
    return lockedDate;
  }

  public void setLockedDate(long lockedDate)
  {
    this.lockedDate = lockedDate;
  }

  public User getOwner()
  {
    return owner;
  }

  public void setOwner(User owner)
  {
    this.owner = owner;
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

  @XmlElement(name="last_edit_date")
  public long getLastEditDate()
  {
    return lastEditDate;
  }

  public void setLastEditDate(long lastEditDate)
  {
    this.lastEditDate = lastEditDate;
  }

  @XmlElement(name="last_activity_date")
  public long getLastActivityDate()
  {
    return lastActivityDate;
  }

  public void setLastActivityDate(long lastActivityDate)
  {
    this.lastActivityDate = lastActivityDate;
  }

  @XmlElement(name="up_vote_count")
  public long getUpVoteCount()
  {
    return upVoteCount;
  }

  public void setUpVoteCount(long upVoteCount)
  {
    this.upVoteCount = upVoteCount;
  }

  @XmlElement(name="down_vote_count")
  public long getDownVoteCount()
  {
    return downVoteCount;
  }

  public void setDownVoteCount(long downVoteCount)
  {
    this.downVoteCount = downVoteCount;
  }

  @XmlElement(name="view_count")
  public long getViewCount()
  {
    return viewCount;
  }

  public void setViewCount(long viewCount)
  {
    this.viewCount = viewCount;
  }

  public long getScore()
  {
    return score;
  }

  public void setScore(long score)
  {
    this.score = score;
  }

  @XmlElement(name="community_owner")
  public boolean isCommunityOwner()
  {
    return communityOwner;
  }

  public void setCommunityOwner(boolean communityOwner)
  {
    this.communityOwner = communityOwner;
  }

  public String getTitle()
  {
    return title;
  }

  public void setTitle(String title)
  {
    this.title = title;
  }

  public String getBody()
  {
    return body;
  }

  public void setBody(String body)
  {
    this.body = body;
  }

  public Comment[] getComments()
  {
    return comments;
  }

  public void setComments(Comment[] comments)
  {
    this.comments = comments;
  }

  @Override
  public String toString()
  {
    return "Answer{" +
        "answerId=" + answerId +
        ", accepted=" + accepted +
        ", answerCommentsUrl='" + answerCommentsUrl + '\'' +
        ", questionId=" + questionId +
        ", lockedDate=" + lockedDate +
        ", owner=" + owner +
        ", creationDate=" + creationDate +
        ", lastEditDate=" + lastEditDate +
        ", lastActivityDate=" + lastActivityDate +
        ", upVoteCount=" + upVoteCount +
        ", downVoteCount=" + downVoteCount +
        ", viewCount=" + viewCount +
        ", score=" + score +
        ", communityOwner=" + communityOwner +
        ", title='" + title + '\'' +
        ", body='" + body + '\'' +
        ", comments=" + (comments == null ? null : Arrays.asList(comments)) +
        '}';
  }
}
