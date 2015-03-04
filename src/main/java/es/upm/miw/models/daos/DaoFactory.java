package es.upm.miw.models.daos;

import es.upm.miw.models.daos.ThemeDao;
import es.upm.miw.models.daos.VoteDao;

public abstract class DaoFactory {
    public static DaoFactory factory = null;

    public static void setFactory(DaoFactory factory) {
        DaoFactory.factory = factory;
    }

    public static DaoFactory getFactory() {
        assert factory != null;
        return factory;
    }

    public abstract ThemeDao getUserDao();

    public abstract VoteDao getCategoryDao();
}
