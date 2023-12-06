/*
 * Copyright (C) 2023 Philip Helger
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
package com.helger.peppol.mlr;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.helger.commons.string.StringHelper;

/**
 * Test class for class {@link EPeppolMLRState}.
 *
 * @author Philip Helger
 */
public final class EPeppolMLRStateTest
{
  @Test
  public void testBasic ()
  {
    for (final EPeppolMLRState e : EPeppolMLRState.values ())
    {
      assertTrue (StringHelper.hasText (e.getID ()));
      assertTrue (e.isSuccess () || e.isFailure ());
      assertFalse (e.isSuccess () && e.isFailure ());
      assertSame (e, EPeppolMLRState.getFromIDOrNull (e.getID ()));
    }
  }
}
