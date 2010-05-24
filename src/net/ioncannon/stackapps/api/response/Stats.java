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

package net.ioncannon.stackapps.api.response;

import javax.xml.bind.annotation.XmlElement;

/**
 */
public class Stats
{
  private long totalQuestions;
  private long totalUnanswered;
  private long totalAnswers;
  private long totalComments;
  private long totalVotes;
  private long totalBadges;
  private long totalUsers;
  private double questionsPerMinute;
  private double answersPerMinute;
  private double badgesPerMinute;
  private ApiVersion apiVersion;

  public Stats()
  {
  }

  public Stats(long totalQuestions, long totalUnanswered, long totalAnswers, long totalComments, long totalVotes, long totalBadges, long totalUsers, long questionsPerMinute, long answersPerMinute, long badgesPerMinute, ApiVersion apiVersion)
  {
    this.totalQuestions = totalQuestions;
    this.totalUnanswered = totalUnanswered;
    this.totalAnswers = totalAnswers;
    this.totalComments = totalComments;
    this.totalVotes = totalVotes;
    this.totalBadges = totalBadges;
    this.totalUsers = totalUsers;
    this.questionsPerMinute = questionsPerMinute;
    this.answersPerMinute = answersPerMinute;
    this.badgesPerMinute = badgesPerMinute;
    this.apiVersion = apiVersion;
  }

  @XmlElement(name="total_questions")
  public long getTotalQuestions()
  {
    return totalQuestions;
  }

  public void setTotalQuestions(long totalQuestions)
  {
    this.totalQuestions = totalQuestions;
  }

  @XmlElement(name="total_unanswered")
  public long getTotalUnanswered()
  {
    return totalUnanswered;
  }

  public void setTotalUnanswered(long totalUnanswered)
  {
    this.totalUnanswered = totalUnanswered;
  }

  @XmlElement(name="total_answers")
  public long getTotalAnswers()
  {
    return totalAnswers;
  }

  public void setTotalAnswers(long totalAnswers)
  {
    this.totalAnswers = totalAnswers;
  }

  @XmlElement(name="total_comments")
  public long getTotalComments()
  {
    return totalComments;
  }

  public void setTotalComments(long totalComments)
  {
    this.totalComments = totalComments;
  }

  @XmlElement(name="total_votes")
  public long getTotalVotes()
  {
    return totalVotes;
  }

  public void setTotalVotes(long totalVotes)
  {
    this.totalVotes = totalVotes;
  }

  @XmlElement(name="total_badges")
  public long getTotalBadges()
  {
    return totalBadges;
  }

  public void setTotalBadges(long totalBadges)
  {
    this.totalBadges = totalBadges;
  }

  @XmlElement(name="total_users")
  public long getTotalUsers()
  {
    return totalUsers;
  }

  public void setTotalUsers(long totalUsers)
  {
    this.totalUsers = totalUsers;
  }

  @XmlElement(name="questions_per_minute")
  public double getQuestionsPerMinute()
  {
    return questionsPerMinute;
  }

  public void setQuestionsPerMinute(double questionsPerMinute)
  {
    this.questionsPerMinute = questionsPerMinute;
  }

  @XmlElement(name="answers_per_minute")
  public double getAnswersPerMinute()
  {
    return answersPerMinute;
  }

  public void setAnswersPerMinute(double answersPerMinute)
  {
    this.answersPerMinute = answersPerMinute;
  }

  @XmlElement(name="badges_per_minute")
  public double getBadgesPerMinute()
  {
    return badgesPerMinute;
  }

  public void setBadgesPerMinute(double badgesPerMinute)
  {
    this.badgesPerMinute = badgesPerMinute;
  }

  @XmlElement(name="api_version")
  public ApiVersion getApiVersion()
  {
    return apiVersion;
  }

  public void setApiVersion(ApiVersion apiVersion)
  {
    this.apiVersion = apiVersion;
  }

  @Override
  public String toString()
  {
    return "Stats{" +
        "totalQuestions=" + totalQuestions +
        ", totalUnanswered=" + totalUnanswered +
        ", totalAnswers=" + totalAnswers +
        ", totalComments=" + totalComments +
        ", totalVotes=" + totalVotes +
        ", totalBadges=" + totalBadges +
        ", totalUsers=" + totalUsers +
        ", questionsPerMinute=" + questionsPerMinute +
        ", answersPerMinute=" + answersPerMinute +
        ", badgesPerMinute=" + badgesPerMinute +
        ", apiVersion=" + apiVersion +
        '}';
  }

  public static class ApiVersion
  {
    private String version;
    private String revision;

    public ApiVersion()
    {
    }

    public ApiVersion(String version, String revision)
    {
      this.version = version;
      this.revision = revision;
    }

    public String getVersion()
    {
      return version;
    }

    public void setVersion(String version)
    {
      this.version = version;
    }

    public String getRevision()
    {
      return revision;
    }

    public void setRevision(String revision)
    {
      this.revision = revision;
    }

    @Override
    public String toString()
    {
      return "ApiVersion{" +
          "version='" + version + '\'' +
          ", revision='" + revision + '\'' +
          '}';
    }
  }
}
