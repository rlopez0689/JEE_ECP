package es.upm.miw.persistence.models.daos.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.upm.miw.persistence.models.daos.ThemeDao;
import es.upm.miw.persistence.models.daos.jdbc.GenericDaoJdbc;
import es.upm.miw.persistence.models.entities.Theme;

public class ThemeDaoJdbc extends GenericDaoJdbc<Theme, Integer> implements ThemeDao {
    private Logger log = LogManager.getLogger(ThemeDaoJdbc.class);

    private Theme create(ResultSet resultSet) {
        try {
            if (resultSet != null && resultSet.next()) {
                return new Theme(resultSet.getInt(Theme.ID),
                        resultSet.getString(Theme.NAME),
                        resultSet.getString(Theme.Question));
            }
        } catch (SQLException e) {
            log.error("read: " + e.getMessage());
        }
        return null;
    }

    private static final String SQL_CREATE_TABLE = "CREATE TABLE %s (%s INT NOT NULL, %s VARCHAR(255), "
            + "%s VARCHAR(255), PRIMARY KEY (%s))";

    public static String sqlToCreateTable() {
        return String.format(SQL_CREATE_TABLE, Theme.TABLE, Theme.ID, Theme.Question,
        		Theme.NAME, Theme.ID);
    }

    private static final String SQL_INSERT = "INSERT INTO %s (%s,%s,%s) VALUES (%d,'%s','%s')";

    @Override
    public void create(Theme category) {
        this.updateSql(String.format(SQL_INSERT, Theme.TABLE, Theme.ID, Theme.Question,
        		Theme.NAME, category.getId(), category.getQuestion(), category.getName()));
    }

    @Override
    public Theme read(Integer id) {
        ResultSet resultSet = this.query(String.format(SQL_SELECT_ID, Theme.TABLE, id));
        return this.create(resultSet);
    }

    private static final String SQL_UPDATE = "UPDATE %s SET %s='%s', %s='%s' WHERE ID=%d";

    @Override
    public void update(Theme category) {
        this.updateSql(String.format(SQL_UPDATE, Theme.TABLE, Theme.NAME, category.getName(),
        		Theme.Question, category.getQuestion(), category.getId()));
    }

    @Override
    public void deleteById(Integer id) {
        this.updateSql(String.format(SQL_DELETE_ID, Theme.TABLE, id));
    }

    @Override
    public List<Theme> findAll() {
        List<Theme> list = new ArrayList<Theme>();
        ResultSet resultSet = this.query(String.format(SQL_SELECT_ALL, Theme.TABLE));
        Theme category = this.create(resultSet);
        while (category != null) {
            list.add(category);
            category = this.create(resultSet);
        }
        return list;
    }
}
