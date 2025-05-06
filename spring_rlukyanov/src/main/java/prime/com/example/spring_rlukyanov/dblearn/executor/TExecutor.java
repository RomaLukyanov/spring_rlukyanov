package prime.com.example.spring_rlukyanov.dblearn.executor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import prime.com.example.spring_rlukyanov.dblearn.THandlerInterface.TResultHandler;

public class TExecutor {
    public <T> T execQuery(Connection connection, String query, TResultHandler<T> handler) throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute(query);
        ResultSet result = statement.getResultSet();
        T value = handler.handle(result);
        result.close();
        statement.close();
        return value;
    }
}
