/**
 * 
 */
package com.cogent.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.cogent.entity.Author;

/**
 * @author: Joi
 * @date: Feb 9, 2023
 */


public interface AuthorRepository extends CrudRepository<Author, Integer> {
	//List<Author> findByName(String name);
}
