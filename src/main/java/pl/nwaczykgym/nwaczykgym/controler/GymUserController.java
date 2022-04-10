package pl.nwaczykgym.nwaczykgym.controler;

import com.github.fge.jsonpatch.JsonPatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.nwaczykgym.nwaczykgym.model.GymUser;
import pl.nwaczykgym.nwaczykgym.service.GymUserService;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class GymUserController {

    private final GymUserService gymUserService;

    @Autowired
    public GymUserController(GymUserService gymUserService) {
        this.gymUserService = gymUserService;
    }

    //get
    @GetMapping("/user/get")
    public List<GymUser> getGymUsers(){
        return gymUserService.getGymUsers();
    }


    //get by id
    @GetMapping(path = "/user/get/{id}")
    public GymUser getGymUserById(@PathVariable("id") Long pesel){

        return gymUserService.findGymUser(pesel);
    }


    //post
    @PostMapping("/user/create")
    public void createGymUser(@RequestBody GymUser gymUser){

        gymUserService.postGymUser(gymUser);
    }

    //delete
    @DeleteMapping(path = "user/delete/{peselId}")
    public void deleteGymUser(@PathVariable("peselId") Long pesel){

        gymUserService.deleteByPesel(pesel);
    }

    //update -> to correct in future
    @PatchMapping(path = "/user/update/{peselId}")
    public void updateGymUser(@PathVariable("peselId") Long pesel, @RequestBody GymUser gymUser){
        gymUserService.updateGymUser(pesel, gymUser);
    }

}
