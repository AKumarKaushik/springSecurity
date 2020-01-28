package java4_Assgnmnt;

import static java.text.DateFormat.FULL;
import static java.text.DateFormat.LONG;
import static java.text.DateFormat.MEDIUM;
import static java.text.DateFormat.SHORT;
import static java.util.Locale.UK;
import static java.util.Locale.US;


import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;


public class Q9_DisplayTime {
    public static void main(String[] args) {
        Date today = new Date();
        Locale[] locales = { US, UK,};
        int[] styles = { FULL, LONG, MEDIUM, SHORT };
        String[] styleNames = { "FULL", "LONG", "MEDIUM", "SHORT" };
        DateFormat fmt = null;
        for (Locale locale : locales) {
            System.out.println("\nThe Date for " + locale.getDisplayCountry() + ":");
            for (int i = 0; i < styles.length; i++) {
                fmt = DateFormat.getDateInstance(styles[i], locale);
                System.out.println("\tIn " + styleNames[i] + " is " + fmt.format(today));
            }
        }
    }
}

