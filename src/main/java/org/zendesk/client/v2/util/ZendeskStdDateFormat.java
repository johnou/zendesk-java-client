package org.zendesk.client.v2.util;

import com.fasterxml.jackson.databind.util.StdDateFormat;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Custom {@link com.fasterxml.jackson.databind.util.StdDateFormat} implementation which attempts to parse
 * non standard format date <code>2014-01-27 16:58:10 +0200</code>.
 *
 * @author Johno Crawford (johno@sulake.com)
 */
public class ZendeskStdDateFormat extends StdDateFormat {

    private static final TimeZone DEFAULT_TIMEZONE = TimeZone.getTimeZone("GMT");

    private static final SimpleDateFormat DATE_FORMAT_ZENDESK = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");

    static {
        // force use of GMT for baseline DataFormat objects like StdDateFormat
        DATE_FORMAT_ZENDESK.setTimeZone(DEFAULT_TIMEZONE);
    }

    @Override
    public Date parse(String dateStr) throws ParseException {
        try {
            return super.parse(dateStr);
        } catch (ParseException e) {
            try {
                return ((DateFormat) DATE_FORMAT_ZENDESK.clone()).parse(dateStr);
            } catch (ParseException ignore) {
                throw e;
            }
        }
    }

    @Override
    public ZendeskStdDateFormat clone() {
        return new ZendeskStdDateFormat();
    }
}
