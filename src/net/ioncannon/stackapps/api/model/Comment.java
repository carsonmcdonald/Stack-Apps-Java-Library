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

/**
 */
public class Comment
{
  private long commentId;
  private long creationDate;
  private User owner;
  private User replyToUser;
  private long postId;
  private String postType;
  private long score;
  private long editCount;
  private String body;

  public Comment()
  {
  }

  public Comment(long commentId, long creationDate, User owner, User replyToUser, long postId, String postType, long score, long editCount, String body)
  {
    this.commentId = commentId;
    this.creationDate = creationDate;
    this.owner = owner;
    this.replyToUser = replyToUser;
    this.postId = postId;
    this.postType = postType;
    this.score = score;
    this.editCount = editCount;
    this.body = body;
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

  @XmlElement(name="creation_date")
  public long getCreationDate()
  {
    return creationDate;
  }

  public void setCreationDate(long creationDate)
  {
    this.creationDate = creationDate;
  }

  public User getOwner()
  {
    return owner;
  }

  public void setOwner(User owner)
  {
    this.owner = owner;
  }

  @XmlElement(name="reply_to_user")
  public User getReplyToUser()
  {
    return replyToUser;
  }

  public void setReplyToUser(User replyToUser)
  {
    this.replyToUser = replyToUser;
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

  public long getScore()
  {
    return score;
  }

  public void setScore(long score)
  {
    this.score = score;
  }

  @XmlElement(name="edit_count")
  public long getEditCount()
  {
    return editCount;
  }

  public void setEditCount(long editCount)
  {
    this.editCount = editCount;
  }

  public String getBody()
  {
    return body;
  }

  public void setBody(String body)
  {
    this.body = body;
  }

  @Override
  public String toString()
  {
    return "Comment{" +
        "commentId=" + commentId +
        ", creationDate=" + creationDate +
        ", owner=" + owner +
        ", replyToUser=" + replyToUser +
        ", postId=" + postId +
        ", postType='" + postType + '\'' +
        ", score=" + score +
        ", editCount=" + editCount +
        ", body='" + body + '\'' +
        '}';
  }
}
