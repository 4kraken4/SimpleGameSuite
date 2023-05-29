package common.events;

@FunctionalInterface
public interface GameWin {

    void onGameWin(Object data, Object helperData);
}
