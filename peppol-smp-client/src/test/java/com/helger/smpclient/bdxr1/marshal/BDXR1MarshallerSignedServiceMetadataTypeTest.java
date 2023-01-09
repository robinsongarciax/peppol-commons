/*
 * Copyright (C) 2015-2023 Philip Helger
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
package com.helger.smpclient.bdxr1.marshal;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.helger.xsds.bdxr.smp1.SignedServiceMetadataType;

/**
 * Test class for class {@link BDXR1MarshallerSignedServiceMetadataType}
 *
 * @author Philip Helger
 */
public class BDXR1MarshallerSignedServiceMetadataTypeTest
{
  @Test
  public void testIssue121 ()
  {
    final String s = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n" +
                     "<SignedServiceMetadata\r\n" +
                     "  xmlns=\"http://docs.oasis-open.org/bdxr/ns/SMP/2016/05\"\r\n" +
                     "  xmlns:ds=\"http://www.w3.org/2000/09/xmldsig#\">\r\n" +
                     "  <ServiceMetadata>\r\n" +
                     "    <ServiceInformation>\r\n" +
                     "      <ParticipantIdentifier scheme=\"iso6523-actorid-upis\">0106:{KvK}</ParticipantIdentifier>\r\n" +
                     "      <DocumentIdentifier scheme=\"busdox-docid-qns\">urn:oasis:names:specification:ubl:schema:xsd:Invoice-2::Invoice##urn:www.cenbii.eu:transaction:biicoretrdm010:ver1.0:extended:urn:www.peppol.eu:bis:peppol4a:ver1.0::2.0</DocumentIdentifier>\r\n" +
                     "      <ProcessList>\r\n" +
                     "        <Process>\r\n" +
                     "          <ProcessIdentifier scheme=\"cenbii-procid-ubl\">urn:www.cenbii.eu:profile:bii04:ver1.0</ProcessIdentifier>\r\n" +
                     "          <ServiceEndpointList>\r\n" +
                     "            <Endpoint transportProfile=\"busdox-transport-as2-ver1p0\">\r\n" +
                     "              <EndpointURI>https://example.org/as2</EndpointURI>\r\n" +
                     "              <RequireBusinessLevelSignature>true</RequireBusinessLevelSignature>\r\n" +
                     "                <ServiceActivationDate>\r\n" +
                     "                  2019-01-16T01:00:00.000+01:00\r\n" +
                     "                </ServiceActivationDate>\r\n" +
                     "                <ServiceExpirationDate>\r\n" +
                     "                  2026-03-15T01:00:00.000+01:00\r\n" +
                     "                </ServiceExpirationDate>\r\n" +
                     "              <Certificate>SGFsbG8=</Certificate>\r\n" +
                     "              <ServiceDescription>test</ServiceDescription>\r\n" +
                     "              <TechnicalContactUrl>https://sitename.com</TechnicalContactUrl>\r\n" +
                     "              <TechnicalInformationUrl>https://sitename.com</TechnicalInformationUrl>\r\n" +
                     "            </Endpoint>\r\n" +
                     "          </ServiceEndpointList>\r\n" +
                     "        </Process>\r\n" +
                     "      </ProcessList>\r\n" +
                     "    </ServiceInformation>\r\n" +
                     "  </ServiceMetadata>\r\n" +
                     // Parsing would fail in Signature
                     "  <ds:Signature/>\r\n" +
                     "</SignedServiceMetadata>";
    final SignedServiceMetadataType aObj = new BDXR1MarshallerSignedServiceMetadataType (false).read (s);
    assertNotNull (aObj);
  }
}
