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
