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
package com.helger.smpclient.url;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * New checked exception to be thrown if DNS resolution fails.
 *
 * @author Philip Helger
 * @since 6.2.0
 * @deprecated since 8.2.0; Use {@link SMPDNSResolutionException} instead. This
 *             intermediate class will be dropped for the next major release.
 */
@Deprecated
public class PeppolDNSResolutionException extends Exception
{
  public PeppolDNSResolutionException (@Nonnull final String sMessage)
  {
    super (sMessage);
  }

  public PeppolDNSResolutionException (@Nonnull final String sMessage, @Nullable final Throwable aCause)
  {
    super (sMessage, aCause);
  }
}
