package net.bounceme.dur.jpa.facades;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import net.bounceme.dur.jpa.controllers.PageJpaController;
import net.bounceme.dur.jpa.entities.Page;
import net.bounceme.dur.jpa.exceptions.NonexistentEntityException;

public class PageFacade {

    private final static Logger log = Logger.getLogger(PageFacade.class.getName());
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("SeleniumIteratorPU");
    private final PageJpaController controller = new PageJpaController(emf);

    public PageFacade() {
    }

    public void create(Page page) {
        controller.create(page);
    }

    public void edit(Page page) {
        try {
            controller.edit(page);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PageFacade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(PageFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void destroy(int id) {
        try {
            controller.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PageFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Page> findEntities(int maxResults, int firstResult) {
        return controller.findPageEntities(maxResults, firstResult);
    }

    public void findEntity(int id) {
        controller.findPage(id);
    }

    public int getCount() {
        return controller.getPageCount();
    }

}
