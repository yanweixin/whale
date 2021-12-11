package me.whale.data.dbms.repository;

import me.whale.data.dbms.domain.IdEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CustomRepository<T extends IdEntity, ID> extends JpaRepository<T, ID>, JpaSpecificationExecutor<T> {

    /**
     * insert or update depends on whether entity has id
     *
     * @param entity
     * @return
     */
    default T saveById(T entity) {
        if (entity == null) {
            return null;
        }
        if (entity.getId() == null) {
            //TODO:new
        } else {
            //TODO:update
        }
        return entity;
    }
}
