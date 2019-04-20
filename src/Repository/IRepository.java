package Repository;

import Domain.Entity;

import java.util.List;

public interface IRepository<T extends Entity> {

    /**
     * returns a entity by id
     * @param id of the entity
     * @return a entity
     */
    T getById(String id);

    /**
     * adds a movie
     * @param entity to add
     * @throws RuntimeException if a entity with that id already exists
     */
    void insert(T entity);


    /**
     * @return a list with all entities
     */
    List<T> getAll();

}