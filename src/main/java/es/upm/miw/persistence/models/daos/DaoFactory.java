package es.upm.miw.persistence.models.daos;

import es.upm.miw.persistence.models.daos.ThemeDao;
import es.upm.miw.persistence.models.daos.VoteDao;
import es.upm.miw.persistence.models.daos.jpa.DaoJpaFactory;

public abstract class DaoFactory {
    public static DaoFactory factory = null;

    public static void setFactory(DaoFactory factory) {
        DaoFactory.factory = factory;
    }

    public static DaoFactory getFactory() {
    	if (factory == null) {
            factory = new DaoJpaFactory();
        }
        return factory;
    }

    public abstract ThemeDao getThemeDao();

    public abstract VoteDao getVoteDao();
    
}
