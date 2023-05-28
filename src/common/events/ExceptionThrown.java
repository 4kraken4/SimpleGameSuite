package common.events;

import java.sql.SQLException;

public interface ExceptionThrown {
    String handleSqlExceptions(SQLException e);
}
