#Introduction
This project contains different libraries that are commonly used in the PEPPOL area:
  * `peppol-commons` - the most basic data structures for use with PEPPOL
  * `peppol-testfiles` - a set of UBL and SBDH test files
  * `peppol-bdxr` - data structures for the OASIS BDXR specification
  * `peppol-sbdh` - PEPPOL specific SBDH handling
  * `peppol-sml-client` - the PEPPOL SML client
  
These project are used implicitly by the following projects:
  * [peppol-smp-client](https://github.com/phax/peppol-smp-client/) - the SMP client library
  * [peppol-smp-server](https://github.com/phax/peppol-smp-server/) - the SMP server with a management GUI
  * [as2-peppol-client](https://github.com/phax/as2-peppol-client/) - the AP client library
  * [as2-peppol-server](https://github.com/phax/as2-peppol-server/) - the AP server stub
  * [peppol-lime](https://github.com/phax/peppol-lime/) - the LIME server with AS2 support
  * [peppol-yellow-pages](https://github.com/phax/peppol-yellow-pages/) - the PEPPOL Yellow Pages development draft

Note: the sub-projects use different licenses!

##peppol-commons
Java library with shared PEPPOL components. It contains the basic algorithms and the handling for the identifiers.

This is based on the cipa-commons-busdox and cipa-peppol-types project version 2.2.3 but without the support for the START protocol.

Versions <= 3.1.3 are compatible with ph-commons < 6.0.
Versions >= 4.0.0 are compatible with ph-commons >= 6.0.

This project is licensed under EUPL 1.1 or MPL 1.1 - like CIPA e-Delivery.

##peppol-sbdh
Simple SBDH handler for the use with PEPPOL.
It offers the possibility to extract all meta data from an SBDH document as well as 
set all meta data to an SBDH document.

This projects implements the "Envelope specification" as listed on
http://www.peppol.eu/ressource-library/technical-specifications/transport-infrastructure/infrastructure-resources.
The detail document this project refers to can be found at
https://joinup.ec.europa.eu/svn/peppol/TransportInfrastructure/ICT-Transport-OpenPEPPOL-Envelope_Specification-100_2014-01-15.pdf

From a technical point of view, this library can be used with Java 1.6 or higher.

An example on how to use this project can be found in my **[as2-peppol-servlet](https://github.com/phax/as2-peppol-servlet)** project which provides a servlet to receive incoming PEPPOL AS2 messages. Alternatively you may have a look at my **[as2-peppol-client](https://github.com/phax/as2-peppol-client)** project which is used to send PEPPOL AS2 messages.

Versions <= 1.0.1 are compatible with ph-commons < 6.0.
Versions >= 2.0.0 are compatible with ph-commons >= 6.0.

This project is licensed under the Apache 2 License.

##peppol-testfiles
A Java library with a lot of UBL and SBDH test files suitable for different scenarios.  

This project is licensed under the Apache 2 License.

##peppol-bdxr
A Java library with the JAXB generated content of the OASIS BDXR specification.  

This project is licensed under the Apache 2 License.

## peppol-sml-client
This project contains the SML client library used by the SMP's to interact with the SML.
It is based on cipa-sml-client-library 2.2.3.
This library is usually only used within SMP servers, to communicate the changes to the central SML.

This project contains 2 main classes for talking to the PEPPOL SML:
  * `ManageServiceMetadataServiceCaller` which is used to change SMP assignments in the SML. This must be called for a new SMP to register it once at the SML.
  * `ManageParticipantIdentifierServiceCaller` which is used to manage the assignment of participants to SMPs. This must be invoked from the SMP server every time a new participant is registered (or an existing one is modified or deleted).
  
Both classes offer the possibility to set an optional custom `SSLSocketFactory` as well as a custom optional `HostnameVerifier`. The implementation of this is in the base class `AbstractSMLClientCaller`.

This project is used by [peppol-smp-server](https://github.com/phax/peppol-smp-server/) the SMP server with a management GUI and flexible backends.

This project is licensed under EUPL 1.1 or MPL 1.1 - like CIPA e-Delivery.

Versions <= 3.1.3 are compatible with ph-commons < 6.0.
Versions >= 4.0.0 are compatible with ph-commons >= 6.0.

#Building from source
This project is meant to be build by Maven 3.x.
It requires at least Java 1.6 to be build.
To build simply call `mvn clean install` in the root folder.

#Maven usage
Add the following to your pom.xml to use this artifact:
```
<dependency>
  <groupId>com.helger</groupId>
  <artifactId>peppol-commons</artifactId>
  <version>4.2.1</version>
</dependency>

<dependency>
  <groupId>com.helger</groupId>
  <artifactId>peppol-testfiles</artifactId>
  <version>4.2.1</version>
</dependency>

<dependency>
  <groupId>com.helger</groupId>
  <artifactId>peppol-bdxr</artifactId>
  <version>4.2.1</version>
</dependency>

<dependency>
  <groupId>com.helger</groupId>
  <artifactId>peppol-sbdh</artifactId>
  <version>4.2.1</version>
</dependency>

<dependency>
  <groupId>com.helger</groupId>
  <artifactId>peppol-sml-client</artifactId>
  <version>4.2.1</version>
</dependency>

```

---

On Twitter: <a href="https://twitter.com/philiphelger">Follow @philiphelger</a>
