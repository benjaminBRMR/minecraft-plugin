package de.sprachlvs.skydrugs.apis;

public class PlayTimeAPI {
    public static String getTime(int seconds) {
        if (seconds < 60)
            return String.valueOf(String.valueOf(seconds)) + "s";
        int minutes = seconds / 60;
        int s = 60 * minutes;
        int secondsLeft = seconds - s;
        if (minutes < 60) {
            if (secondsLeft > 0)
                return String.valueOf(String.valueOf(minutes) + "m");
            return String.valueOf(String.valueOf(minutes)) + "m";
        }
        if (minutes < 1440) {
            String str = "";
            int hours = minutes / 60;
            str = String.valueOf(String.valueOf(hours)) + "h";
            int i = 60 * hours;
            int j = minutes - i;
            if (j >= 1)
                str = String.valueOf(String.valueOf(str)) + " " + j + "m";
            if (secondsLeft > 0)
                str = String.valueOf(str);
            return str;
        }
        String time = "";
        int days = minutes / 1440;
        time = String.valueOf(String.valueOf(days)) + "d";
        int inMins = 1440 * days;
        int leftOver = minutes - inMins;
        if (leftOver >= 1)
            if (leftOver < 60) {
                time = String.valueOf(String.valueOf(time)) + " " + leftOver + "m";
            } else {
                int hours2 = leftOver / 60;
                time = String.valueOf(String.valueOf(time)) + " " + hours2 + "h";
                int hoursInMins = 60 * hours2;
                int minsLeft = leftOver - hoursInMins;
                if (leftOver >= 1)
                    time = String.valueOf(String.valueOf(time)) + " " + minsLeft + "m";
            }
        if (secondsLeft > 0)
            time = String.valueOf(time);
        return time;
    }
}
