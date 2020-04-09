package valencia.java.TrackMyCurls;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import valencia.java.TrackMyCurls.models.Exercise;
import valencia.java.TrackMyCurls.models.Workout;
import valencia.java.TrackMyCurls.repositories.ExerciseRepository;
import valencia.java.TrackMyCurls.repositories.WorkoutRepository;

@Configuration
@Slf4j
public class LoadDatabase {
    /*
    @Bean
    CommandLineRunner initDatabase(ExerciseRepository exerciseRepository, WorkoutRepository workoutRepository) {
        return args -> {
            Workout newWorkout = new Workout();
            newWorkout.setLength(0);
            newWorkout.setWorkoutName("Push A");
            workoutRepository.save(newWorkout);
            Exercise bench = new Exercise("Bench Press", "Push A", 6, 8, 4, 8);
            Exercise overhead = new Exercise("Overhead Press", "Push A", 10,12,4,8);
            Exercise lowToHigh = new Exercise("Incline Dumbbell Press", "Push A", 12,15,3,9);
            Exercise lateralRaise = new Exercise("Egyptian Lateral Raise", "Push A", 12,15,4,9);
            Exercise tricepExtension = new Exercise("Rope Overhead Tricep Extension", "Push A", 10,12,3,8);
            Exercise cableFly = new Exercise("Mid Cable Fly", "Push A",15,20,2,9);
            Exercise[] pushA = {bench, overhead,lowToHigh,lateralRaise,tricepExtension,cableFly};
            for (Exercise exercise: pushA) {
                log.info("Preloading "+exerciseRepository.save(exercise));
            }


        };
    }

     */
}
