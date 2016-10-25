package com.catdav.transactions.parser.date.impl;

import com.catdav.transactions.parser.date.DateParser;
import com.catdav.transactions.parser.exceptions.DateParseException;


import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;

public class DefaultDateParser implements DateParser {

    public LocalDate parse(String dateString) throws DateParseException {

        if( dateString==null ){
            throw new DateParseException("null date string");
        }
        String[] datesString = dateString.split(" ");

        if( datesString.length != 2 ){
            throw new DateParseException("invalid format date :"+dateString);
        }

        String monthToBeParsed = datesString[1].toLowerCase();

        int day = parseDay(datesString[0]);
        Month month = parseMonth(monthToBeParsed);
        int year = resolveYear(month);

        LocalDate date = LocalDate.now();

        try {
            date = LocalDate.of(year, month, day);
        }catch(DateTimeException dte){
            throw new DateParseException("invalid date:"+dateString+dte);
        }

     return date;
    }

    private int parseDay(String dayToBeParsed) throws DateParseException {

        int day = 0;
        //if dateString: 1a aug or 12aug=> datesString[]={12aug}

        try {
            day = Integer.parseInt(dayToBeParsed);

        }catch(NumberFormatException e){
            throw new DateParseException("invalid day:"+dayToBeParsed+e);
        }

        if( (day<=0) || (day>31) ){
            throw new DateParseException("invalid day:"+day);
        }

        return day;
     }

    private Month parseMonth(String monthToBeParsed) throws DateParseException {

        Month resultedMonth = null;

        switch (monthToBeParsed) {
            case "ian":
            case "ianuarie": {
                resultedMonth = Month.JANUARY;
                break;
            }
            case "feb":
            case "februarie": {
                resultedMonth = Month.FEBRUARY;
                break;
            }
            case "mar":
            case "martie": {
                resultedMonth = Month.MARCH;
                break;
            }
            case "apr":
            case "aprilie": {
                resultedMonth = Month.APRIL;
                break;
            }
            case "mai": {
                resultedMonth = Month.MAY;
                break;
            }
            case "iun":
            case "iunie": {
                resultedMonth = Month.JUNE;
                break;
            }
            case "iul":
            case "iulie": {
                resultedMonth = Month.JULY;
                break;
            }
            case "aug":
            case "august": {
                resultedMonth = Month.AUGUST;
                break;
            }
            case "sep":
            case "septembrie": {
                resultedMonth = Month.SEPTEMBER;
                break;
            }
            case "oct":
            case "octpmbrie": {
                resultedMonth = Month.OCTOBER;
                break;
            }
            case "noi":
            case "noiembrie": {
                resultedMonth = Month.NOVEMBER;
                break;
            }
            case "dec":
            case "decembrie": {
                resultedMonth = Month.DECEMBER;
                break;
            }
            default: {
                throw new DateParseException("invalid month: " + monthToBeParsed);
            }
        }

        return resultedMonth;
    }

    private int resolveYear(Month month){

        int year = LocalDate.now().getYear();

        if(month.compareTo(LocalDate.now().getMonth()) > 0 ){
            year = year - 1;
        }

        return year;

    }
}
