/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

/**
 *
 * @author juanb
 */
public abstract class Utils {
    /*
    public Utils() {

    }

    public static boolean validationDaysUnderObservtion(String daysPops) {
        int daysPop;
        if (validationNumber(daysPops)) {
            daysPop = Integer.parseInt(daysPops);
            if (daysPop % 45 == 0 && daysPop <= 630 && daysPop >= 45) {
                return true;
            } else {
                return false;
            }

        } else {
            return false;
        }

    }

    public static boolean validationPercentage(String percentages) {
        int percentage;
        if (validationNumber(percentages)) {
            percentage = Integer.parseInt(percentages);
            if (percentage >= 0 && percentage <= 100) {
                return true;
            } else {
                return false;
            }

        } else {
            return false;
        }

    }

    public static boolean validationDate(String days, String months, String years) {
        int day, month, year;
        if (validationNumber(days) && validationNumber(months) && validationNumber(years)) {
            day = Integer.parseInt(days);
            month = Integer.parseInt(months);
            year = Integer.parseInt(years);
            if (year > 2010) {
                if (month == 1 || month == 3 || month == 5 || month == 7
                        || month == 8 || month == 10 || month == 12) {
                    if (day > 0 && day < 32) {
                        return true;
                    } else {
                        return false;
                    }
                }
                if (month == 4 || month == 6 || month == 9 || month == 11) {
                    if (day > 0 && day < 31) {
                        return true;
                    } else {
                        return false;
                    }

                } else {
                    if (day > 0 && day < 29) {
                        return true;
                    } else {
                        return false;
                    }
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static boolean validationNumber(String val) {
        try {
            Integer.parseInt(val);
            return true;
        } catch (NumberFormatException ex) {
            return false;

        }
    }

    public static boolean validationNumberFloat(String val) {
        try {
            Float.parseFloat(val);
            return true;
        } catch (NumberFormatException ex) {
            return false;

        }
    }

    public static boolean checkMousePop(PopulationMouse pop, String mouseref) {
        boolean state = true;
        for (int i = 0; i < pop.getMice().size(); i++) {
            if (pop.getMice().get(i).getMouseRef().equals(mouseref)) {
                state = false;
            }
        }
        return state;
    }*/

}
