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

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import java.util.Arrays;

/**
 */

@XmlRootElement
public class RepChangeList extends StackAppResponse
{
  private long total;
  private long page;
  private long pagesize;
  private RepChange repChanges[];

  public RepChangeList()
  {
  }

  public RepChangeList(long currentRateLimit, long maxRateLimit, long total, long page, long pagesize, RepChange[] repChanges)
  {
    super(currentRateLimit, maxRateLimit);
    this.total = total;
    this.page = page;
    this.pagesize = pagesize;
    this.repChanges = repChanges;
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

  @XmlElement(name="rep_changes")
  public RepChange[] getRepChanges()
  {
    return repChanges;
  }

  public void setRepChanges(RepChange[] repChanges)
  {
    this.repChanges = repChanges;
  }

  @Override
  public String toString()
  {
    return "RepChangeList{" +
        "total=" + total +
        ", page=" + page +
        ", pagesize=" + pagesize +
        ", repChanges=" + (repChanges == null ? null : Arrays.asList(repChanges)) +
        '}';
  }
}
