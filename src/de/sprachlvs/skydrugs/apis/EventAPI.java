package de.sprachlvs.skydrugs.apis;

import de.sprachlvs.skydrugs.events.GuessTheNumberEvent;
import de.sprachlvs.skydrugs.events.RangverlosungEvent;
import de.sprachlvs.skydrugs.events.TokenverlosungEvent;

public class EventAPI {

    private static final GuessTheNumberEvent guessTheNumberEvent = new GuessTheNumberEvent();
    private static final RangverlosungEvent rangverlosungEvent = new RangverlosungEvent();
    private static final TokenverlosungEvent tokenverlosungEvent = new TokenverlosungEvent();
    public static boolean event;
    public static boolean eventstatus;

    public static GuessTheNumberEvent getGuessTheNumberEvent() {
        return guessTheNumberEvent;
    }

    public static RangverlosungEvent getRangverlosungEvent() {
        return rangverlosungEvent;
    }

    public static TokenverlosungEvent getTokenverlosungEvent() {
        return tokenverlosungEvent;
    }
}

