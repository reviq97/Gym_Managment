package pl.nwaczykgym.nwaczykgym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.nwaczykgym.nwaczykgym.model.GymUser;
import pl.nwaczykgym.nwaczykgym.model.GymUserFilter;

import java.util.List;

@Repository
public interface GymUserRepository extends JpaRepository<GymUser, String> {

    // TODO make generic query
    @Query(value = "SELECT * from gym_user gu where gu.pesel = :#{#filter.pesel} and gu.city = :#{#filter.city}"
            , nativeQuery = true)
    List<GymUser> findByFilter(@Param("filter") GymUserFilter filter);


    /*@Query(value = "SELECT * from gym_user gu where gu.pesel = :pesel", nativeQuery = true)
    GymUser findByPesel(@Param("pesel") Long pesel);*/

}
