package net.bounceme.dur.jpa.facades;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import net.bounceme.dur.jpa.controllers.FeedJpaController;
import net.bounceme.dur.jpa.entities.Feed;
import net.bounceme.dur.jpa.exceptions.IllegalOrphanException;
import net.bounceme.dur.jpa.exceptions.NonexistentEntityException;

public class FeedFacade {

    private final static Logger log = Logger.getLogger(FeedFacade.class.getName());
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("SeleniumIteratorPU");
    private final FeedJpaController controller = new FeedJpaController(emf);

    public FeedFacade() {
    }

    public void create(Feed feed) {
        controller.create(feed);
    }

    public void edit(Feed feed) {
        try {
            controller.edit(feed);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(FeedFacade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(FeedFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void destroy(int id) {
        try {
            controller.destroy(id);
        } catch (IllegalOrphanException | NonexistentEntityException ex) {
            Logger.getLogger(FeedFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Feed> findEntities(int maxResults, int firstResult) {
        return controller.findFeedEntities(maxResults, firstResult);
    }

    public void findEntity(int id) {
        controller.findFeed(id);
    }

    public int getCount() {
        return controller.getFeedCount();
    }

}
