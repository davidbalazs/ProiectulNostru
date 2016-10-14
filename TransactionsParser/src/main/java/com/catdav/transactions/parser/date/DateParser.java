package com.catdav.transactions.parser.date;

import com.catdav.transactions.parser.exceptions.DateParseException;

import java.time.LocalDate;

/**
 * Exceptions handled:
 *
 * 1.invalid day:
 *   - null string
 *   - <0 or >31
 *   - invalid format number:- 1a or
 *                           - 20aug(entire string does not contain space)
 * 2.invalid month:another than:
 * -ian/ianuarie,
 * -feb/februarie
 * -mar/martie
 * -apr/aprilie
 * -mai
 * -iun/iunie
 * -iul/iulie
 * -aug/august
 * -sep/sept/septembrie
 * -oct/octomrie
 * -noi/noiembrie
 * -dec/decembrie
 *
 * 3.null month
 *
 * Created by catalina.serbu on 10/12/2016.
 */
public interface DateParser {
    public LocalDate parse(String dateString) throws DateParseException;
}
