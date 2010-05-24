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

import net.ioncannon.stackapps.api.response.*;
import net.ioncannon.stackapps.api.client.StackAppClient;

import java.util.List;

/**
 */
public class Test
{
  public static void main(String[] args)
  {
//    StackAppClient.setKey("<a key>");

//    Answer answer = StackAppClient.getAnswer(2491514);
//    System.err.println(answer);

//    Answer answer = StackAppClient.getAnswer(2491514, AnswerRequest.start().withBody(true));
//    System.err.println(answer);

//    List<Comment> comments = StackAppClient.getAnswerComments(2892638);
//    System.err.println(comments);

//    List<Comment> comments = StackAppClient.getAnswerComments(2892638, AnswerCommentsRequest.start().withSort("votes"));
//    System.err.println(comments);

//    List<Badge> badges = StackAppClient.getBadges();
//    System.err.println(badges);

//    List<User> users = StackAppClient.getUsersWhoHaveBadge(9);
//    System.err.println(users);

//    List<User> users = StackAppClient.getUsersWhoHaveBadge(9, UsersWhoHaveBadgeRequest.start().withPage(1));
//    System.err.println(users);

//    List<Badge> badges = StackAppClient.getNonTagBasedBadges();
//    System.err.println(badges);

//    List<Badge> badges = StackAppClient.getTagBasedBadges();
//    System.err.println(badges);

//    Comment comment = StackAppClient.getComment(2941458);
//    System.err.println(comment);

//    Comment comment = StackAppClient.getComment(2941458, CommentRequest.start().withPage(1));
//    System.err.println(comment);

//    List<Question> questions = StackAppClient.getQuestions();
//    System.err.println(questions);

//    List<Question> questions = StackAppClient.getQuestions(QuestionRequest.start().withPage(2));
//    System.err.println(questions);

//    Question question = StackAppClient.getQuestionById(2892605);
//    System.err.println(question);

//    Question question = StackAppClient.getQuestionById(2892605, QuestionByIdRequest.start().withPage(1));
//    System.err.println(question);

//    List<Answer> answers = StackAppClient.getAnswersForQuestion(2892605);
//    System.err.println(answers);

//    List<Answer> answers = StackAppClient.getAnswersForQuestion(2892605, AnswersForQuestionRequest.start().withPage(1));
//    System.err.println(answers);

//    List<PostTimeline> postTimelines = StackAppClient.getTimelineForQuestion(2892605);
//    System.err.println(postTimelines);

//    List<Comment> comments = StackAppClient.getCommentsForQuestion(2892605);
//    System.err.println(comments);

//    List<Comment> comments = StackAppClient.getCommentsForQuestion(2892605, CommentsForQuestionRequest.start().withPage(1));
//    System.err.println(comments);

//    List<Question> questions = StackAppClient.getQuestionsForTag("java");
//    System.err.println(questions);

//    List<Question> questions = StackAppClient.getQuestionsForTag("java", QuestionByIdRequest.start().withPage(2));
//    System.err.println(questions);

//    List<Question> questions = StackAppClient.getUnansweredQuestions();
//    System.err.println(questions);

//    List<Question> questions = StackAppClient.getUnansweredQuestions(QuestionRequest.start().withPage(2));
//    System.err.println(questions);

//    Stats stats = StackAppClient.getStats();
//    System.err.println(stats);

//    List<Tag> tags = StackAppClient.getTags();
//    System.err.println(tags);

//    List<Tag> tags = StackAppClient.getTags(TagsRequest.start().withPage(2));
//    System.err.println(tags);

//    List<User> users = StackAppClient.getUsers();
//    System.err.println(users);

//    List<User> users = StackAppClient.getUsers(UsersRequest.start().withFilter("carson"));
//    System.err.println(users);

//    User user = StackAppClient.getUser(25343);
//    System.err.println(user);

//    User user = StackAppClient.getUser(25343, UsersByIdRequest.start().withPage(1));
//    System.err.println(user);

//    List<Answer> answers = StackAppClient.getAnswersForUser(25343);
//    System.err.println(answers);

//    List<Answer> answers = StackAppClient.getAnswersForUser(25343, AnswersForUserRequest.start().withPage(1));
//    System.err.println(answers);

//    List<Badge> badges = StackAppClient.getBadgesForUser(25343);
//    System.err.println(badges);

//    List<Comment> comments = StackAppClient.getCommentsForUser(25343);
//    System.err.println(comments);

//    List<Comment> comments = StackAppClient.getCommentsForUser(25343, UsersByIdRequest.start().withPage(1));
//    System.err.println(comments);

//    List<Question> favorites = StackAppClient.getFavoritesForUser(25343);
//    System.err.println(favorites);

//    List<Question> favorites = StackAppClient.getFavoritesForUser(25343, AnswersForUserRequest.start().withPage(1));
//    System.err.println(favorites);

//    List<Comment> mentions = StackAppClient.getMentionsForUser(25343);
//    System.err.println(mentions);

//    List<Comment> mentions = StackAppClient.getMentionsForUser(25343, AnswersForUserRequest.start().withPage(1));
//    System.err.println(mentions);

//    List<Question> questions = StackAppClient.getQuestionsForUser(25343);
//    System.err.println(questions);

//    List<Question> questions = StackAppClient.getQuestionsForUser(25343, AnswersForUserRequest.start().withPage(1));
//    System.err.println(questions);

    List<RepChange> repChanges = StackAppClient.getReputationForUser(22656);
    System.err.println(repChanges);

//    List<RepChange> repChanges = StackAppClient.getReputationForUser(22656, ReputationForUserRequest.start().withPage(1));
//    System.err.println(repChanges);

//    List<Tag> tags = StackAppClient.getTagsForUser(25343);
//    System.err.println(tags);

//    List<Tag> tags = StackAppClient.getTagsForUser(25343, UsersRequest.start().withPage(1));
//    System.err.println(tags);

//    List<UserTimeline> userTimelines = StackAppClient.getTimelineForUser(25343);
//    System.err.println(userTimelines);

//    List<UserTimeline> userTimelines = StackAppClient.getTimelineForUser(25343, UsersByIdRequest.start().withPage(1));
//    System.err.println(userTimelines);
  }
}
