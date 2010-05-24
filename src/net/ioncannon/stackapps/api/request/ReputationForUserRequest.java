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
public class ReputationForUserRequest extends BaseRequest
{
  public static ReputationForUserRequest start()
  {
    return new ReputationForUserRequest();
  }

/**
fromdate (optional)

    * Unix timestamp of the minimum creation date on a returned item.
    * number
    */
  public ReputationForUserRequest withFromDate(Long fromDate)
  {
    stackAppRequest.addQueryPart("fromdate", fromDate);
    return this;
  }

/**
todate (optional)

    * Unix timestamp of the maximum creation date on a returned item.
    * number
    */
  public ReputationForUserRequest withToDate(Long toDate)
  {
    stackAppRequest.addQueryPart("todate", toDate);
    return this;
  }

/**
page (optional)

    * The pagination offset for the current collection. Affected by the specified pagesize.
    * number
    */
  public ReputationForUserRequest withPage(Integer page)
  {
    stackAppRequest.addQueryPart("page", page);
    return this;
  }

/**
pagesize (optional)

    * The number of collection results to display during pagination. Should be between 1 and 100 inclusive.
    * number
    */
  public ReputationForUserRequest withPageSize(Integer pageSize)
  {
    stackAppRequest.addQueryPart("pagesize", pageSize);
    return this;
  }
}
