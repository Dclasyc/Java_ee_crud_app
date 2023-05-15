package repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.ws.rs.WebApplicationException;

import model.Footballers;

@ApplicationScoped
public class FootballersRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Footballers> findAll() {
        return entityManager.createNamedQuery("Footballers.findAll", Footballers.class)
                .getResultList();
    }

    public Footballers findFootballersById(Long id) {

        Footballers footballers = entityManager.find(Footballers.class, id);

        if (footballers == null) {
            throw new WebApplicationException("Footballer with id of " + id + " does not exist.", 404);
        }
        return footballers;
    }
    @Transactional
    public void updateFootballers(Long id, String name, String email, String club) {

        Footballers footballerToUpdate = findFootballersById(id);
        footballerToUpdate.setName(name);
        footballerToUpdate.setEmail(email);
        footballerToUpdate.setClub(club);

    }
    @Transactional
    public void createFootballers(Footballers footballer) {

        entityManager.persist(footballer);

    }
    @Transactional
    public void deleteFootballer(Long footballerId) {

        Footballers f = findFootballersById(footballerId);
        entityManager.remove(f);
    }


}
