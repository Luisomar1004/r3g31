
package com.g31.jpa.repository;

import com.g31.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author LuisOmar
 */
public interface UserRepository extends JpaRepository<User, Integer>{
    
}
