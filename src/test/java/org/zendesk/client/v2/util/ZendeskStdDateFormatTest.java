package org.zendesk.client.v2.util;

import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;

import static org.junit.Assert.assertNotNull;

/**
 * Tests {@link ZendeskStdDateFormat}.
 *
 * @author Johno Crawford (johno@sulake.com)
 */
public class ZendeskStdDateFormatTest {

    private ZendeskStdDateFormat zendeskStdDateFormat;

    @Before
    public void setUp() throws Exception {
        zendeskStdDateFormat = new ZendeskStdDateFormat();
    }

    @Test
    public void parseStandardDate() throws Exception {
        assertNotNull(zendeskStdDateFormat.parse("2012-04-04T09:14:57Z"));
    }

    @Test
    public void parseZendeskExportDate() throws Exception {
        assertNotNull(zendeskStdDateFormat.parse("2014-01-27 16:58:10 +0200"));
    }

    @Test(expected = ParseException.class)
    public void parseInvalidDate() throws Exception {
        zendeskStdDateFormat.parse("invalid");
    }
}
