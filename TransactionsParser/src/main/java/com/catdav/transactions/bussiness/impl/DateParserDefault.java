package com.catdav.transactions.bussiness.impl;

import com.catdav.transactions.bussiness.DateParser;
import com.catdav.transactions.bussiness.exceptions.DateParserException;


import java.text.ParseException;

import java.time.LocalDate;
import java.time.Month;
import java.util.Date;

public class DateParserDefault implements DateParser {

    public LocalDate parse(String dateString) throws DateParserException{


        String[] datesString = dateString.split(" ");

        int day = Integer.parseInt(datesString[0]);
        Month resultedMonth = null;
        int year = LocalDate.now().getYear();

        LocalDate date = LocalDate.now();

        if( (day<0) || (day>31) ){
            throw new DateParserException("day invalid:"+day+", reenter date:"+dateString);

        }

        if( null == datesString[1] ) {
            throw new DateParserException("month string null, reenter date:"+dateString);
        }
        else{

            datesString[1] = datesString[1].toLowerCase();
            switch (datesString[1]) {
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
                    throw new DateParserException("month invalid:"+datesString[1]+", reenter date:"+dateString);
                    //break;
                }
            }
        }

        if(resultedMonth.compareTo(LocalDate.now().getMonth()) > 0 ){
            year = year - 1;
        }


        date = LocalDate.of(year,resultedMonth,day);


     return date;
    }
}
