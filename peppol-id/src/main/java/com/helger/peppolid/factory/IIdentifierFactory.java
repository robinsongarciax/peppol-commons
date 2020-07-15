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
package com.helger.peppolid.factory;

/**
 * A generic factory interface that allows to easily switch between default
 * identifiers (<code>Simple...Identifier</code>), Peppol identifiers (
 * <code>Peppol...Identifier</code>) and BDXR identifiers (
 * <code>BDXR...Identifier</code>).
 *
 * @author Philip Helger
 */
public interface IIdentifierFactory extends IDocumentTypeIdentifierFactory, IParticipantIdentifierFactory, IProcessIdentifierFactory
{
  /* empty */
}
