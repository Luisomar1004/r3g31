package com.g31.jpa.service;

import com.g31.jpa.entity.User;
import com.g31.jpa.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author LuisOmar
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    
    public List<User> getUser(){
        return userRepository.findAll();
    }
    
    public User getUserById(Integer idUser){
        return userRepository.findById(idUser).get();
    }
    
    public User saveUser(User user){
        return userRepository.save(user);
    }
    
    //Metodo para eliminar (Capa de servicios)
    public void deleteUser(Integer id){
       userRepository.deleteById(id);               
    }
    
    public User updateUser(User user){
        //valido si viene un id en la información de la peticion
        //si no viene retorno la entidad recibida como parametro
        if (user.getId()!=null){
            //valido si el id existe en la base de datos
            Optional<User> opcional = userRepository.findById(user.getId());
            
            if (!opcional.isEmpty()){
                //logica
                User userBD = opcional.get();
                
                userBD.setName(user.getName());
                return userRepository.save(userBD);
            }else{
                return user;
            }
        }
        return user;       
    }
    
}
