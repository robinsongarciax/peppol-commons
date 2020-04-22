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
package com.helger.smpclient.bdxr2.marshal;

import com.helger.xsds.bdxr.smp2.ObjectFactory;
import com.helger.xsds.bdxr.smp2.ServiceMetadataType;

/**
 * OASIS BDXR SMP v2 ServiceMetadata marshaller
 *
 * @author Philip Helger
 */
public class BDXR2ServiceMetadataMarshaller extends AbstractBDXR2Marshaller <ServiceMetadataType>
{
  public BDXR2ServiceMetadataMarshaller ()
  {
    this (true);
  }

  public BDXR2ServiceMetadataMarshaller (final boolean bValidationEnabled)
  {
    super (ServiceMetadataType.class, bValidationEnabled, new ObjectFactory ()::createServiceMetadata);
  }
}
