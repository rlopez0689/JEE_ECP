package es.upm.miw.persistence.models.daos.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;

import es.upm.miw.persistence.models.daos.DaoFactory;
import es.upm.miw.persistence.models.daos.ThemeDao;
import es.upm.miw.persistence.models.daos.VoteDao;
import es.upm.miw.persistence.models.daos.jdbc.ThemeDaoJdbc;
import es.upm.miw.persistence.models.daos.jdbc.DaoJdbcFactory;
import es.upm.miw.persistence.models.entities.Theme;

public class DaoJdbcFactory extends DaoFactory {
    private static final String DRIVER = "com.mysql.jdbc.Driver";

    private static final String URL = "jdbc:mysql://localhost:3306/miwjee";

    private static final String USER = "root";

    private static final String PASS = "";

    private static final String DROP_TABLE = "DROP TABLE IF EXISTS %s";

    private static Connection connection;

    public static Connection getConnection() {
        try {
            if (connection == null || !connection.isValid(0)) {
                Class.forName(DRIVER);
                connection = DriverManager.getConnection(URL, USER, PASS);
            }
        } catch (ClassNotFoundException e) {
            LogManager.getLogger(DaoJdbcFactory.class).error(
                    "Problemas con el driver: " + e.getMessage());
        } catch (SQLException e) {
            LogManager.getLogger(DaoJdbcFactory.class).error(
                    "Problemas con la BD: " + e.getMessage());
        }
        return connection;
    }

    public static void dropAndCreateTables() {
        try {
            Statement statement = getConnection().createStatement();
            statement.executeUpdate(String.format(DROP_TABLE, Theme.TABLE));
            statement.executeUpdate(ThemeDaoJdbc.sqlToCreateTable());
        } catch (SQLException e) {
            LogManager.getLogger(DaoJdbcFactory.class).error("Drop tables: " + e.getMessage());
        }
    }

    @Override
    public ThemeDao getThemeDao() {
        return new ThemeDaoJdbc();
    }

	@Override
	public VoteDao getVoteDao() {
		return null;
	}
}
