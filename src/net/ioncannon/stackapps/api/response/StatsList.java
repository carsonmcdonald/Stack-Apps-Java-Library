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
 *
 * http://api.stackoverflow.com/[version]/help/method?method=stats
 */

@XmlRootElement
public class StatsList extends StackAppResponse
{
  private Stats stats[];

  public StatsList()
  {
  }

  public StatsList(Stats[] stats)
  {
    this.stats = stats;
  }

  @XmlElement(name="statistics")
  public Stats[] getStats()
  {
    return stats;
  }

  public void setStats(Stats[] stats)
  {
    this.stats = stats;
  }

  @Override
  public String toString()
  {
    return "net.ioncannon.stackapps.api.response.StatsList{" +
        "stats=" + (stats == null ? null : Arrays.asList(stats)) +
        '}';
  }
}
