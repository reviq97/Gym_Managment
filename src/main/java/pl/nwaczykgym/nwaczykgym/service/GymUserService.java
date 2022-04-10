package pl.nwaczykgym.nwaczykgym.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import pl.nwaczykgym.nwaczykgym.model.GymUser;
import pl.nwaczykgym.nwaczykgym.repository.IGymUserRepository;

import java.util.List;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.ignoreCase;

@Service
public class GymUserService {

    private final IGymUserRepository gymUserRepository;

    @Autowired
    public GymUserService(IGymUserRepository gymUserRepository) {
        this.gymUserRepository = gymUserRepository;
    }



    public List<GymUser> getGymUsers(){
        return gymUserRepository.findAll();
    }

    public void postGymUser(@RequestBody GymUser gymUser){

        ExampleMatcher peselMatcher = ExampleMatcher.matching()
                .withMatcher("pesel", ignoreCase());

        Example<GymUser> example = Example.of(gymUser, peselMatcher);

        if(gymUserRepository.exists(example)){
            new ResponseEntity<GymUser>(HttpStatus.NOT_FOUND);
        }
        else{
            gymUserRepository.save(gymUser);
            new ResponseEntity<GymUser>(HttpStatus.CREATED);
        }
    }

    public GymUser findGymUser(Long pesel){
        var find = gymUserRepository.findByPesel(pesel);

        return find;
    }

    public void deleteByPesel(Long pesel){
        gymUserRepository.deleteByPesel(pesel);
    }

    public void updateGymUser(Long pesel, GymUser patchedGymUser) {
        gymUserRepository.deleteByPesel(pesel);
        gymUserRepository.save(patchedGymUser);

    }
}
