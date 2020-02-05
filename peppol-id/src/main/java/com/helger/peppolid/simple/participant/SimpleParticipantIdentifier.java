/**
 * Copyright (C) 2015-2020 Philip Helger
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
package com.helger.peppolid.simple.participant;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

import com.helger.commons.annotation.DevelopersNote;
import com.helger.commons.annotation.ReturnsMutableCopy;
import com.helger.commons.compare.CompareHelper;
import com.helger.commons.lang.ICloneable;
import com.helger.peppolid.IMutableIdentifier;
import com.helger.peppolid.IParticipantIdentifier;
import com.helger.peppolid.ParticipantIdentifierType;

/**
 * This is a sanity class around the {@link ParticipantIdentifierType} class
 * with easier construction and some sanity access methods. It may be used in
 * all places where {@link ParticipantIdentifierType} objects are required.
 *
 * @author Philip Helger
 */
@NotThreadSafe
public class SimpleParticipantIdentifier extends ParticipantIdentifierType implements
                                         IParticipantIdentifier,
                                         IMutableIdentifier,
                                         Comparable <SimpleParticipantIdentifier>,
                                         ICloneable <SimpleParticipantIdentifier>
{
  @DevelopersNote ("Don't invoke manually. Always use the IdentifierFactory!")
  public SimpleParticipantIdentifier (@Nonnull final IParticipantIdentifier aIdentifier)
  {
    this (aIdentifier.getScheme (), aIdentifier.getValue ());
  }

  @DevelopersNote ("Don't invoke manually. Always use the IdentifierFactory!")
  public SimpleParticipantIdentifier (@Nullable final String sScheme, @Nonnull final String sValue)
  {
    setScheme (sScheme);
    setValue (sValue);
  }

  public int compareTo (@Nonnull final SimpleParticipantIdentifier aOther)
  {
    int ret = CompareHelper.compare (getScheme (), aOther.getScheme ());
    if (ret == 0)
      ret = CompareHelper.compare (getValue (), aOther.getValue ());
    return ret;
  }

  @Nonnull
  @ReturnsMutableCopy
  public SimpleParticipantIdentifier getClone ()
  {
    return new SimpleParticipantIdentifier (this);
  }

  @Nonnull
  public static SimpleParticipantIdentifier wrap (@Nonnull final com.helger.peppolid.ParticipantIdentifierType aID)
  {
    return new SimpleParticipantIdentifier (aID.getScheme (), aID.getValue ());
  }

  @Nonnull
  public static SimpleParticipantIdentifier wrap (@Nonnull final com.helger.xsds.bdxr.smp1.ParticipantIdentifierType aID)
  {
    return new SimpleParticipantIdentifier (aID.getScheme (), aID.getValue ());
  }

  @Nonnull
  public static SimpleParticipantIdentifier wrap (@Nonnull final com.helger.xsds.ccts.cct.schemamodule.IdentifierType aID)
  {
    return new SimpleParticipantIdentifier (aID.getSchemeID (), aID.getValue ());
  }
}
