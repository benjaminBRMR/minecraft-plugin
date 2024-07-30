package de.sprachlvs.skydrugs.utils;

public class TimeUtils {
    private static final TimeUtils instance = new TimeUtils();

    public static TimeUtils getInstance() {
        return instance;
    }

    public static long UPTIME;

    public long getUptime() {
        return UPTIME;
    }

    public static String timeToString(long time, boolean shorten) {
        String msg = "";
        long seconds = time / 1000L;
        long minutes;
        if (seconds >= 86400L) {
            minutes = seconds / 86400L;
            msg = msg + minutes + (shorten ? "d " : (minutes == 1L ? " Tag, " : " Tage, "));
            seconds %= 86400L;
        }

        if (seconds >= 3600L) {
            minutes = seconds / 3600L;
            msg = msg + minutes + (shorten ? "h " : " Std, ");
            seconds %= 3600L;
        }

        if (seconds >= 60L) {
            minutes = seconds / 60L;
            msg = msg + minutes + (shorten ? "m " : " Min, ");
            seconds %= 60L;
        }

        if (seconds > 0L) {
            msg = msg + seconds + (shorten ? "s " : " Sek, ");
        }

        if (!msg.isEmpty()) {
            msg = msg.substring(0, msg.length() - (shorten ? 1 : 2));
        } else {
            msg = shorten ? "0s" : "0 Sek";
        }

        return msg;
    }
}
