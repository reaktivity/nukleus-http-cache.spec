/**
 * Copyright 2016-2019 The Reaktivity Project
 *
 * The Reaktivity Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package org.reaktivity.specification.nukleus.http_cache.specification.internal;

import static java.lang.System.currentTimeMillis;
import static java.lang.System.nanoTime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.TimeZone;
import java.util.concurrent.ThreadLocalRandom;

import org.kaazing.k3po.lang.el.Function;
import org.kaazing.k3po.lang.el.spi.FunctionMapperSpi;

public final class HttpCacheFunctions
{
    private static final String[] CACHEABLE_BY_DEFAULT_STATUS_CODES =
        { "200", "203", "204", "206", "300", "301", "404", "405", "410", "414", "501" };

    private static final ThreadLocal<DateFormat> DATE_FORMAT = new ThreadLocal<>()
    {
        @Override
        protected DateFormat initialValue()
        {
            DateFormat dateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz");
            dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            return dateFormat;
        }
    };

    public static class Mapper extends FunctionMapperSpi.Reflective
    {
        public Mapper()
        {
            super(HttpCacheFunctions.class);
        }

        @Override
        public String getPrefixName()
        {
            return "http_cache";
        }
    }

    private HttpCacheFunctions()
    {
        // utility
    }

    @Function
    public static String date()
    {
        return DATE_FORMAT.get().format(new Date());
    }

    @Function
    public static String datePlus(
        int seconds)
    {
        final Date date = new Date(currentTimeMillis() + (seconds * 1000));
        return DATE_FORMAT.get().format(date);
    }

    @Function
    public static String strongEtag()
    {
        return "\"" + nanoTime() + "\"";
    }

    @Function
    public static String fixedStrongEtag(
        String value)
    {
        return "\"" + value + "\"";
    }

    @Function
    public static String weakEtag()
    {
        return "W/" + strongEtag();
    }

    @Function
    public static String randomCacheableByDefaultStatusCode()
    {
        int rnd = ThreadLocalRandom.current().nextInt(CACHEABLE_BY_DEFAULT_STATUS_CODES.length);
        return CACHEABLE_BY_DEFAULT_STATUS_CODES[rnd];

    }

    @Function
    public static byte[] largePayload(
        int length)
    {
        byte[] bytes = new byte[length];
        randomBytesUTF8(bytes, 0, length);
        return bytes;
    }

    private static void randomBytesUTF8(
        byte[] bytes,
        int start,
        int end)
    {
        for (int offset = start; offset < end;)
        {
            int remaining = end - offset;
            int width = Math.min(ThreadLocalRandom.current().nextInt(4) + 1, remaining);

            offset = randomCharBytesUTF8(bytes, offset, width);
        }
    }

    private static int randomCharBytesUTF8(
        byte[] bytes,
        int offset,
        int width)
    {
        Random random = ThreadLocalRandom.current();
        switch (width)
        {
        case 1:
            bytes[offset++] = (byte) random.nextInt(0x80);
            break;
        case 2:
            bytes[offset++] = (byte) (0xc0 | random.nextInt(0x20) | 1 << (random.nextInt(4) + 1));
            bytes[offset++] = (byte) (0x80 | random.nextInt(0x40));
            break;
        case 3:
            // UTF-8 not legal for 0xD800 through 0xDFFF (see RFC 3269)
            bytes[offset++] = (byte) (0xe0 | random.nextInt(0x08) | 1 << random.nextInt(3));
            bytes[offset++] = (byte) (0x80 | random.nextInt(0x40));
            bytes[offset++] = (byte) (0x80 | random.nextInt(0x40));
            break;
        case 4:
            // UTF-8 ends at 0x10FFFF (see RFC 3269)
            bytes[offset++] = (byte) (0xf0 | random.nextInt(0x04) | 1 << random.nextInt(2));
            bytes[offset++] = (byte) (0x80 | random.nextInt(0x10));
            bytes[offset++] = (byte) (0x80 | random.nextInt(0x40));
            bytes[offset++] = (byte) (0x80 | random.nextInt(0x40));
            break;
        }
        return offset;
    }
}
