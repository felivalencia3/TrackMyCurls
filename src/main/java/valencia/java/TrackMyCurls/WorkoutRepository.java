package valencia.java.TrackMyCurls;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface WorkoutRepository extends CrudRepository<Workout,Integer> {
    Optional<Workout> findByWorkoutName(@Param("workout") String workout);

    boolean existsWorkoutByWorkoutName(String workout);

    void deleteByWorkoutName(@Param("workout") String workout);
}
