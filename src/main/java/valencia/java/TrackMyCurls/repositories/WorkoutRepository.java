package valencia.java.TrackMyCurls.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import valencia.java.TrackMyCurls.models.Workout;

import java.util.Optional;

public interface WorkoutRepository extends JpaRepository<Workout,Integer> {
    Optional<Workout> findByWorkoutName(@Param("workout") String workout);

    boolean existsWorkoutByWorkoutName(String workout);

    void deleteByWorkoutName(@Param("workout") String workout);
}
