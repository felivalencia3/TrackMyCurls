package valencia.java.TrackMyCurls.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import valencia.java.TrackMyCurls.models.Exercise;

import java.util.List;

public interface ExerciseRepository extends JpaRepository<Exercise,Integer> {
    List<ExerciseFormat> findByWorkout(String workout);
    Exercise findByExerciseName(String exerciseName);
    void deleteByExerciseName(String exerciseName);
    void deleteAllByWorkout(String workout);
    Integer countByWorkout(String workout);
}
