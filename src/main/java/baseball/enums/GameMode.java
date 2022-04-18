package baseball.enums;

import java.util.HashMap;
import java.util.Map;

public enum GameMode {
    RETRY,
    NEW_GAME,
    EXIT;

    private static final Map<String, GameMode> gameModeMap = new HashMap<String, GameMode>() {
        {
            put("1", NEW_GAME);
            put("2", EXIT);
        }
    };

    public static GameMode of(final String mode) {
        return gameModeMap.get(mode);
    }

}
