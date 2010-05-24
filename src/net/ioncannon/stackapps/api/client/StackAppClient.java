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

package net.ioncannon.stackapps.api.client;

import net.ioncannon.stackapps.api.response.*;
import net.ioncannon.stackapps.api.request.*;
import com.sun.jersey.api.client.filter.GZIPContentEncodingFilter;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.ClientResponse;

import javax.ws.rs.core.MultivaluedMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Logger;

/**
 */
public class StackAppClient
{
  private static Logger logger = Logger.getLogger(StackAppClient.class.getName());

  private static Client client = Client.create();
  static
  {
    client.addFilter(new GZIPContentEncodingFilter());
  }

  private static String apiKey = null;

  private static void processResponseForErrors(ClientResponse response) throws StackAppError
  {
    switch(response.getStatus())
    {
      case 200:
        return;
      case 404:
        throw new StackAppError("The requested resource was not found.");
      case 500:
        throw new StackAppError("The remote service had an internal error.");
      default:
        throw new StackAppError("Unknown error response: " + response.getStatus() + " => " + response.getClientResponseStatus().getReasonPhrase());
    }
  }

  public static void setKey(String key)
  {
    apiKey = key;
  }

  private static <T extends StackAppResponse> T executeRequest(StackAppRequest request, Class<T> tClass) throws StackAppError
  {
    try
    {
      if(apiKey != null)
      {
        request.addQueryPart("key", apiKey);
      }
      else
      {
        logger.info("No API key provided, request limit will be restricted.");
      }

      WebResource webResource = request.constructResource(client);

      ClientResponse response = webResource.get(ClientResponse.class);

      processResponseForErrors(response);

      T rValue = response.getEntity(tClass);

      MultivaluedMap headers = response.getHeaders();
      rValue.setCurrentRateLimit(Long.parseLong((String)((List)headers.get("X-RateLimit-Current")).get(0)));
      rValue.setMaxRateLimit(Long.parseLong((String)((List)headers.get("X-RateLimit-Max")).get(0)));

      return rValue;
    }
    catch (UniformInterfaceException e)
    {
      processResponseForErrors(e.getResponse());
      return null;
    }
  }

  /**
   * /answers/{id}  	Gets an answer by its Id.
   *
   * @param answerId The id of the answer to get.
   * @param answerRequest Any non-default configuration for this request.
   * @return An answer if one is found, null otherwise.
   * @throws StackAppError Thrown when there is an api error.
   */
  public static Answer getAnswer(long answerId, AnswerRequest answerRequest) throws StackAppError
  {
    StackAppRequest request = new StackAppRequest();
    request.pushPath("answers");
    request.pushPath(answerId);

    if(answerRequest != null)
    {
      answerRequest.mergeIntoRequest(request);
    }

    AnswerList answerList = executeRequest(request, AnswerList.class);

    if(answerList != null && answerList.getAnswers() != null && answerList.getAnswers().length > 0)
    {
      return answerList.getAnswers()[0];
    }
    else
    {
      return null;
    }
  }

  public static Answer getAnswer(long answerId) throws StackAppError
  {
    return getAnswer(answerId, null);
  }


  /**
   * /answers/{id}/comments 	Gets the comments associated with the question/answer with 'id'.
   *
   * @param answerId The id of the answer to get.
   * @return A List of comments for the given answer id.
   * @throws StackAppError Thrown when there is an api error.
   */
  public static List<Comment> getAnswerComments(long answerId, AnswerCommentsRequest answerCommentsRequest) throws StackAppError
  {
    StackAppRequest request = new StackAppRequest();
    request.pushPath("answers");
    request.pushPath(answerId);
    request.pushPath("comments");

    if(answerCommentsRequest != null)
    {
      answerCommentsRequest.mergeIntoRequest(request);
    }

    return getCommentsInternal(request);
  }

  public static List<Comment> getAnswerComments(long answerId) throws StackAppError
  {
    return getAnswerComments(answerId, null);
  }

  /**
   * /badges 	Gets all standard, non-tag-based badges in alphabetical order.
   *
   * @return A List of all badges.
   * @throws StackAppError Thrown when there is an api error.
   */
  public static List<Badge> getBadges() throws StackAppError
  {
    StackAppRequest request = new StackAppRequest();
    request.pushPath("badges");

    return getBadgesInternal(request);
  }

  /**
   * /badges/{id} 	Gets the users that have been awarded the badge identified by 'id'.
   *
   * @param badgeId The badge id to get users for.
   * @return A List of users who have the given badge.
   * @throws StackAppError Thrown when there is an api error.
   */
  public static List<User> getUsersWhoHaveBadge(long badgeId, UsersWhoHaveBadgeRequest usersWhoHaveBadgeRequest) throws StackAppError
  {
    StackAppRequest request = new StackAppRequest();
    request.pushPath("users");
    request.pushPath(badgeId);

    if(usersWhoHaveBadgeRequest != null)
    {
      usersWhoHaveBadgeRequest.mergeIntoRequest(request);
    }

    return getUsersInternal(request);
  }

  public static List<User> getUsersWhoHaveBadge(long badgeId) throws StackAppError
  {
    return getUsersWhoHaveBadge(badgeId, null);
  }

  /**
   * /badges/name 	Gets all standard, non-tag-based badges in alphabetical order.
   *
   * @return A List of non-tag-based badges.
   * @throws StackAppError Thrown when there is an api error.
   */
  public static List<Badge> getNonTagBasedBadges() throws StackAppError
  {
    StackAppRequest request = new StackAppRequest();
    request.pushPath("badges");
    request.pushPath("name");

    return getBadgesInternal(request);
  }

  /**
   * /badges/tags 	Gets all tag-based badges in alphabetical order.
   *
   * @return All tag-based badges.
   * @throws StackAppError Thrown when there is an api error.
   */
  public static List<Badge> getTagBasedBadges() throws StackAppError
  {
    StackAppRequest request = new StackAppRequest();
    request.pushPath("badges");
    request.pushPath("tags");

    return getBadgesInternal(request);
  }

  /**
   * /comments/{id} 	Gets comments by ids.
   *
   * @param commentId The id of the comment to get.
   * @return The Comment with the given id.
   * @throws StackAppError Thrown when there is an api error.
   */
  public static Comment getComment(long commentId, CommentRequest commentRequest) throws StackAppError
  {
    StackAppRequest request = new StackAppRequest();
    request.pushPath("comments");
    request.pushPath(commentId);

    if(commentRequest != null)
    {
      commentRequest.mergeIntoRequest(request);
    } 

    CommentList commentList = executeRequest(request, CommentList.class);

    if(commentList != null && commentList.getComments() != null && commentList.getComments().length > 0)
    {
      return commentList.getComments()[0];
    }
    else
    {
      return null;
    }
  }

  public static Comment getComment(long commentId) throws StackAppError
  {
    return getComment(commentId, null);
  }

// todo /errors/{id} 	Simulates an error given a code

  /**
   * /questions 	Gets question summary information. By default, ordered by last activity, date decending.
   *
   * @return A List of questions.
   * @throws StackAppError Thrown when there is an api error.
   */
  public static List<Question> getQuestions(QuestionRequest questionRequest) throws StackAppError
  {
    StackAppRequest request = new StackAppRequest();
    request.pushPath("questions");

    if(questionRequest != null)
    {
      questionRequest.mergeIntoRequest(request);
    }

    return getQuestionsInternal(request);
  }

  public static List<Question> getQuestions() throws StackAppError
  {
    return getQuestions(null);
  }

  /**
   * /questions/{id} 	Gets a question with 'id' and its answers.
   *
   * @param questionId The id of the question to return.
   * @return The question with the given question id.
   * @throws StackAppError Thrown when there is an api error.
   */
  public static Question getQuestionById(long questionId, QuestionByIdRequest questionByIdRequest) throws StackAppError
  {
    StackAppRequest request = new StackAppRequest();
    request.pushPath("questions");
    request.pushPath(questionId);

    if(questionByIdRequest != null)
    {
      questionByIdRequest.mergeIntoRequest(request);
    }

    QuestionList questionList = executeRequest(request, QuestionList.class);

    if(questionList != null && questionList.getQuestions() != null && questionList.getQuestions().length > 0)
    {
      return questionList.getQuestions()[0];
    }
    else
    {
      return null;
    }
  }

  public static Question getQuestionById(long questionId) throws StackAppError
  {
    return getQuestionById(questionId, null);
  }

  /**
   * /questions/{id}/answers 	Gets any answers to the question with 'id'.
   *
   * @param questionId The id of the question to return answers for.
   * @return A List of Answers.
   * @throws StackAppError Thrown when there is an api error.
   */
  public static List<Answer> getAnswersForQuestion(long questionId, QuestionByIdRequest answersForQuestionRequest) throws StackAppError
  {
    StackAppRequest request = new StackAppRequest();
    request.pushPath("questions");
    request.pushPath(questionId);
    request.pushPath("answers");

    if(answersForQuestionRequest != null)
    {
      answersForQuestionRequest.mergeIntoRequest(request);
    }

    return getAnswersInternal(request);
  }

  public static List<Answer> getAnswersForQuestion(long questionId) throws StackAppError
  {
    return getAnswersForQuestion(questionId, null);
  }

  /**
   * /questions/{id}/comments 	Gets the comments associated with the question/answer with 'id'.
   *
   * @param questionId The id of the question to return comments for.
   * @return A List of Comments.
   * @throws StackAppError Thrown when there is an api error.
   */
  public static List<Comment> getCommentsForQuestion(long questionId, CommentsForQuestionRequest commentsForQuestionRequest) throws StackAppError
  {
    StackAppRequest request = new StackAppRequest();
    request.pushPath("questions");
    request.pushPath(questionId);
    request.pushPath("comments");

    if(commentsForQuestionRequest != null)
    {
      commentsForQuestionRequest.mergeIntoRequest(request);
    }

    return getCommentsInternal(request);
  }

  public static List<Comment> getCommentsForQuestion(long questionId) throws StackAppError
  {
    return getCommentsForQuestion(questionId, null);
  }

  /**
   * /questions/{id}/timeline 	Gets the timeline of events for the question with 'id'.
   *
   * @param questionId The id of the question to return comments for.
   * @return A List of Comments.
   * @throws StackAppError Thrown when there is an api error.
   */
  public static List<PostTimeline> getTimelineForQuestion(long questionId) throws StackAppError
  {
    StackAppRequest request = new StackAppRequest();
    request.pushPath("questions");
    request.pushPath(questionId);
    request.pushPath("timeline");

    PostTimelineList postTimelineListList = executeRequest(request, PostTimelineList.class);

    List<PostTimeline> postTimelines = new ArrayList<PostTimeline>();

    if(postTimelineListList != null && postTimelineListList.getTimelines() != null)
    {
      postTimelines.addAll(Arrays.asList(postTimelineListList.getTimelines()));
    }

    return postTimelines;
  }

  /**
   * /questions/tagged/{tags} 	Gets questions that are tagged with "tags". By default, ordered by last activity, date descending.
   *
   * @param tag The tag to get questions for.
   * @return A List of Questions.
   * @throws StackAppError Thrown when there is an api error.
   */
  public static List<Question> getQuestionsForTag(String tag, QuestionByIdRequest questionsForTagRequest) throws StackAppError
  {
    StackAppRequest request = new StackAppRequest();
    request.pushPath("questions");
    request.pushPath("tagged");
    request.pushPath(tag);

    if(questionsForTagRequest != null)
    {
      questionsForTagRequest.mergeIntoRequest(request);
    }

    return getQuestionsInternal(request);
  }

  public static List<Question> getQuestionsForTag(String tag) throws StackAppError
  {
    return getQuestionsForTag(tag, null);
  }

  /**
   * /questions/unanswered 	Gets questions that have no upvoted answers.
   *
   * @return A List of Questions.
   * @throws StackAppError Thrown when there is an api error.
   */
  public static List<Question> getUnansweredQuestions(QuestionRequest questionRequest) throws StackAppError
  {
    StackAppRequest request = new StackAppRequest();
    request.pushPath("questions");
    request.pushPath("unanswered");

    if(questionRequest != null)
    {
      questionRequest.mergeIntoRequest(request);
    }

    return getQuestionsInternal(request);
  }

  public static List<Question> getUnansweredQuestions() throws StackAppError
  {
    return getUnansweredQuestions(null);
  }

// todo /revisions/{id} 	Gets the post history revisions for the post with 'id'. Optionally, a specific revision may be requested by its 'revisionGuid'.

// todo /revisions/{id}/{revisionguid} 	Gets the post history revisions for the post with 'id'. Optionally, a specific revision may be requested by its 'revisionGuid'.

  /**
   * /stats 	Gets various system statistics, e.g. total questions, total answers, total tags.
   *
   * @return A List of Stats.
   * @throws StackAppError Thrown when there is an api error.
   */
  public static Stats getStats() throws StackAppError
  {
    StackAppRequest request = new StackAppRequest();
    request.pushPath("stats");

    StatsList statsList = executeRequest(request, StatsList.class);

    if(statsList != null && statsList.getStats() != null && statsList.getStats().length > 0)
    {
      return statsList.getStats()[0];
    }
    else
    {
      return null;
    }
  }

  /**
   * /tags 	Gets the tags on all questions, along with their usage counts.
   *
   * @return A List of Tags.
   * @throws StackAppError Thrown when there is an api error.
   */
  public static List<Tag> getTags(TagsRequest tagsRequest) throws StackAppError
  {
    StackAppRequest request = new StackAppRequest();
    request.pushPath("tags");

    if(tagsRequest != null)
    {
      tagsRequest.mergeIntoRequest(request);
    }

// todo this can be refactored, combined with user tags
    TagList tagList = executeRequest(request, TagList.class);

    List<Tag> tags = new ArrayList<Tag>();

    if(tagList != null && tagList.getTags() != null)
    {
      tags.addAll(Arrays.asList(tagList.getTags()));
    }

    return tags;
  }

  public static List<Tag> getTags() throws StackAppError
  {
    return getTags(null);
  }

  /**
   * /users 	Gets user summary information. By default, ordered by reputation, descending.
   *
   * @return A List of Users.
   * @throws StackAppError Thrown when there is an api error.
   */
  public static List<User> getUsers(UsersRequest usersRequest) throws StackAppError
  {
    StackAppRequest request = new StackAppRequest();
    request.pushPath("users");

    if(usersRequest != null)
    {
      usersRequest.mergeIntoRequest(request);
    }

    return getUsersInternal(request);
  }

  public static List<User> getUsers() throws StackAppError
  {
    return getUsers(null);
  }

  /**
   * /users/{id} 	Gets summary information for the user with 'id'.
   *
   * @param userId The id of the user to return.
   * @return The user idtentified by the given id.
   * @throws StackAppError hrown when there is an api error.
   */
  public static User getUser(long userId, UsersByIdRequest usersByIdRequest) throws StackAppError
  {
    StackAppRequest request = new StackAppRequest();
    request.pushPath("users");
    request.pushPath(userId);

    if(usersByIdRequest != null)
    {
      usersByIdRequest.mergeIntoRequest(request);
    }

    UserList userList = executeRequest(request, UserList.class);

    if(userList != null && userList.getUsers() != null && userList.getUsers().length > 0)
    {
      return userList.getUsers()[0];
    }
    else
    {
      return null;
    }
  }

  public static User getUser(long userId) throws StackAppError
  {
    return getUser(userId, null);
  }

  /**
   * /users/{id}/answers 	Gets answer summary information for the user with 'id'.
   *
   * @param userId The id of the user to return.
   * @return List of answers for the given user id.
   * @throws StackAppError Thrown when there is an api error.
   */
  public static List<Answer> getAnswersForUser(long userId, AnswersForUserRequest answersForUserRequest) throws StackAppError
  {
    StackAppRequest request = new StackAppRequest();
    request.pushPath("users");
    request.pushPath(userId);
    request.pushPath("answers");

    if(answersForUserRequest != null)
    {
      answersForUserRequest.mergeIntoRequest(request);
    }

    return getAnswersInternal(request);
  }

  public static List<Answer> getAnswersForUser(long userId) throws StackAppError
  {
    return getAnswersForUser(userId, null);
  }

  /**
   * /users/{id}/badges 	Gets the badges that have been awarded to the user with 'id'.
   *
   * @param userId The user id to get the badges for.
   * @return A list of badges for the given user id.
   * @throws StackAppError Thrown when there is an api error.
   */
  public static List<Badge> getBadgesForUser(long userId) throws StackAppError
  {
    StackAppRequest request = new StackAppRequest();
    request.pushPath("users");
    request.pushPath(userId);
    request.pushPath("badges");

    return getBadgesInternal(request);
  }

  /**
   * /users/{id}/comments 	Gets the comments that the user with 'id' has made, ordered by creation date descending.
   *  
   * @param userId User id to get comments for.
   * @return List of Comments for the given user id.
   * @throws StackAppError Thrown when there is an api error.
   */
  public static List<Comment> getCommentsForUser(long userId, UsersByIdRequest usersByIdRequest) throws StackAppError
  {
    StackAppRequest request = new StackAppRequest();
    request.pushPath("users");
    request.pushPath(userId);
    request.pushPath("comments");

    if(usersByIdRequest != null)
    {
      usersByIdRequest.mergeIntoRequest(request);
    }

    return getCommentsInternal(request);
  }

  public static List<Comment> getCommentsForUser(long userId) throws StackAppError
  {
    return getCommentsForUser(userId, null);
  }

  // todo /users/{id}/comments/{toid} 	Gets the comments by user with 'id' that mention the user with 'toid'.

  /**
   * /users/{id}/favorites 	Gets summary information for the questions that have been favorited by the user with 'id'.
   *
   * @param userId User id to get favorites for
   * @return List of favorite questions for the given user id.
   * @throws StackAppError Thrown when there is an api error.
   */
  public static List<Question> getFavoritesForUser(long userId, AnswersForUserRequest favoritesForUserRequest) throws StackAppError
  {
    StackAppRequest request = new StackAppRequest();
    request.pushPath("users");
    request.pushPath(userId);
    request.pushPath("favorites");

    if(favoritesForUserRequest != null)
    {
      favoritesForUserRequest.mergeIntoRequest(request);
    }

    return getQuestionsInternal(request);
  }

  public static List<Question> getFavoritesForUser(long userId) throws StackAppError
  {
    return getFavoritesForUser(userId, null);
  }

  /**
   * /users/{id}/mentioned 	Gets comments that are directed at the user with 'id', ordered by creation date descending.
   *
   * @param userId User id to get mentions of.
   * @return A List of comments that the user was mentioned in.
   * @throws StackAppError Thrown when there is an api error.
   */
  public static List<Comment> getMentionsForUser(long userId, AnswersForUserRequest mentionsForUserRequest) throws StackAppError
  {
    StackAppRequest request = new StackAppRequest();
    request.pushPath("users");
    request.pushPath(userId);
    request.pushPath("mentioned");

    if(mentionsForUserRequest != null)
    {
      mentionsForUserRequest.mergeIntoRequest(request);
    }

    return getCommentsInternal(request);
  }

  public static List<Comment> getMentionsForUser(long userId) throws StackAppError
  {
    return getMentionsForUser(userId, null);
  }

  /**
   * /users/{id}/questions 	Gets question summary infomation for the user with 'id'.
   *
   * @param userId The user id to get questions for.
   * @return A List of questions for the given user id.
   * @throws StackAppError Thrown when there is an api error.
   */
  public static List<Question> getQuestionsForUser(long userId, AnswersForUserRequest questionsForUserRequest) throws StackAppError
  {
    StackAppRequest request = new StackAppRequest();
    request.pushPath("users");
    request.pushPath(userId);
    request.pushPath("questions");

    if(questionsForUserRequest != null)
    {
      questionsForUserRequest.mergeIntoRequest(request);
    }

    return getQuestionsInternal(request);
  }

  public static List<Question> getQuestionsForUser(long userId) throws StackAppError
  {
    return getQuestionsForUser(userId, null);
  }

  /**
   * /users/{id}/reputation 	Gets information on reputation changes for user with 'id'.
   * 
   * @param userId The user id to get reputation for.
   * @return A List of rep changes.
   * @throws StackAppError Thrown when there is an api error.
   */
  public static List<RepChange> getReputationForUser(long userId, ReputationForUserRequest reputationForUserRequest) throws StackAppError
  {
    StackAppRequest request = new StackAppRequest();
    request.pushPath("users");
    request.pushPath(userId);
    request.pushPath("reputation");

    if(reputationForUserRequest != null)
    {
      reputationForUserRequest.mergeIntoRequest(request);
    }

    RepChangeList repChangeList = executeRequest(request, RepChangeList.class);

    List<RepChange> repChanges = new ArrayList<RepChange>();

    if(repChangeList != null && repChangeList.getRepChanges() != null)
    {
      repChanges.addAll(Arrays.asList(repChangeList.getRepChanges()));
    }

    return repChanges;
  }

  public static List<RepChange> getReputationForUser(long userId) throws StackAppError
  {
    return getReputationForUser(userId, null);
  }

  /**
   * /users/{id}/tags 	Gets the tags that the user with 'id' has participated in.
   *
   * @param userId The user id to get tags for.
   * @return A List of tags for the given user id.
   * @throws StackAppError Thrown when there is an api error.
   */
  public static List<Tag> getTagsForUser(long userId, UsersRequest tagsForUserRequest) throws StackAppError
  {
    StackAppRequest request = new StackAppRequest();
    request.pushPath("users");
    request.pushPath(userId);
    request.pushPath("tags");

    if(tagsForUserRequest != null)
    {
      tagsForUserRequest.mergeIntoRequest(request);
    }

    TagList tagList = executeRequest(request, TagList.class);

    List<Tag> tags = new ArrayList<Tag>();

    if(tagList != null && tagList.getTags() != null)
    {
      tags.addAll(Arrays.asList(tagList.getTags()));
    }

    return tags;
  }

  public static List<Tag> getTagsForUser(long userId) throws StackAppError
  {
    return getTagsForUser(userId, null);
  }

  /**
   * /users/{id}/timeline 	Gets actions the user with 'id' has performed in descending chronological order.
   *
   * @param userId The user id to get a timeline for.
   * @return A List of timeline entries.
   * @throws StackAppError Thrown when there is an api error.
   */
  public static List<UserTimeline> getTimelineForUser(long userId, UsersByIdRequest timelineForUserRequest) throws StackAppError
  {
    StackAppRequest request = new StackAppRequest();
    request.pushPath("users");
    request.pushPath(userId);
    request.pushPath("timeline");

    if(timelineForUserRequest != null)
    {
      timelineForUserRequest.mergeIntoRequest(request);
    }

    UserTimelineList userTimelineList = executeRequest(request, UserTimelineList.class);

    List<UserTimeline> userTimelines = new ArrayList<UserTimeline>();

    if(userTimelineList != null && userTimelineList.getTimelines() != null)
    {
      userTimelines.addAll(Arrays.asList(userTimelineList.getTimelines()));
    }

    return userTimelines;
  }

  public static List<UserTimeline> getTimelineForUser(long userId) throws StackAppError
  {
    return getTimelineForUser(userId, null);
  }

  private static List<Question> getQuestionsInternal(StackAppRequest request)
  {
    QuestionList questionList = executeRequest(request, QuestionList.class);

    List<Question> questions = new ArrayList<Question>();

    if(questionList != null && questionList.getQuestions() != null)
    {
      questions.addAll(Arrays.asList(questionList.getQuestions()));
    }

    return questions;
  }

  private static List<Comment> getCommentsInternal(StackAppRequest request)
  {
    CommentList commentList = executeRequest(request, CommentList.class);

    List<Comment> comments = new ArrayList<Comment>();

    if(commentList != null && commentList.getComments() != null)
    {
      comments.addAll(Arrays.asList(commentList.getComments()));
    }

    return comments;
  }

  private static List<Answer> getAnswersInternal(StackAppRequest request)
  {
    AnswerList answerList = executeRequest(request, AnswerList.class);

    List<Answer> answers = new ArrayList<Answer>();

    if(answerList != null && answerList.getAnswers() != null)
    {
      answers.addAll(Arrays.asList(answerList.getAnswers()));
    }

    return answers;
  }

  private static List<Badge> getBadgesInternal(StackAppRequest request)
  {
    BadgeList badgeList = executeRequest(request, BadgeList.class);

    List<Badge> badges = new ArrayList<Badge>();

    if(badgeList != null && badgeList.getBadges() != null)
    {
      badges.addAll(Arrays.asList(badgeList.getBadges()));
    }

    return badges;
  }

  private static List<User> getUsersInternal(StackAppRequest request)
  {
    UserList userList = executeRequest(request, UserList.class);

    List<User> users = new ArrayList<User>();

    if(userList != null && userList.getUsers() != null)
    {
      users.addAll(Arrays.asList(userList.getUsers()));
    }

    return users;
  }
}
