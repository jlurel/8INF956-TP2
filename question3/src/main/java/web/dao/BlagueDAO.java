/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.dao;

import web.model.Blague;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author fadou
 */
public interface BlagueDAO extends CrudRepository<Blague, Integer>{
    //count()
    //delete(T entity)
    //deteteAll()
    //deleteAll(Iterable<? extends T> entities)
    //deleteById(ID id)
    //existsById(ID id)
    //findAll()
    //findAllById(Iterable<ID> ids)
    //findById(ID id)
    //save(S entity)
    //saveAll(Iterable<S> entities)
}
