package com.example.services;

import com.example.models.User;
import com.example.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserService extends AbstractService<User> {

    @Autowired
    public UserService(UserRepository mainRepository) {
        super(mainRepository);
    }

    public User update(User user){
        Optional<User> optOldUser = mainRepository.findById(user.getId());

        if(optOldUser.isPresent()){
            User oldUser = optOldUser.get();

            oldUser.setFullname(user.getFullname()) ;
            oldUser.setEmail(user.getEmail()) ;
            oldUser.setLocale(user.getLocale()); ;
            return ((User) mainRepository.save(oldUser));
        }
        return ((User) mainRepository.save(user));
    }

}
