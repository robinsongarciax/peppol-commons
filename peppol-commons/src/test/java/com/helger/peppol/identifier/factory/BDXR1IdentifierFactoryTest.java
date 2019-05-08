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
package com.helger.peppol.identifier.factory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.helger.peppol.identifier.IDocumentTypeIdentifier;
import com.helger.peppol.identifier.IParticipantIdentifier;
import com.helger.peppol.identifier.IProcessIdentifier;
import com.helger.peppol.identifier.bdxr.smp1.CBDXR1Identifier;
import com.helger.peppol.identifier.peppol.PeppolIdentifierHelper;

/**
 * Test class for class {@link BDXR1IdentifierFactory}.
 *
 * @author Philip Helger
 */
public final class BDXR1IdentifierFactoryTest
{
  @Test
  public void testDocTypeIDCreation ()
  {
    final BDXR1IdentifierFactory aIF = BDXR1IdentifierFactory.INSTANCE;
    assertNotNull (aIF.createDocumentTypeIdentifier (null, null));
    assertNotNull (aIF.createDocumentTypeIdentifier (null, "any"));
    assertNotNull (aIF.createDocumentTypeIdentifier (null, ""));
    assertNotNull (aIF.createDocumentTypeIdentifier ("", ""));
    assertNull (aIF.createDocumentTypeIdentifier ("bla::#:///:::#", null));
  }

  @Test
  public void testProcessIDCreation ()
  {
    final BDXR1IdentifierFactory aIF = BDXR1IdentifierFactory.INSTANCE;
    assertNotNull (aIF.createProcessIdentifier (null, null));
    assertNotNull (aIF.createProcessIdentifier (null, "any"));
    assertNotNull (aIF.createProcessIdentifier (null, ""));
    assertNotNull (aIF.createProcessIdentifier ("", ""));
    assertNotNull (aIF.createProcessIdentifier ("bla::#:///:::#", null));
  }

  @Test
  public void testParticipantIDCreation ()
  {
    final BDXR1IdentifierFactory aIF = BDXR1IdentifierFactory.INSTANCE;
    assertNotNull (aIF.createParticipantIdentifier (null, null));
    assertNotNull (aIF.createParticipantIdentifier (null, "any"));
    assertNotNull (aIF.createParticipantIdentifier (null, ""));
    assertNotNull (aIF.createParticipantIdentifier ("", ""));
    assertNull (aIF.createParticipantIdentifier ("bla::#:///:::#", null));
  }

  @Test
  public void testParticipantIDCaseInsensitive ()
  {
    final BDXR1IdentifierFactory aIF = BDXR1IdentifierFactory.INSTANCE;
    final String sScheme = PeppolIdentifierHelper.DEFAULT_PARTICIPANT_SCHEME;
    final IParticipantIdentifier aID1 = aIF.createParticipantIdentifier (sScheme, "abc");
    assertEquals (sScheme, aID1.getScheme ());
    assertEquals ("abc", aID1.getValue ());

    // Value is lower cased internally
    final IParticipantIdentifier aID2 = aIF.createParticipantIdentifier (sScheme, "ABC");
    assertEquals (sScheme, aID2.getScheme ());
    assertEquals ("abc", aID2.getValue ());
    assertTrue (aID1.hasSameContent (aID2));
  }

  @Test
  public void testParticipantIDCaseSensitive ()
  {
    final BDXR1IdentifierFactory aIF = BDXR1IdentifierFactory.INSTANCE;
    final String sScheme = "cs-actorid-upis";
    final IParticipantIdentifier aID1 = aIF.createParticipantIdentifier (sScheme, "abc");
    assertEquals (sScheme, aID1.getScheme ());
    assertEquals ("abc", aID1.getValue ());

    // Value is NOT lower cased internally
    final IParticipantIdentifier aID2 = aIF.createParticipantIdentifier (sScheme, "ABC");
    assertEquals (sScheme, aID2.getScheme ());
    assertEquals ("ABC", aID2.getValue ());
    assertFalse (aID1.hasSameContent (aID2));
  }

  @Test
  public void testDocTypeIDCaseInsensitive ()
  {
    final BDXR1IdentifierFactory aIF = BDXR1IdentifierFactory.INSTANCE;
    final String sScheme = CBDXR1Identifier.DEFAULT_DOCUMENT_TYPE_IDENTIFIER_SCHEME;
    final IDocumentTypeIdentifier aID1 = aIF.createDocumentTypeIdentifier (sScheme, "abc");
    assertEquals (sScheme, aID1.getScheme ());
    assertEquals ("abc", aID1.getValue ());

    // Value is lower cased internally
    final IDocumentTypeIdentifier aID2 = aIF.createDocumentTypeIdentifier (sScheme, "ABC");
    assertEquals (sScheme, aID2.getScheme ());
    assertEquals ("abc", aID2.getValue ());
    assertTrue (aID1.hasSameContent (aID2));
  }

  @Test
  public void testDocTypeIDCaseSensitive ()
  {
    final BDXR1IdentifierFactory aIF = BDXR1IdentifierFactory.INSTANCE;
    // Different scheme - handle case sensitive
    final String sScheme = "cs-doctype-scheme";
    final IDocumentTypeIdentifier aID1 = aIF.createDocumentTypeIdentifier (sScheme, "abc");
    assertEquals (sScheme, aID1.getScheme ());
    assertEquals ("abc", aID1.getValue ());

    // Value is NOT lower cased internally
    final IDocumentTypeIdentifier aID2 = aIF.createDocumentTypeIdentifier (sScheme, "ABC");
    assertEquals (sScheme, aID2.getScheme ());
    assertEquals ("ABC", aID2.getValue ());
    assertFalse (aID1.hasSameContent (aID2));
  }

  @Test
  public void testProcessIDCaseInsensitive ()
  {
    final BDXR1IdentifierFactory aIF = BDXR1IdentifierFactory.INSTANCE;
    // Default scheme - handle case insensitive
    final String sScheme = CBDXR1Identifier.DEFAULT_PROCESS_IDENTIFIER_SCHEME;
    final IProcessIdentifier aID1 = aIF.createProcessIdentifier (sScheme, "abc");
    assertEquals (sScheme, aID1.getScheme ());
    assertEquals ("abc", aID1.getValue ());

    // Value is lower cased internally
    final IProcessIdentifier aID2 = aIF.createProcessIdentifier (sScheme, "ABC");
    assertEquals (sScheme, aID2.getScheme ());
    assertEquals ("abc", aID2.getValue ());
    assertTrue (aID1.hasSameContent (aID2));
  }

  @Test
  public void testProcessIDCaseSensitive ()
  {
    final BDXR1IdentifierFactory aIF = BDXR1IdentifierFactory.INSTANCE;
    // Different scheme - handle case sensitive
    final String sScheme = "cs-docid-qns";
    final IProcessIdentifier aID1 = aIF.createProcessIdentifier (sScheme, "abc");
    assertEquals (sScheme, aID1.getScheme ());
    assertEquals ("abc", aID1.getValue ());

    // Value is NOT lower cased internally
    final IProcessIdentifier aID2 = aIF.createProcessIdentifier (sScheme, "ABC");
    assertEquals (sScheme, aID2.getScheme ());
    assertEquals ("ABC", aID2.getValue ());
    assertFalse (aID1.hasSameContent (aID2));
  }
}