package com.bliblifuture;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;

public class OsloUtils {
    public static LocalDate convertStringDateToLocalDate(String stringDate){
        LocalDate convertedDate = LocalDate.parse(stringDate, DateTimeFormat.forPattern(OsloConstanta.DATE_FORMAT));
        return convertedDate;
    }
}
