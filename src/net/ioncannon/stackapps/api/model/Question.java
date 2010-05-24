/*
 * Copyright (c) 2010 Carson McDonald
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package net.ioncannon.stackapps.api.model;

import javax.xml.bind.annotation.XmlElement;
import java.util.Arrays;

/**
 */
public class Question
{
  private String tags[];
  private long answerCount;
  private Answer answers[];
  private long acceptedAnswerId;
  private long favoriteCount;
  private long bountyClosesDate;
  private long bountyAmount;
  private long closedDate;
  private String closedReason;
  private String questionTimelineUrl;
  private String questionCommentsUrl;
  private String questionAnswersUrl;
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
  private boolean communityOwned;
  private String title;
  private String body;
  private Comment comments[];

  public Question()
  {
  }

  public Question(String tags[], long answerCount, Answer[] answers, long acceptedAnswerId, long favoriteCount, long bountyClosesDate, long bountyAmount, long closedDate, String closedReason, String questionTimelineUrl, String questionCommentsUrl, String questionAnswersUrl, long questionId, long lockedDate, User owner, long creationDate, long lastEditDate, long lastActivityDate, long upVoteCount, long downVoteCount, long viewCount, long score, boolean communityOwned, String title, String body, Comment[] comments)
  {
    this.tags = tags;
    this.answerCount = answerCount;
    this.answers = answers;
    this.acceptedAnswerId = acceptedAnswerId;
    this.favoriteCount = favoriteCount;
    this.bountyClosesDate = bountyClosesDate;
    this.bountyAmount = bountyAmount;
    this.closedDate = closedDate;
    this.closedReason = closedReason;
    this.questionTimelineUrl = questionTimelineUrl;
    this.questionCommentsUrl = questionCommentsUrl;
    this.questionAnswersUrl = questionAnswersUrl;
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
    this.communityOwned = communityOwned;
    this.title = title;
    this.body = body;
    this.comments = comments;
  }

  public String[] getTags()
  {
    return tags;
  }

  public void setTags(String tags[])
  {
    this.tags = tags;
  }

  @XmlElement(name="answer_count")
  public long getAnswerCount()
  {
    return answerCount;
  }

  public void setAnswerCount(long answerCount)
  {
    this.answerCount = answerCount;
  }

  public Answer[] getAnswers()
  {
    return answers;
  }

  public void setAnswers(Answer[] answers)
  {
    this.answers = answers;
  }

  @XmlElement(name="accepted_answer_id")
  public long getAcceptedAnswerId()
  {
    return acceptedAnswerId;
  }

  public void setAcceptedAnswerId(long acceptedAnswerId)
  {
    this.acceptedAnswerId = acceptedAnswerId;
  }

  @XmlElement(name="favorite_count")
  public long getFavoriteCount()
  {
    return favoriteCount;
  }

  public void setFavoriteCount(long favoriteCount)
  {
    this.favoriteCount = favoriteCount;
  }

  @XmlElement(name="bounty_close_date")
  public long getBountyClosesDate()
  {
    return bountyClosesDate;
  }

  public void setBountyClosesDate(long bountyClosesDate)
  {
    this.bountyClosesDate = bountyClosesDate;
  }

  @XmlElement(name="bounty_amount")
  public long getBountyAmount()
  {
    return bountyAmount;
  }

  public void setBountyAmount(long bountyAmount)
  {
    this.bountyAmount = bountyAmount;
  }

  @XmlElement(name="closed_date")
  public long getClosedDate()
  {
    return closedDate;
  }

  public void setClosedDate(long closedDate)
  {
    this.closedDate = closedDate;
  }

  @XmlElement(name="closed_reason")
  public String getClosedReason()
  {
    return closedReason;
  }

  public void setClosedReason(String closedReason)
  {
    this.closedReason = closedReason;
  }

  @XmlElement(name="question_timeline_url")
  public String getQuestionTimelineUrl()
  {
    return questionTimelineUrl;
  }

  public void setQuestionTimelineUrl(String questionTimelineUrl)
  {
    this.questionTimelineUrl = questionTimelineUrl;
  }

  @XmlElement(name="question_comments_url")
  public String getQuestionCommentsUrl()
  {
    return questionCommentsUrl;
  }

  public void setQuestionCommentsUrl(String questionCommentsUrl)
  {
    this.questionCommentsUrl = questionCommentsUrl;
  }

  @XmlElement(name="question_answers_url")
  public String getQuestionAnswersUrl()
  {
    return questionAnswersUrl;
  }

  public void setQuestionAnswersUrl(String questionAnswersUrl)
  {
    this.questionAnswersUrl = questionAnswersUrl;
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

  @XmlElement(name="community_owned")
  public boolean isCommunityOwned()
  {
    return communityOwned;
  }

  public void setCommunityOwned(boolean communityOwned)
  {
    this.communityOwned = communityOwned;
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
    return "Question{" +
        "tags=" + (tags == null ? null : Arrays.asList(tags)) +
        ", answerCount=" + answerCount +
        ", answers=" + (answers == null ? null : Arrays.asList(answers)) +
        ", acceptedAnswerId=" + acceptedAnswerId +
        ", favoriteCount=" + favoriteCount +
        ", bountyClosesDate=" + bountyClosesDate +
        ", bountyAmount=" + bountyAmount +
        ", closedDate=" + closedDate +
        ", closedReason='" + closedReason + '\'' +
        ", questionTimelineUrl='" + questionTimelineUrl + '\'' +
        ", questionCommentsUrl='" + questionCommentsUrl + '\'' +
        ", questionAnswersUrl='" + questionAnswersUrl + '\'' +
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
        ", communityOwned=" + communityOwned +
        ", title='" + title + '\'' +
        ", body='" + body + '\'' +
        ", comments=" + (comments == null ? null : Arrays.asList(comments)) +
        '}';
  }
}
