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

import net.ioncannon.stackapps.api.response.Error;
import net.ioncannon.stackapps.api.client.StackAppClient;

/**
 * todo need to make javadoc task in ant build
 */
public class Test
{
  public static void main(String[] args)
  {
//    StackAppClient.setKey("<a key>");

//    Answer answer = StackAppClient.getAnswer(2491514);
//    System.err.println(answer);

//    Answer answer = StackAppClient.getAnswer(2491514, AnswerRequestConfiguration.start().withBody(true));
//    System.err.println(answer);

//    List<Comment> comments = StackAppClient.getAnswerComments(2892638);
//    System.err.println(comments);

//    List<Comment> comments = StackAppClient.getAnswerComments(2892638, AnswerCommentsRequestConfiguration.start().withSort("votes"));
//    System.err.println(comments);

//    List<Badge> badges = StackAppClient.getBadges();
//    System.err.println(badges);

//    List<User> users = StackAppClient.getUsersWhoHaveBadge(9);
//    System.err.println(users);

//    List<User> users = StackAppClient.getUsersWhoHaveBadge(9, UsersWhoHaveBadgeRequestConfiguration.start().withPage(1));
//    System.err.println(users);

//    List<Badge> badges = StackAppClient.getNonTagBasedBadges();
//    System.err.println(badges);

//    List<Badge> badges = StackAppClient.getTagBasedBadges();
//    System.err.println(badges);

//    Comment comment = StackAppClient.getComment(2941458);
//    System.err.println(comment);

//    Comment comment = StackAppClient.getComment(2941458, CommentRequestConfiguration.start().withPage(1));
//    System.err.println(comment);

    Error error = StackAppClient.getError(4002);
    System.err.println(error);

//    List<Question> questions = StackAppClient.getQuestions();
//    System.err.println(questions);

//    List<Question> questions = StackAppClient.getQuestions(QuestionRequestConfiguration.start().withPage(2));
//    System.err.println(questions);

//    Question question = StackAppClient.getQuestionById(2892605);
//    System.err.println(question);

//    Question question = StackAppClient.getQuestionById(2892605, QuestionByIdRequestConfiguration.start().withPage(1));
//    System.err.println(question);

//    List<Answer> answers = StackAppClient.getAnswersForQuestion(2892605);
//    System.err.println(answers);

//    List<Answer> answers = StackAppClient.getAnswersForQuestion(2892605, AnswersForQuestionRequest.start().withPage(1));
//    System.err.println(answers);

//    List<PostTimeline> postTimelines = StackAppClient.getTimelineForQuestion(2892605);
//    System.err.println(postTimelines);

//    List<Comment> comments = StackAppClient.getCommentsForQuestion(2892605);
//    System.err.println(comments);

//    List<Comment> comments = StackAppClient.getCommentsForQuestion(2892605, CommentsForQuestionRequestConfiguration.start().withPage(1));
//    System.err.println(comments);

//    List<Question> questions = StackAppClient.getQuestionsForTag("java");
//    System.err.println(questions);

//    List<Question> questions = StackAppClient.getQuestionsForTag("java", QuestionByIdRequestConfiguration.start().withPage(2));
//    System.err.println(questions);

//    List<Question> questions = StackAppClient.getUnansweredQuestions();
//    System.err.println(questions);

//    List<Question> questions = StackAppClient.getUnansweredQuestions(QuestionRequestConfiguration.start().withPage(2));
//    System.err.println(questions);

//    List<Revision> revisions = StackAppClient.getRevisionsById(2899207);
//    System.err.println(revisions);

//    List<Revision> revisions = StackAppClient.getRevisionsById(2899207, RevisionRequestConfigConfiguration.start().withFromDate(1000L));
//    System.err.println(revisions);

//    Revision revision = StackAppClient.getRevisionsByIdWithGuid(2899207, "a47eed38-7c34-4d15-9d8a-dfc438d76ac4");
//    System.err.println(revision);

//    Revision revision = StackAppClient.getRevisionsByIdWithGuid(2899207, "a47eed38-7c34-4d15-9d8a-dfc438d76ac4", RevisionRequestConfigConfiguration.start().withFromDate(1000L));
//    System.err.println(revision);

//    Stats stats = StackAppClient.getStats();
//    System.err.println(stats);

//    List<Tag> tags = StackAppClient.getTags();
//    System.err.println(tags);

//    List<Tag> tags = StackAppClient.getTags(TagsRequestConfiguration.start().withPage(2));
//    System.err.println(tags);

//    List<User> users = StackAppClient.getUsers();
//    System.err.println(users);

//    List<User> users = StackAppClient.getUsers(UsersRequestConfiguration.start().withFilter("carson"));
//    System.err.println(users);

//    User user = StackAppClient.getUser(25343);
//    System.err.println(user);

//    User user = StackAppClient.getUser(25343, UsersByIdRequestConfiguration.start().withPage(1));
//    System.err.println(user);

//    List<Answer> answers = StackAppClient.getAnswersForUser(25343);
//    System.err.println(answers);

//    List<Answer> answers = StackAppClient.getAnswersForUser(25343, AnswersForUserRequestConfiguration.start().withPage(1));
//    System.err.println(answers);

//    List<Badge> badges = StackAppClient.getBadgesForUser(25343);
//    System.err.println(badges);

//    List<Comment> comments = StackAppClient.getCommentsForUser(25343);
//    System.err.println(comments);

//    List<Comment> comments = StackAppClient.getCommentsForUser(25343, UsersByIdRequestConfiguration.start().withPage(1));
//    System.err.println(comments);

//    List<Comment> comments = StackAppClient.getCommentsForUserThatMentionUser(23354, 22656);
//    System.err.println(comments);

//    List<Comment> comments = StackAppClient.getCommentsForUserThatMentionUser(23354, 22656, UsersByIdRequestConfiguration.start().withPage(1));
//    System.err.println(comments);

//    List<Question> favorites = StackAppClient.getFavoritesForUser(25343);
//    System.err.println(favorites);

//    List<Question> favorites = StackAppClient.getFavoritesForUser(25343, AnswersForUserRequestConfiguration.start().withPage(1));
//    System.err.println(favorites);

//    List<Comment> mentions = StackAppClient.getMentionsForUser(25343);
//    System.err.println(mentions);

//    List<Comment> mentions = StackAppClient.getMentionsForUser(25343, AnswersForUserRequestConfiguration.start().withPage(1));
//    System.err.println(mentions);

//    List<Question> questions = StackAppClient.getQuestionsForUser(25343);
//    System.err.println(questions);

//    List<Question> questions = StackAppClient.getQuestionsForUser(25343, AnswersForUserRequestConfiguration.start().withPage(1));
//    System.err.println(questions);

//    List<RepChange> repChanges = StackAppClient.getReputationForUser(22656);
//    System.err.println(repChanges);

//    List<RepChange> repChanges = StackAppClient.getReputationForUser(22656, ReputationForUserRequestConfiguration.start().withPage(1));
//    System.err.println(repChanges);

//    List<Tag> tags = StackAppClient.getTagsForUser(25343);
//    System.err.println(tags);

//    List<Tag> tags = StackAppClient.getTagsForUser(25343, UsersRequestConfiguration.start().withPage(1));
//    System.err.println(tags);

//    List<UserTimeline> userTimelines = StackAppClient.getTimelineForUser(25343);
//    System.err.println(userTimelines);

//    List<UserTimeline> userTimelines = StackAppClient.getTimelineForUser(25343, UsersByIdRequestConfiguration.start().withPage(1));
//    System.err.println(userTimelines);
  }
}
