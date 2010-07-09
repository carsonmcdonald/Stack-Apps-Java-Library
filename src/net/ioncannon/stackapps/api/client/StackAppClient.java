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
import net.ioncannon.stackapps.api.response.Error;
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

  private static String baseUrl = StackAppRequest.STACKOVERFLOW_BASE_URL;
  private static String stackAuthBaseUrl = StackAppRequest.STACKAUTH_BASE_URL;
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

  public static void setKey(String apiKey)
  {
    StackAppClient.apiKey = apiKey;
  }

  public static void setBaseUrl(String baseUrl)
  {
    StackAppClient.baseUrl = baseUrl;
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

      if(headers.containsKey("X-RateLimit-Current"))
      {
        rValue.setCurrentRateLimit(Long.parseLong((String)((List)headers.get("X-RateLimit-Current")).get(0)));
      }
      else
      {
        rValue.setCurrentRateLimit(-1);
      }
      if(headers.containsKey("X-RateLimit-Max"))
      {
        rValue.setMaxRateLimit(Long.parseLong((String)((List)headers.get("X-RateLimit-Max")).get(0)));
      }
      else
      {
        rValue.setMaxRateLimit(-1);
      }

      return rValue;
    }
    catch (UniformInterfaceException e)
    {
      processResponseForErrors(e.getResponse());
      return null;
    }
  }

  /**
   * /answers/{id}  	Gets the set of answers enumerated in id
   *
   * @param answerId The id of the answer to get.
   * @param answerRequest Any non-default configuration for this request.
   * @return An answer if one is found, null otherwise.
   * @throws StackAppError Thrown when there is an api error.
   */
  public static Answer getAnswer(long answerId, AnswerRequestConfiguration answerRequest) throws StackAppError
  {
    StackAppRequest request = new StackAppRequest(baseUrl);
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
   * /answers/{id}/comments 	Gets the comments associated with a set of answers.
   *
   * @param answerId The id of the answer to get.
   * @param requestConfiguration The configuration to use for this request.
   * @return A List of comments for the given answer id.
   * @throws StackAppError Thrown when there is an api error.
   */
  public static List<Comment> getAnswerComments(long answerId, AnswerCommentsRequestConfiguration requestConfiguration) throws StackAppError
  {
    StackAppRequest request = new StackAppRequest(baseUrl);
    request.pushPath("answers");
    request.pushPath(answerId);
    request.pushPath("comments");

    if(requestConfiguration != null)
    {
      requestConfiguration.mergeIntoRequest(request);
    }

    return getCommentsInternal(request);
  }

  public static List<Comment> getAnswerComments(long answerId) throws StackAppError
  {
    return getAnswerComments(answerId, null);
  }

  /**
   * /badges         Gets all badges, in alphabetical order.
   *
   * @return A List of all badges.
   * @throws StackAppError Thrown when there is an api error.
   */
  public static List<Badge> getBadges() throws StackAppError
  {
    StackAppRequest request = new StackAppRequest(baseUrl);
    request.pushPath("badges");

    return getBadgesInternal(request);
  }

  /**
   * /badges/{id}    Gets the users that have been awarded the badges identified in '
   *
   * @param badgeId The badge id to get users for.
   * @param requestConfiguration The configuration to use for this request.
   * @return A List of users who have the given badge.
   * @throws StackAppError Thrown when there is an api error.
   */
  public static List<User> getUsersWhoHaveBadge(long badgeId, UsersWhoHaveBadgeRequestConfiguration requestConfiguration) throws StackAppError
  {
    StackAppRequest request = new StackAppRequest(baseUrl);
    request.pushPath("users");
    request.pushPath(badgeId);

    if(requestConfiguration != null)
    {
      requestConfiguration.mergeIntoRequest(request);
    }

    return getUsersInternal(request);
  }

  public static List<User> getUsersWhoHaveBadge(long badgeId) throws StackAppError
  {
    return getUsersWhoHaveBadge(badgeId, null);
  }

  /**
   * /badges/name    Gets all standard, non-tag-based badges in alphabetical order.
   *
   * @return A List of non-tag-based badges.
   * @throws StackAppError Thrown when there is an api error.
   */
  public static List<Badge> getNonTagBasedBadges() throws StackAppError
  {
    StackAppRequest request = new StackAppRequest(baseUrl);
    request.pushPath("badges");
    request.pushPath("name");

    return getBadgesInternal(request);
  }

  /**
   * /badges/tags    Gets all tag-based badges in alphabetical order.
   *
   * @return All tag-based badges.
   * @throws StackAppError Thrown when there is an api error.
   */
  public static List<Badge> getTagBasedBadges() throws StackAppError
  {
    StackAppRequest request = new StackAppRequest(baseUrl);
    request.pushPath("badges");
    request.pushPath("tags");

    return getBadgesInternal(request);
  }

  /**
   * /comments/{id} 	Gets comments by ids.
   *
   * @param commentId The id of the comment to get.
   * @param requestConfiguration The configuration to use for this request.
   * @return The Comment with the given id.
   * @throws StackAppError Thrown when there is an api error.
   */
  public static Comment getComment(long commentId, CommentRequestConfiguration requestConfiguration) throws StackAppError
  {
    StackAppRequest request = new StackAppRequest(baseUrl);
    request.pushPath("comments");
    request.pushPath(commentId);

    if(requestConfiguration != null)
    {
      requestConfiguration.mergeIntoRequest(request);
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

  /**
   * /errors/{id} 	Simulates an error given a code
   *
   * @param errorId The error id to simulate.
   * @return An error represented by the given id
   * @throws StackAppError Thrown when there is an api error.
   */
  public static Error getError(int errorId) throws StackAppError
  {
    StackAppRequest request = new StackAppRequest(baseUrl);
    request.pushPath("errors");
    request.pushPath(errorId);

    return executeRequest(request, Error.class);
  }

  /**
   * /posts/{id}/comments    Gets the comments associated with a set of posts (questi ons and/or answers). 
   *
   * @param postId The id of the post to get comments.
   * @param requestConfiguration The configuration to use for this request.
   * @return A List of Comments on the given post.
   * @throws StackAppError Thrown when there is an api error.
   */
  public static List<Comment> getPostComments(long postId, CommentRequestConfiguration requestConfiguration) throws StackAppError
  {
    StackAppRequest request = new StackAppRequest(baseUrl);
    request.pushPath("posts");
    request.pushPath(postId);
    request.pushPath("comments");

    if(requestConfiguration != null)
    {
      requestConfiguration.mergeIntoRequest(request);
    } 

    return getCommentsInternal(request);
  }

  public static List<Comment> getPostComment(long postId) throws StackAppError
  {
    return getPostComments(postId, null);
  }


  /**
   * /questions      Gets question summary information.
   *
   * @param requestConfiguration The configuration to use for this request.
   * @return A List of questions.
   * @throws StackAppError Thrown when there is an api error.
   */
  public static List<Question> getQuestions(QuestionRequestConfiguration requestConfiguration) throws StackAppError
  {
    StackAppRequest request = new StackAppRequest(baseUrl);
    request.pushPath("questions");

    if(requestConfiguration != null)
    {
      requestConfiguration.mergeIntoRequest(request);
    }

    return getQuestionsInternal(request);
  }

  public static List<Question> getQuestions() throws StackAppError
  {
    return getQuestions(null);
  }

  /**
   * /questions/{id}         Gets the set questions identified in 'id' and their answers.
   *
   * @param questionId The id of the question to return.
   * @param requestConfiguration The configuration to use for this request.
   * @return The question with the given question id.
   * @throws StackAppError Thrown when there is an api error.
   */
  public static Question getQuestionById(long questionId, QuestionByIdRequestConfiguration requestConfiguration) throws StackAppError
  {
    StackAppRequest request = new StackAppRequest(baseUrl);
    request.pushPath("questions");
    request.pushPath(questionId);

    if(requestConfiguration != null)
    {
      requestConfiguration.mergeIntoRequest(request);
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
   * /questions/{id}/answers         Gets any answers to the question in 'id'.
   *
   * @param questionId The id of the question to return answers for.
   * @param requestConfiguration The configuration to use for this request.
   * @return A List of Answers.
   * @throws StackAppError Thrown when there is an api error.
   */
  public static List<Answer> getAnswersForQuestion(long questionId, QuestionByIdRequestConfiguration requestConfiguration) throws StackAppError
  {
    StackAppRequest request = new StackAppRequest(baseUrl);
    request.pushPath("questions");
    request.pushPath(questionId);
    request.pushPath("answers");

    if(requestConfiguration != null)
    {
      requestConfiguration.mergeIntoRequest(request);
    }

    return getAnswersInternal(request);
  }

  public static List<Answer> getAnswersForQuestion(long questionId) throws StackAppError
  {
    return getAnswersForQuestion(questionId, null);
  }

  /**
   * /questions/{id}/comments        Gets the comments associated with a set of questions.
   *
   * @param questionId The id of the question to return comments for.
   * @param requestConfiguration The configuration to use for this request.
   * @return A List of Comments.
   * @throws StackAppError Thrown when there is an api error.
   */
  public static List<Comment> getCommentsForQuestion(long questionId, CommentsForQuestionRequestConfiguration requestConfiguration) throws StackAppError
  {
    StackAppRequest request = new StackAppRequest(baseUrl);
    request.pushPath("questions");
    request.pushPath(questionId);
    request.pushPath("comments");

    if(requestConfiguration != null)
    {
      requestConfiguration.mergeIntoRequest(request);
    }

    return getCommentsInternal(request);
  }

  public static List<Comment> getCommentsForQuestion(long questionId) throws StackAppError
  {
    return getCommentsForQuestion(questionId, null);
  }

  /**
   * /questions/{id}/timeline        Gets the timeline of events for the questions in 'id'.
   *
   * @param questionId The id of the question to return comments for.
   * @return A List of Comments.
   * @throws StackAppError Thrown when there is an api error.
   */
  public static List<PostTimeline> getTimelineForQuestion(long questionId) throws StackAppError
  {
    StackAppRequest request = new StackAppRequest(baseUrl);
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
   * /questions/unanswered 	Gets questions that have no upvoted answers.
   *
   * @param requestConfiguration The configuration to use for this request.
   * @return A List of Questions.
   * @throws StackAppError Thrown when there is an api error.
   */
  public static List<Question> getUnansweredQuestions(QuestionRequestConfiguration requestConfiguration) throws StackAppError
  {
    StackAppRequest request = new StackAppRequest(baseUrl);
    request.pushPath("questions");
    request.pushPath("unanswered");

    if(requestConfiguration != null)
    {
      requestConfiguration.mergeIntoRequest(request);
    }

    return getQuestionsInternal(request);
  }

  public static List<Question> getUnansweredQuestions() throws StackAppError
  {
    return getUnansweredQuestions(null);
  }

  /**
   * /revisions/{id}         Gets the post history revisions for a set of posts in 'id'.
   *
   * @param postId The id of the post to get revisions for.
   * @param requestConfiguration The configuration to use for this request.
   * @return A list of revisions for the given post id.
   */
  public static List<Revision> getRevisionsById(long postId, RevisionRequestConfigConfiguration requestConfiguration)
  {
    StackAppRequest request = new StackAppRequest(baseUrl);
    request.pushPath("revisions");
    request.pushPath(postId);

    if(requestConfiguration != null)
    {
      requestConfiguration.mergeIntoRequest(request);
    }

    RevisionList revisionList = executeRequest(request, RevisionList.class);

    List<Revision> revisions = new ArrayList<Revision>();

    if(revisionList != null && revisionList.getRevisions() != null)
    {
      revisions.addAll(Arrays.asList(revisionList.getRevisions()));
    }

    return revisions;
  }

  public static List<Revision> getRevisionsById(long postId)
  {
    return getRevisionsById(postId, null);
  }

  /**
   * /revisions/{id}/{revisionguid}  Get a specific post revision.
   *
   * @param postId The id of the post to get revisions for.
   * @param revisionGuid The guid of the revision to query.
   * @param requestConfiguration The configuration to use for this request.
   * @return A list of revisions for the given post id.
   */
  public static Revision getRevisionsByIdWithGuid(long postId, String revisionGuid, RevisionRequestConfigConfiguration requestConfiguration)
  {
    StackAppRequest request = new StackAppRequest(baseUrl);
    request.pushPath("revisions");
    request.pushPath(postId);
    request.pushPath(revisionGuid);

    if(requestConfiguration != null)
    {
      requestConfiguration.mergeIntoRequest(request);
    }

    RevisionList revisionList = executeRequest(request, RevisionList.class);

    if(revisionList != null && revisionList.getRevisions() != null && revisionList.getRevisions().length > 0)
    {
      return revisionList.getRevisions()[0];
    }
    else
    {
      return null;
    }
  }

  public static Revision getRevisionsByIdWithGuid(long postId, String revisionGuid)
  {
    return getRevisionsByIdWithGuid(postId, revisionGuid, null);
  }

  /**
   * /search         Searches questions. One of intitle, tagged, or nottagged must be set. Searches that are purely text based should be routed through a third-party search engine, for performance reasons.
   *
   * @param requestConfiguration The configuration to use for this request.
   * @return A List of questions.
   * @throws StackAppError Thrown when there is an api error.
   */
  public static List<Question> searchQuestions(SearchQuestionsRequestConfiguration requestConfiguration) throws StackAppError
  {
    StackAppRequest request = new StackAppRequest(baseUrl);
    request.pushPath("search");

    if(requestConfiguration != null)
    {
      requestConfiguration.mergeIntoRequest(request);
    }

    return getQuestionsInternal(request);
  }

  /**
   * /stats  Gets various system statistics.
   *
   * @return A Stats object.
   * @throws StackAppError Thrown when there is an api error.
   */
  public static Stats getStats() throws StackAppError
  {
    StackAppRequest request = new StackAppRequest(baseUrl);
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
   * /tags   Gets the tags on all questions, along with their usage counts.
   *
   * @param requestConfiguration The configuration to use for this request.
   * @return A List of Tags.
   * @throws StackAppError Thrown when there is an api error.
   */
  public static List<Tag> getTags(TagsRequestConfiguration requestConfiguration) throws StackAppError
  {
    StackAppRequest request = new StackAppRequest(baseUrl);
    request.pushPath("tags");

    if(requestConfiguration != null)
    {
      requestConfiguration.mergeIntoRequest(request);
    }

    return getTagsInternal(request);
  }

  public static List<Tag> getTags() throws StackAppError
  {
    return getTags(null);
  }

  /**
   * /users  Gets user summary information.
   *
   * @param requestConfiguration The configuration to use for this request.
   * @return A List of Users.
   * @throws StackAppError Thrown when there is an api error.
   */
  public static List<User> getUsers(UsersRequestConfiguration requestConfiguration) throws StackAppError
  {
    StackAppRequest request = new StackAppRequest(baseUrl);
    request.pushPath("users");

    if(requestConfiguration != null)
    {
      requestConfiguration.mergeIntoRequest(request);
    }

    return getUsersInternal(request);
  }

  public static List<User> getUsers() throws StackAppError
  {
    return getUsers(null);
  }

  /**
   * /users/{id}     Gets summary information for a set of users.
   *
   * @param userId The id of the user to return.
   * @param requestConfiguration The configuration to use for this request.
   * @return The user idtentified by the given id.
   * @throws StackAppError hrown when there is an api error.
   */
  public static User getUser(long userId, UsersByIdRequestConfiguration requestConfiguration) throws StackAppError
  {
    StackAppRequest request = new StackAppRequest(baseUrl);
    request.pushPath("users");
    request.pushPath(userId);

    if(requestConfiguration != null)
    {
      requestConfiguration.mergeIntoRequest(request);
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
   * /users/{id}/answers     Gets answer summary information for a set of users.
   *
   * @param userId The id of the user to return.
   * @param requestConfiguration The configuration to use for this request.
   * @return List of answers for the given user id.
   * @throws StackAppError Thrown when there is an api error.
   */
  public static List<Answer> getAnswersForUser(long userId, AnswersForUserRequestConfiguration requestConfiguration) throws StackAppError
  {
    StackAppRequest request = new StackAppRequest(baseUrl);
    request.pushPath("users");
    request.pushPath(userId);
    request.pushPath("answers");

    if(requestConfiguration != null)
    {
      requestConfiguration.mergeIntoRequest(request);
    }

    return getAnswersInternal(request);
  }

  public static List<Answer> getAnswersForUser(long userId) throws StackAppError
  {
    return getAnswersForUser(userId, null);
  }

  /**
   * /users/{id}/badges      Gets the badges that have been awarded to a set of users.
   *
   * @param userId The user id to get the badges for.
   * @return A list of badges for the given user id.
   * @throws StackAppError Thrown when there is an api error.
   */
  public static List<Badge> getBadgesForUser(long userId) throws StackAppError
  {
    StackAppRequest request = new StackAppRequest(baseUrl);
    request.pushPath("users");
    request.pushPath(userId);
    request.pushPath("badges");

    return getBadgesInternal(request);
  }

  /**
   * /users/{id}/comments    Gets the comments that a set of users have made.
   *  
   * @param userId User id to get comments for.
   * @param requestConfiguration The configuration to use for this request.
   * @return List of Comments for the given user id.
   * @throws StackAppError Thrown when there is an api error.
   */
  public static List<Comment> getCommentsForUser(long userId, UsersByIdRequestConfiguration requestConfiguration) throws StackAppError
  {
    StackAppRequest request = new StackAppRequest(baseUrl);
    request.pushPath("users");
    request.pushPath(userId);
    request.pushPath("comments");

    if(requestConfiguration != null)
    {
      requestConfiguration.mergeIntoRequest(request);
    }

    return getCommentsInternal(request);
  }

  public static List<Comment> getCommentsForUser(long userId) throws StackAppError
  {
    return getCommentsForUser(userId, null);
  }

  /**
   * /users/{id}/comments/{toid}     Gets the comments by a set of users that mention the user with 'toid'.
   *
   * @param userId User id to get comments for.
   * @param mentionedUserId The user id that was mentioned.
   * @param requestConfiguration The configuration to use for this request.
   * @return List of Comments for the given user id.
   * @throws StackAppError Thrown when there is an api error.
   */
  public static List<Comment> getCommentsForUserThatMentionUser(long userId, long mentionedUserId, UsersByIdRequestConfiguration requestConfiguration)
  {
    StackAppRequest request = new StackAppRequest(baseUrl);
    request.pushPath("users");
    request.pushPath(userId);
    request.pushPath("comments");
    request.pushPath(mentionedUserId);

    if(requestConfiguration != null)
    {
      requestConfiguration.mergeIntoRequest(request);
    }

    return getCommentsInternal(request);
  }

  public static List<Comment> getCommentsForUserThatMentionUser(long userId, long mentionedUserId)
  {
    return getCommentsForUserThatMentionUser(userId, mentionedUserId, null);
  }

  /**
   * /users/{id}/favorites   Gets summary information for the questions that have been favorited by a set of users.
   *
   * @param userId User id to get favorites for
   * @param requestConfiguration The configuration to use for this request.
   * @return List of favorite questions for the given user id.
   * @throws StackAppError Thrown when there is an api error.
   */
  public static List<Question> getFavoritesForUser(long userId, AnswersForUserRequestConfiguration requestConfiguration) throws StackAppError
  {
    StackAppRequest request = new StackAppRequest(baseUrl);
    request.pushPath("users");
    request.pushPath(userId);
    request.pushPath("favorites");

    if(requestConfiguration != null)
    {
      requestConfiguration.mergeIntoRequest(request);
    }

    return getQuestionsInternal(request);
  }

  public static List<Question> getFavoritesForUser(long userId) throws StackAppError
  {
    return getFavoritesForUser(userId, null);
  }

  /**
   * /users/{id}/mentioned   Gets comments that are directed at a set of users.
   *
   * @param userId User id to get mentions of.
   * @param requestConfiguration The configuration to use for this request.
   * @return A List of comments that the user was mentioned in.
   * @throws StackAppError Thrown when there is an api error.
   */
  public static List<Comment> getMentionsForUser(long userId, AnswersForUserRequestConfiguration requestConfiguration) throws StackAppError
  {
    StackAppRequest request = new StackAppRequest(baseUrl);
    request.pushPath("users");
    request.pushPath(userId);
    request.pushPath("mentioned");

    if(requestConfiguration != null)
    {
      requestConfiguration.mergeIntoRequest(request);
    }

    return getCommentsInternal(request);
  }

  public static List<Comment> getMentionsForUser(long userId) throws StackAppError
  {
    return getMentionsForUser(userId, null);
  }

  /**
   * /users/{id}/questions   Gets question summary information for a set of users.
   *
   * @param userId The user id to get questions for.
   * @param requestConfiguration The configuration to use for this request.
   * @return A List of questions for the given user id.
   * @throws StackAppError Thrown when there is an api error.
   */
  public static List<Question> getQuestionsForUser(long userId, AnswersForUserRequestConfiguration requestConfiguration) throws StackAppError
  {
    StackAppRequest request = new StackAppRequest(baseUrl);
    request.pushPath("users");
    request.pushPath(userId);
    request.pushPath("questions");

    if(requestConfiguration != null)
    {
      requestConfiguration.mergeIntoRequest(request);
    }

    return getQuestionsInternal(request);
  }

  public static List<Question> getQuestionsForUser(long userId) throws StackAppError
  {
    return getQuestionsForUser(userId, null);
  }

  /**
   * /users/{id}/reputation  Gets information on reputation changes for a set of users.
   * 
   * @param userId The user id to get reputation for.
   * @param requestConfiguration The configuration to use for this request.
   * @return A List of rep changes.
   * @throws StackAppError Thrown when there is an api error.
   */
  public static List<RepChange> getReputationForUser(long userId, ReputationForUserRequestConfiguration requestConfiguration) throws StackAppError
  {
    StackAppRequest request = new StackAppRequest(baseUrl);
    request.pushPath("users");
    request.pushPath(userId);
    request.pushPath("reputation");

    if(requestConfiguration != null)
    {
      requestConfiguration.mergeIntoRequest(request);
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
   * /users/{id}/tags        Gets the tags that a set of users has participated in.
   *
   * @param userId The user id to get tags for.
   * @param requestConfiguration The configuration to use for this request.
   * @return A List of tags for the given user id.
   * @throws StackAppError Thrown when there is an api error.
   */
  public static List<Tag> getTagsForUser(long userId, UsersRequestConfiguration requestConfiguration) throws StackAppError
  {
    StackAppRequest request = new StackAppRequest(baseUrl);
    request.pushPath("users");
    request.pushPath(userId);
    request.pushPath("tags");

    if(requestConfiguration != null)
    {
      requestConfiguration.mergeIntoRequest(request);
    }

    return getTagsInternal(request);
  }

  public static List<Tag> getTagsForUser(long userId) throws StackAppError
  {
    return getTagsForUser(userId, null);
  }

  /**
   * /users/{id}/timeline    Gets actions a set of users have performed.
   *
   * @param userId The user id to get a timeline for.
   * @param requestConfiguration The configuration to use for this request.
   * @return A List of timeline entries.
   * @throws StackAppError Thrown when there is an api error.
   */
  public static List<UserTimeline> getTimelineForUser(long userId, UsersByIdRequestConfiguration requestConfiguration) throws StackAppError
  {
    StackAppRequest request = new StackAppRequest(baseUrl);
    request.pushPath("users");
    request.pushPath(userId);
    request.pushPath("timeline");

    if(requestConfiguration != null)
    {
      requestConfiguration.mergeIntoRequest(request);
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

  /**
   * /users/moderators       Gets all the moderators on this site.
   *
   * @param requestConfiguration The configuration to use for this request.
   * @return A List of users who are moderators.
   * @throws StackAppError Thrown when there is an api error.
   */
  public static List<User> getModerators(UsersModeratorsRequestConfiguration requestConfiguration) throws StackAppError
  {
    StackAppRequest request = new StackAppRequest(baseUrl);
    request.pushPath("users");
    request.pushPath("moderators");

    if(requestConfiguration != null)
    {
      requestConfiguration.mergeIntoRequest(request);
    }

    return getUsersInternal(request);
  }

  /**
   * StackAuth Route
   * /sites  Returns a list of all the sites in the StackExchange network.
   *
   * @return A List of APISite objects.
   * @throws StackAppError Thrown when there is an api error.
   */
  public static List<APISite> getSites() throws StackAppError
  {
    StackAppRequest request = new StackAppRequest(stackAuthBaseUrl);
    request.pushPath("sites");

    APISiteList sitesList = executeRequest(request, APISiteList.class);

    List<APISite> apiSites = new ArrayList<APISite>();

    if(sitesList != null && sitesList.getApiSites() != null)
    {
      apiSites.addAll(Arrays.asList(sitesList.getApiSites()));
    }

    return apiSites;
  }

  /**
   * StackAuth Route
   * /users/{id}/associated  Gets all the associated user accounts across the StackExchange network as identified by the given association_id.
   *
   * @param associationId The user's association id to find associated site users of.
   * @return A List of AssociatedUser objects.
   * @throws StackAppError Thrown when there is an api error.
   */
  public static List<AssociatedUser> getUserAssociations(String associationId) throws StackAppError
  {
    StackAppRequest request = new StackAppRequest(stackAuthBaseUrl);
    request.pushPath("users");
    request.pushPath(associationId);
    request.pushPath("associated");

    AssociatedUserList associatedUserList = executeRequest(request, AssociatedUserList.class);

    List<AssociatedUser> associatedUsers = new ArrayList<AssociatedUser>();

    if(associatedUserList != null && associatedUserList.getAssociatedUsers() != null)
    {
      associatedUsers.addAll(Arrays.asList(associatedUserList.getAssociatedUsers()));
    }

    return associatedUsers;
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

  private static List<Tag> getTagsInternal(StackAppRequest request)
  {
    TagList tagList = executeRequest(request, TagList.class);

    List<Tag> tags = new ArrayList<Tag>();

    if(tagList != null && tagList.getTags() != null)
    {
      tags.addAll(Arrays.asList(tagList.getTags()));
    }

    return tags;
  }
}
