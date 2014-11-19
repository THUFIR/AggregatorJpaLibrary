package net.bounceme.dur.jpa.facades;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import net.bounceme.dur.jpa.controllers.LinkJpaController;
import net.bounceme.dur.jpa.entities.Link;
import net.bounceme.dur.jpa.exceptions.NonexistentEntityException;

public class LinkFacade {

    private final static Logger log = Logger.getLogger(LinkFacade.class.getName());
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("SeleniumIteratorPU");
    private final LinkJpaController controller = new LinkJpaController(emf);

    public LinkFacade() {
    }

    public void create(Link link) {
        controller.create(link);
    }

    public void edit(Link link) {
        try {
            controller.edit(link);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(LinkFacade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(LinkFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void destroy(int id) {
        try {
            controller.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(LinkFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Link> findEntities() {
        return controller.findLinkEntities();
    }

    public void findEntity(int id) {
        controller.findLink(id);
    }

    public int getCount() {
        return controller.getLinkCount();
    }

}
