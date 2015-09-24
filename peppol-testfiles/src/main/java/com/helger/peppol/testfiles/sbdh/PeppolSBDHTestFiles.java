/**
 * Copyright (C) 2015 Philip Helger
 * philip[at]helger[dot]com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.helger.peppol.testfiles.sbdh;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nonnull;

import com.helger.commons.annotation.ReturnsMutableCopy;
import com.helger.commons.collection.CollectionHelper;
import com.helger.commons.io.resource.ClassPathResource;

/**
 * This class contains all the test resources for SBDH
 *
 * @author Philip Helger
 */
public final class PeppolSBDHTestFiles
{
  private static final List <ClassPathResource> GOOD_CASES = new ArrayList <ClassPathResource> ();
  private static final List <ClassPathResource> BAD_CASES = new ArrayList <ClassPathResource> ();

  static
  {
    // good.xml must be the first file!
    for (final String sFilename : new String [] { "good.xml",
                                                  "good-additional-scopes.xml",
                                                  "good-type-version-20.xml" })
    {
      GOOD_CASES.add (new ClassPathResource ("/sbdh/good/" + sFilename));
    }

    for (final String sFilename : new String [] { "bad-no-xml.txt",
                                                  "bad-no-sbdh.xml",
                                                  "bad-invalid-header-version.xml",
                                                  "bad-too-few-senders.xml",
                                                  "bad-too-many-senders.xml",
                                                  "bad-invalid-sender-authority.xml",
                                                  "bad-invalid-sender-value.xml",
                                                  "bad-too-few-receivers.xml",
                                                  "bad-too-many-receivers.xml",
                                                  "bad-invalid-receiver-authority.xml",
                                                  "bad-invalid-receiver-value.xml",
                                                  "bad-no-business-scope.xml",
                                                  "bad-too-few-scopes.xml",
                                                  "bad-invalid-document-type-identifier.xml",
                                                  "bad-invalid-process-identifier.xml",
                                                  "bad-no-document-type-identifier.xml",
                                                  "bad-no-process-identifier.xml",
                                                  "bad-no-business-message.xml",
                                                  "bad-invalid-business-message.xml",
                                                  "bad-invalid-standard.xml",
                                                  "bad-invalid-type-version.xml",
                                                  "bad-invalid-type.xml",
                                                  "bad-invalid-instance-identifier.xml",
                                                  "bad-invalid-creation-date-and-time.xml" })
    {
      BAD_CASES.add (new ClassPathResource ("/sbdh/bad/" + sFilename));
    }
  }

  @Nonnull
  @ReturnsMutableCopy
  public static List <ClassPathResource> getAllGoodCases ()
  {
    return CollectionHelper.newList (GOOD_CASES);
  }

  @Nonnull
  public static ClassPathResource getFirstGoodCase ()
  {
    return GOOD_CASES.get (0);
  }

  @Nonnull
  @ReturnsMutableCopy
  public static List <ClassPathResource> getAllBadCases ()
  {
    return CollectionHelper.newList (BAD_CASES);
  }

  @Nonnull
  public static ClassPathResource getFirstBadCase ()
  {
    return BAD_CASES.get (0);
  }
}