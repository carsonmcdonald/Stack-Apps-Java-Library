package net.ioncannon.stackapps.api.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

/**
 */
@XmlRootElement
public class User
{
  private long userId;
  private String userType;
  private long creationDate;
  private String displayName;
  private long reputation;
  private String emailHash;
  private long age;
  private long lastAccessDate;
  private String websiteUrl;
  private String location;
  private String aboutMe;
  private long questionCount;
  private long answerCount;
  private long viewCount;
  private long upVoteCount;
  private long downVoteCount;
  private long acceptRate;
  private String userQuestionsUrl;
  private String userAnswersUrl;
  private String userFavoritesUrl;
  private String userTagsUrl;
  private String userBadgesUrl;
  private String userTimelineUrl;
  private String userMentionedUrl;
  private String userCommentsUrl;
  private String userReputationUrl;
  private BadgeCount badgeCount;
  private long timedPenaltyDate;

  public User()
  {
  }

  public User(long userId, String userType, long creationDate, String displayName, long reputation, String emailHash, long age, long lastAccessDate, String websiteUrl, String location, String aboutMe, long questionCount, long answerCount, long viewCount, long upVoteCount, long downVoteCount, long acceptRate, String userQuestionsUrl, String userAnswersUrl, String userFavoritesUrl, String userTagsUrl, String userBadgesUrl, String userTimelineUrl, String userMentionedUrl, String userCommentsUrl, String userReputationUrl, BadgeCount badgeCount, long timedPenaltyDate)
  {
    this.userId = userId;
    this.userType = userType;
    this.creationDate = creationDate;
    this.displayName = displayName;
    this.reputation = reputation;
    this.emailHash = emailHash;
    this.age = age;
    this.lastAccessDate = lastAccessDate;
    this.websiteUrl = websiteUrl;
    this.location = location;
    this.aboutMe = aboutMe;
    this.questionCount = questionCount;
    this.answerCount = answerCount;
    this.viewCount = viewCount;
    this.upVoteCount = upVoteCount;
    this.downVoteCount = downVoteCount;
    this.acceptRate = acceptRate;
    this.userQuestionsUrl = userQuestionsUrl;
    this.userAnswersUrl = userAnswersUrl;
    this.userFavoritesUrl = userFavoritesUrl;
    this.userTagsUrl = userTagsUrl;
    this.userBadgesUrl = userBadgesUrl;
    this.userTimelineUrl = userTimelineUrl;
    this.userMentionedUrl = userMentionedUrl;
    this.userCommentsUrl = userCommentsUrl;
    this.userReputationUrl = userReputationUrl;
    this.badgeCount = badgeCount;
    this.timedPenaltyDate = timedPenaltyDate;
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

  @XmlElement(name="user_type")
  public String getUserType()
  {
    return userType;
  }

  public void setUserType(String userType)
  {
    this.userType = userType;
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

  @XmlElement(name="display_name")
  public String getDisplayName()
  {
    return displayName;
  }

  public void setDisplayName(String displayName)
  {
    this.displayName = displayName;
  }

  public long getReputation()
  {
    return reputation;
  }

  public void setReputation(long reputation)
  {
    this.reputation = reputation;
  }

  @XmlElement(name="email_hash")
  public String getEmailHash()
  {
    return emailHash;
  }

  public void setEmailHash(String emailHash)
  {
    this.emailHash = emailHash;
  }

  public long getAge()
  {
    return age;
  }

  public void setAge(long age)
  {
    this.age = age;
  }

  @XmlElement(name="last_access_date")
  public long getLastAccessDate()
  {
    return lastAccessDate;
  }

  public void setLastAccessDate(long lastAccessDate)
  {
    this.lastAccessDate = lastAccessDate;
  }

  @XmlElement(name="website_url")
  public String getWebsiteUrl()
  {
    return websiteUrl;
  }

  public void setWebsiteUrl(String websiteUrl)
  {
    this.websiteUrl = websiteUrl;
  }

  public String getLocation()
  {
    return location;
  }

  public void setLocation(String location)
  {
    this.location = location;
  }

  @XmlElement(name="about_me")
  public String getAboutMe()
  {
    return aboutMe;
  }

  public void setAboutMe(String aboutMe)
  {
    this.aboutMe = aboutMe;
  }

  @XmlElement(name="question_count")
  public long getQuestionCount()
  {
    return questionCount;
  }

  public void setQuestionCount(long questionCount)
  {
    this.questionCount = questionCount;
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

  @XmlElement(name="view_count")
  public long getViewCount()
  {
    return viewCount;
  }

  public void setViewCount(long viewCount)
  {
    this.viewCount = viewCount;
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

  @XmlElement(name="accept_rate")
  public long getAcceptRate()
  {
    return acceptRate;
  }

  public void setAcceptRate(long acceptRate)
  {
    this.acceptRate = acceptRate;
  }

  @XmlElement(name="user_questions_url")
  public String getUserQuestionsUrl()
  {
    return userQuestionsUrl;
  }

  public void setUserQuestionsUrl(String userQuestionsUrl)
  {
    this.userQuestionsUrl = userQuestionsUrl;
  }

  @XmlElement(name="user_answers_url")
  public String getUserAnswersUrl()
  {
    return userAnswersUrl;
  }

  public void setUserAnswersUrl(String userAnswersUrl)
  {
    this.userAnswersUrl = userAnswersUrl;
  }

  @XmlElement(name="user_favorites_url")
  public String getUserFavoritesUrl()
  {
    return userFavoritesUrl;
  }

  public void setUserFavoritesUrl(String userFavoritesUrl)
  {
    this.userFavoritesUrl = userFavoritesUrl;
  }

  @XmlElement(name="user_tags_url")
  public String getUserTagsUrl()
  {
    return userTagsUrl;
  }

  public void setUserTagsUrl(String userTagsUrl)
  {
    this.userTagsUrl = userTagsUrl;
  }

  @XmlElement(name="user_badges_url")
  public String getUserBadgesUrl()
  {
    return userBadgesUrl;
  }

  public void setUserBadgesUrl(String userBadgesUrl)
  {
    this.userBadgesUrl = userBadgesUrl;
  }

  @XmlElement(name="user_timeline_url")
  public String getUserTimelineUrl()
  {
    return userTimelineUrl;
  }

  public void setUserTimelineUrl(String userTimelineUrl)
  {
    this.userTimelineUrl = userTimelineUrl;
  }

  @XmlElement(name="user_mentioned_url")
  public String getUserMentionedUrl()
  {
    return userMentionedUrl;
  }

  public void setUserMentionedUrl(String userMentionedUrl)
  {
    this.userMentionedUrl = userMentionedUrl;
  }

  @XmlElement(name="user_comments_url")
  public String getUserCommentsUrl()
  {
    return userCommentsUrl;
  }

  public void setUserCommentsUrl(String userCommentsUrl)
  {
    this.userCommentsUrl = userCommentsUrl;
  }

  @XmlElement(name="user_reputation_url")
  public String getUserReputationUrl()
  {
    return userReputationUrl;
  }

  public void setUserReputationUrl(String userReputationUrl)
  {
    this.userReputationUrl = userReputationUrl;
  }

  @XmlElement(name="badge_counts")
  public BadgeCount getBadgeCount()
  {
    return badgeCount;
  }

  public void setBadgeCount(BadgeCount badgeCount)
  {
    this.badgeCount = badgeCount;
  }

  @XmlElement(name="timed_penalty_date")
  public long getTimedPenaltyDate()
  {
    return timedPenaltyDate;
  }

  public void setTimedPenaltyDate(long timedPenaltyDate)
  {
    this.timedPenaltyDate = timedPenaltyDate;
  }

  @Override
  public String toString()
  {
    return "User{" +
        "userId=" + userId +
        ", userType='" + userType + '\'' +
        ", creationDate=" + creationDate +
        ", displayName='" + displayName + '\'' +
        ", reputation=" + reputation +
        ", emailHash='" + emailHash + '\'' +
        ", age=" + age +
        ", lastAccessDate=" + lastAccessDate +
        ", websiteUrl='" + websiteUrl + '\'' +
        ", location='" + location + '\'' +
        ", aboutMe='" + aboutMe + '\'' +
        ", questionCount=" + questionCount +
        ", answerCount=" + answerCount +
        ", viewCount=" + viewCount +
        ", upVoteCount=" + upVoteCount +
        ", downVoteCount=" + downVoteCount +
        ", acceptRate=" + acceptRate +
        ", userQuestionsUrl='" + userQuestionsUrl + '\'' +
        ", userAnswersUrl='" + userAnswersUrl + '\'' +
        ", userFavoritesUrl='" + userFavoritesUrl + '\'' +
        ", userTagsUrl='" + userTagsUrl + '\'' +
        ", userBadgesUrl='" + userBadgesUrl + '\'' +
        ", userTimelineUrl='" + userTimelineUrl + '\'' +
        ", userMentionedUrl='" + userMentionedUrl + '\'' +
        ", userCommentsUrl='" + userCommentsUrl + '\'' +
        ", userReputationUrl='" + userReputationUrl + '\'' +
        ", badgeCount=" + badgeCount +
        ", timedPenaltyDate=" + timedPenaltyDate +
        '}';
  }

  public static class BadgeCount
  {
    private long gold;
    private long silver;
    private long bronze;

    public BadgeCount()
    {
    }

    public BadgeCount(long gold, long silver, long bronze)
    {
      this.gold = gold;
      this.silver = silver;
      this.bronze = bronze;
    }

    public long getGold()
    {
      return gold;
    }

    public void setGold(long gold)
    {
      this.gold = gold;
    }

    public long getSilver()
    {
      return silver;
    }

    public void setSilver(long silver)
    {
      this.silver = silver;
    }

    public long getBronze()
    {
      return bronze;
    }

    public void setBronze(long bronze)
    {
      this.bronze = bronze;
    }

    @Override
    public String toString()
    {
      return "BadgeCount{" +
          "gold=" + gold +
          ", silver=" + silver +
          ", bronze=" + bronze +
          '}';
    }
  }
}
