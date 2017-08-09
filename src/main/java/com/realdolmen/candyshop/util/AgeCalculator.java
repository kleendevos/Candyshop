package com.realdolmen.candyshop.util;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by kathleendevos on 9/08/17.
 */
public class AgeCalculator {

    public static int calculateAge(Date birthday){
        Calendar Birth = Calendar.getInstance();
        Birth.setTime(birthday);
        Calendar Today = Calendar.getInstance();

        int yeardifference = Today.get(Calendar.YEAR)-Birth.get(Calendar.YEAR);
        return yeardifference;
    }

}
