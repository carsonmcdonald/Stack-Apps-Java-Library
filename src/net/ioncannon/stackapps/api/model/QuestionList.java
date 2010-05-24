package net.ioncannon.stackapps.api.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;

/**
 *
 * http://api.stackoverflow.com/0.8/help/method?method=questions
 * http://api.stackoverflow.com/0.8/help/method?method=questions/{id}
 *
 */

@XmlRootElement
public class QuestionList extends StackAppResponse
{
  private long total;
  private long page;
  private long pagesize;
  private Question questions[];

  public QuestionList()
  {
  }

  public QuestionList(long total, long page, long pagesize, Question[] questions)
  {
    this.total = total;
    this.page = page;
    this.pagesize = pagesize;
    this.questions = questions;
  }

  public long getTotal()
  {
    return total;
  }

  public void setTotal(long total)
  {
    this.total = total;
  }

  public long getPage()
  {
    return page;
  }

  public void setPage(long page)
  {
    this.page = page;
  }

  public long getPagesize()
  {
    return pagesize;
  }

  public void setPagesize(long pagesize)
  {
    this.pagesize = pagesize;
  }

  public Question[] getQuestions()
  {
    return questions;
  }

  public void setQuestions(Question[] questions)
  {
    this.questions = questions;
  }

  @Override
  public String toString()
  {
    return "QuestionList{" +
        "total=" + total +
        ", page=" + page +
        ", pagesize=" + pagesize +
        ", questions=" + (questions == null ? null : Arrays.asList(questions)) +
        '}';
  }
}
