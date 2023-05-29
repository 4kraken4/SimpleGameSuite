package common.events;

@FunctionalInterface
public interface QueryExecutionListener {

    void onQueryExecutionProgress(int progress, int executedQueries, int totalQueries);
}
