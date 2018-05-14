package com.jpmc.test.utils;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class DateUtils {
    private static final String AED = "AED";
    private static final String SAR = "SAR";

    public static LocalDate getWorkingDateForCurrency(LocalDate date, String currency) {
        if (AED.equals(currency) || SAR.equals(currency)) {
            return getNextWorkingDateSpecial(date);
        }
        
        return getNextWorkingDateGeneral(date);
    }

    private static LocalDate getNextWorkingDateSpecial(LocalDate date) {
        if (date.getDayOfWeek().equals(DayOfWeek.FRIDAY)) {
            return date.plusDays(2);
        } else if (date.getDayOfWeek().equals(DayOfWeek.SATURDAY)) {
            return date.plusDays(1);
        }
        
        return date;
    }

    private static LocalDate getNextWorkingDateGeneral(LocalDate date) {
        if (date.getDayOfWeek().equals(DayOfWeek.SATURDAY)) {
            return date.plusDays(2);
        } else if (date.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
            return date.plusDays(1);
        }
            
        return date;
    }
}
