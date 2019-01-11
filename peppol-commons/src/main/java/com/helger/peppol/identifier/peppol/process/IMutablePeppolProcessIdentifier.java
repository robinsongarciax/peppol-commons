/**
 * Copyright (C) 2015-2019 Philip Helger (www.helger.com)
 * philip[at]helger[dot]com
 *
 * The Original Code is Copyright The PEPPOL project (http://www.peppol.eu)
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.helger.peppol.identifier.peppol.process;

import com.helger.peppol.identifier.generic.process.IMutableProcessIdentifier;
import com.helger.peppol.identifier.peppol.IMutablePeppolIdentifier;

/**
 * Base interface for a PEPPOL process identifier.
 * 
 * @author Philip Helger
 */
public interface IMutablePeppolProcessIdentifier extends
                                                 IPeppolProcessIdentifier,
                                                 IMutablePeppolIdentifier,
                                                 IMutableProcessIdentifier
{
  /* empty */
}
