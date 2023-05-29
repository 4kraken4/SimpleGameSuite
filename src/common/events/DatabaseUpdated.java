package common.events;

@FunctionalInterface
public interface DatabaseUpdated {

    void onDatabseUpdate(int gameId, boolean isUpdated);
}
