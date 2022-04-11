package pl.nwaczykgym.nwaczykgym.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.nwaczykgym.nwaczykgym.model.GymUser;
import pl.nwaczykgym.nwaczykgym.model.GymUserFilter;
import pl.nwaczykgym.nwaczykgym.service.GymUserService;

import java.util.List;

@RestController
public class GymUserController {

    private final GymUserService gymUserService;

    @Autowired
    public GymUserController(GymUserService gymUserService) {
        this.gymUserService = gymUserService;
    }

    //get
    @GetMapping("/users")
    public List<GymUser> getGymUsers(@RequestParam(name = "pesel") String pesel,
                                     @RequestParam(name = "city") String city){
        GymUserFilter filter = GymUserFilter.builder()
                .pesel(pesel)
                .city(city)
                .build();

        return gymUserService.getGymUsers(filter);
    }


    //get by id
    @GetMapping(path = "/users/{id}")
    public GymUser getGymUserById(@PathVariable("id") String id) {
        return gymUserService.getGymUser(id);
    }


    //post
    @PostMapping("/users")
    public ResponseEntity<GymUser> createGymUser(@RequestBody GymUser gymUser){
        GymUser createdUser = gymUserService.createGymUser(gymUser);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    //delete
    @DeleteMapping(path = "/users/{id}")
    public void deleteGymUser(@PathVariable("id") String id){

        gymUserService.deleteById(id);
    }

    //update -> to correct in future
    @PatchMapping(path = "/users")
    public void updateGymUser(@RequestBody GymUser gymUser){
        gymUserService.updateGymUser( gymUser);
    }

}
