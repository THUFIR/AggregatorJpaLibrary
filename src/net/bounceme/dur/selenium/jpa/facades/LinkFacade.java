package net.bounceme.dur.selenium.jpa.facades;

import net.bounceme.dur.selenium.jpa.entities.Link;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class LinkFacade extends AbstractFacade {
    
    private final static Logger log = Logger.getLogger(PageFacade.class.getName());
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("SeleniumIteratorPU");
//    @PersistenceContext(unitName = "SeleniumReaderPU")
    
    public LinkFacade() {
        super(Link.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}


