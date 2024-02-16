package com.helger.smpclient.url;

import java.nio.charset.StandardCharsets;

import org.xbill.DNS.Lookup;
import org.xbill.DNS.Record;
import org.xbill.DNS.SimpleResolver;
import org.xbill.DNS.Type;
import org.xbill.DNS.dnssec.ValidatingResolver;

import com.helger.commons.io.stream.NonBlockingByteArrayInputStream;

public class MainDNSSecValidationTest
{
  private static byte [] ROOT = ". IN DS 20326 8 2 E06D44B80B8F1D39A95C0B0D7C65D08458E880409BBC683457104237C7F8EC8D".getBytes (StandardCharsets.US_ASCII);

  public static void main (final String [] args) throws Exception
  {
    final SimpleResolver recursiveNameServer = new SimpleResolver ();

    final ValidatingResolver securityAwareResolver = new ValidatingResolver (recursiveNameServer);
    securityAwareResolver.loadTrustAnchors (new NonBlockingByteArrayInputStream (ROOT));

    final Lookup lookup = new Lookup ("B-85008b8279e07ab0392da75fa55856a2.iso6523-actorid-upis.acc.edelivery.tech.ec.europa.eu",
                                      Type.CNAME);
    lookup.setResolver (securityAwareResolver);

    final Record [] records = lookup.run ();

    final int result = lookup.getResult ();
    if (result != Lookup.SUCCESSFUL)
    {
      System.out.println ("Failure: " + result);
    }
    else
    {
      System.out.println ("Success: " + records.length + " records");
    }

    if (records != null)
      for (final Record r : records)
        System.out.println (r.toString ());
  }
}
