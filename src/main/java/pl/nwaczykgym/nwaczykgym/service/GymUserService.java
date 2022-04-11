package pl.nwaczykgym.nwaczykgym.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.nwaczykgym.nwaczykgym.controler.UserNotFoundException;
import pl.nwaczykgym.nwaczykgym.model.GymUser;
import pl.nwaczykgym.nwaczykgym.model.GymUserFilter;
import pl.nwaczykgym.nwaczykgym.repository.GymUserRepository;
import pl.nwaczykgym.nwaczykgym.service.exceptions.UserAlreadyExistsException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class GymUserService {

    private final GymUserRepository gymUserRepository;

    @Autowired
    public GymUserService(GymUserRepository gymUserRepository) {
        this.gymUserRepository = gymUserRepository;
    }

    //get all users
    public List<GymUser> getGymUsers(GymUserFilter filter){
        return gymUserRepository.findByFilter(filter);
    }
    //get single user
    public GymUser getGymUser(String id) {
        return gymUserRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);
    }

    //post
    public GymUser createGymUser(GymUser gymUser){
       gymUser.setId(UUID.randomUUID().toString());
       return gymUserRepository.save(gymUser);
    }

    //delete user by pesel-id
    public void deleteById(String id) {
        gymUserRepository.deleteById(id);
    }

    //to correct
    public void updateGymUser(GymUser patchedGymUser) {
        gymUserRepository.save(patchedGymUser);
    }

}

