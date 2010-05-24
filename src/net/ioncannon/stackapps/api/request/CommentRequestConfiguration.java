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

package net.ioncannon.stackapps.api.request;

/**
 */
public class CommentRequestConfiguration extends BaseRequestConfiguration
{
  public static CommentRequestConfiguration start()
  {
    return new CommentRequestConfiguration();
  }

  /**
   * sort (optional)
   * <p/>
   * How a collection should be sorted. Various values include "active", "creation", "views", "votes".
   * one of activity (default), views, creation, or votes
   *
   * @param sort The way the answers should be sorted
   * @return The current configuration.
   */
  public CommentRequestConfiguration withSort(String sort)
  {
    stackAppRequest.addQueryPart("sort", sort);
    return this;
  }

  /**
   * order (optional)
   * <p/>
   * How the current sort should be ordered, either "asc" or "desc". Default is "desc".
   * one of desc (default), or asc
   *
   * @param order The order of the sort if used
   * @return The current configuration.
   */
  public CommentRequestConfiguration withOrder(String order)
  {
    stackAppRequest.addQueryPart("order", order);
    return this;
  }

  /**
   * min (optional)
   * <p/>
   * Minimum of the range to include in the response according to the current sort.
   *
   * @param min The starting range of the sort
   * @return The current configuration.
   */
  public CommentRequestConfiguration withMin(Integer min)
  {
    stackAppRequest.addQueryPart("min", min);
    return this;
  }

  /**
   * max (optional)
   * <p/>
   * Maximum of the range to include in the response according to the current sort.
   *
   * @param max The max range of the sort.
   * @return The current configuration.
   */
  public CommentRequestConfiguration withMax(Integer max)
  {
    stackAppRequest.addQueryPart("max", max);
    return this;
  }

  /**
   * fromdate (optional)
   * <p/>
   * Unix timestamp of the minimum creation date on a returned item.
   *
   * @param fromDate The starting date.
   * @return The current configuration.
   */
  public CommentRequestConfiguration withFromDate(Long fromDate)
  {
    stackAppRequest.addQueryPart("fromdate", fromDate);
    return this;
  }

  /**
   * todate (optional)
   * <p/>
   * Unix timestamp of the maximum creation date on a returned item.
   *
   * @param toDate The ending date.
   * @return The current configuration.
   */
  public CommentRequestConfiguration withToDate(Long toDate)
  {
    stackAppRequest.addQueryPart("todate", toDate);
    return this;
  }

  /**
   * page (optional)
   * <p/>
   * The pagination offset for the current collection. Affected by the specified pagesize.
   *
   * @param page The current page
   * @return The current configuration.
   */
  public CommentRequestConfiguration withPage(Integer page)
  {
    stackAppRequest.addQueryPart("page", page);
    return this;
  }

  /**
   * pagesize (optional)
   * <p/>
   * The number of collection results to display during pagination. Should be between 1 and 100 inclusive.
   *
   * @param pageSize The size of the page to return.
   * @return The current configuration.
   */
  public CommentRequestConfiguration withPageSize(Integer pageSize)
  {
    stackAppRequest.addQueryPart("pagesize", pageSize);
    return this;
  }
}
