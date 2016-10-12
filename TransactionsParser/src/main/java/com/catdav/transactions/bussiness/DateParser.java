package com.catdav.transactions.bussiness;

import com.catdav.transactions.bussiness.exceptions.DateParserException;

import java.time.LocalDate;

/**
 * Exceptions handled:
 *
 * 1.invalid day:<0 or >31
 *
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
    public LocalDate parse(String dateString) throws DateParserException;
}
