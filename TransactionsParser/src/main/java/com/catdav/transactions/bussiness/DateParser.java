package com.catdav.transactions.bussiness;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class DateParser {

    LocalDate parse(String dateString){

        //DateFormat format = new SimpleDateFormat("d MMMM", Locale.ENGLISH);
        //LocalDate date = format.parse(dateString,format);


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMM");
        LocalDate date = LocalDate.parse(dateString, formatter);

        return date;
    }
}
