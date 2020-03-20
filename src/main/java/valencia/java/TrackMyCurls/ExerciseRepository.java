package valencia.java.TrackMyCurls;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExerciseRepository extends CrudRepository<Exercise,Integer> {
    List<ExerciseFormat> findByWorkout(String workout);
    Exercise findByExerciseName(String exerciseName);
    void deleteByExerciseName(String exerciseName);
    void deleteAllByWorkout(String workout);
    Integer countByWorkout(String workout);
}
