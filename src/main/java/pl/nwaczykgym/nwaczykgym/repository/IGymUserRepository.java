package pl.nwaczykgym.nwaczykgym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.nwaczykgym.nwaczykgym.model.GymUser;

@Repository
public interface IGymUserRepository extends JpaRepository<GymUser, Long> {

    @Transactional
    Long deleteByPesel(Long pesel);

    @Query(value = "SELECT * from gym_user gu where gu.pesel = :pesel", nativeQuery = true)
    GymUser findByPesel(@Param("pesel") Long pesel);

}
