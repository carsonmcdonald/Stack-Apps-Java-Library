package net.ioncannon.stackapps.api.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;

/**
 */

@XmlRootElement
public class AnswerList extends StackAppResponse
{
  private long total;
  private long page;
  private long pagesize;
  private Answer answers[];

  public AnswerList()
  {
    super();
  }

  public AnswerList(long currentRateLimit, long maxRateLimit, long total, long page, long pagesize, Answer[] answers)
  {
    super(currentRateLimit, maxRateLimit);
    this.total = total;
    this.page = page;
    this.pagesize = pagesize;
    this.answers = answers;
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

  public Answer[] getAnswers()
  {
    return answers;
  }

  public void setAnswers(Answer[] answers)
  {
    this.answers = answers;
  }

  @Override
  public String toString()
  {
    return "AnswerList(" + getMaxRateLimit() + "/" + getCurrentRateLimit() + "){" +
        "total=" + total +
        ", page=" + page +
        ", pagesize=" + pagesize +
        ", answers=" + (answers == null ? null : Arrays.asList(answers)) +
        '}';
  }
}
