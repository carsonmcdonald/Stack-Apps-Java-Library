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
public class UsersModeratorsRequestConfiguration extends BaseRequestConfiguration
{
  public static UsersModeratorsRequestConfiguration start()
  {
    return new UsersModeratorsRequestConfiguration();
  }

  /**
   * fromdate (optional)
   * <p/>
   * Unix timestamp of the minimum creation date on a returned item.
   *
   * @param fromDate The starting date.
   * @return The current configuration.
   */
  public UsersModeratorsRequestConfiguration withFromDate(Long fromDate)
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
  public UsersModeratorsRequestConfiguration withToDate(Long toDate)
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
  public UsersModeratorsRequestConfiguration withPage(Integer page)
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
  public UsersModeratorsRequestConfiguration withPageSize(Integer pageSize)
  {
    stackAppRequest.addQueryPart("pagesize", pageSize);
    return this;
  }

  /**
   * filter (optional)
   * <p/>
   * String that must appear in returned users' names
   *
   * @param filter The filter to apply.
   * @return The current configuration.
   */
  public UsersModeratorsRequestConfiguration withFilter(String filter)
  {
    stackAppRequest.addQueryPart("filter", filter);
    return this;
  }

  /**
   * max (optional)
   * <p/>
   * Maximum of the range to include in the current sort.
   *
   * @param max The maximum value of the sort range.
   * @return The current configuration.
   */
  public UsersModeratorsRequestConfiguration withMax(String max)
  {
    stackAppRequest.addQueryPart("max", max);
    return this;
  }

  /**
   * min (optional)
   * <p/>
   * Minimum of the range to include in the current sort.
   *
   * @param min The minimum value of the sort range.
   * @return The current configuration.
   */
  public UsersModeratorsRequestConfiguration withMin(String min)
  {
    stackAppRequest.addQueryPart("min", min);
    return this;
  }

  /**
   * order (optional)
   * <p/>
   * How the current sort should be ordered.
   *
   * @param order The order of the sort.
   * @return The current configuration.
   */
  public UsersModeratorsRequestConfiguration withOrder(String order)
  {
    stackAppRequest.addQueryPart("order", order);
    return this;
  }

  /**
   * sort (optional)
   * <p/>
   * How a collection should be sorted.
   * one of reputation (default), creation, or name
   *
   * @param sort One of reputation, creation, or name
   * @return The current configuration.
   */
  public UsersModeratorsRequestConfiguration withSort(String sort)
  {
    stackAppRequest.addQueryPart("sort", sort);
    return this;
  }
}