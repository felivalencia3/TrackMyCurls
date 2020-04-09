package valencia.java.TrackMyCurls;

import org.springframework.web.bind.annotation.*;
import valencia.java.TrackMyCurls.exceptions.ExerciseNotFoundException;
import valencia.java.TrackMyCurls.exceptions.WorkoutNotFoundException;
import valencia.java.TrackMyCurls.models.Exercise;
import valencia.java.TrackMyCurls.models.Workout;
import valencia.java.TrackMyCurls.repositories.ExerciseRepository;
import valencia.java.TrackMyCurls.repositories.WorkoutRepository;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000", maxAge=3600)
@RestController
@RequestMapping(path = "/api")
public class MainController {
    private final ExerciseRepository exerciseRepository;


    private final WorkoutRepository workoutRepository;

    public MainController(ExerciseRepository exerciseRepository, WorkoutRepository workoutRepository) {
        this.exerciseRepository = exerciseRepository;
        this.workoutRepository = workoutRepository;
    }
    // Exercise Endpoints
    //Create
    @PostMapping(path = "/exercises")
    Exercise addNewExercise(@RequestBody Exercise exercise) {
        exerciseRepository.save(exercise);
        String workoutName = exercise.getWorkout();
        Optional<Workout> workoutOptional = workoutRepository.findByWorkoutName(workoutName);
        if (workoutOptional.isPresent()) {
            Workout toUpdate = workoutOptional.orElseThrow(() -> new WorkoutNotFoundException(workoutName));
            toUpdate.setLength(toUpdate.getLength() + 1);
            workoutRepository.save(toUpdate);
        } else {
            Workout workout1 = new Workout();
            workout1.setWorkoutName(workoutName);
            workout1.setLength(1);
            workoutRepository.save(workout1);
        }
        return exercise;
    }

    //Read
    @GetMapping(path = "/exercises")
    @ResponseBody
    Iterable<Exercise> getAllExercises() {
        return exerciseRepository.findAll();
    }

    //Read
    @GetMapping("/exercises/{id}")
    Exercise getOneExercise(@PathVariable Integer id) {
        return exerciseRepository.findById(id).orElseThrow(() -> new ExerciseNotFoundException(id));
    }

    //Update
    @PutMapping(path = "/exercises/{id}")
    Exercise updateExercise(@RequestBody Exercise exercise, @PathVariable Integer id) {
        return exerciseRepository.findById(id)
                .map(newExercise -> {
                    newExercise.setExerciseName(exercise.getExerciseName());
                    newExercise.setRangeEnd(exercise.getRangeEnd());
                    newExercise.setRangeStart(exercise.getRangeStart());
                    newExercise.setRPE(exercise.getRPE());
                    newExercise.setSets(exercise.getSets());
                    newExercise.setWorkout(exercise.getWorkout());
                    return exerciseRepository.save(newExercise);
                })
                .orElseGet(() -> {
                    exercise.setId(id);
                    return exerciseRepository.save(exercise);
                });
    }

    //Delete
    @Transactional
    @DeleteMapping("/exercises/{id}")
    String deleteOneExercise(@PathVariable Integer id) {
        exerciseRepository.deleteById(id);
        return "Deleted.";
    }


    // Workout Endpoints
    //Create
    @PostMapping("/workouts")
    Workout newWorkout(@RequestBody Workout workout) {
        return workoutRepository.save(workout);
    }

    //Read
    @GetMapping(path = "/workouts/{workout}")
    public HashMap<String, Object> getWorkout(@PathVariable String workout) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("workoutInfo", workoutRepository.findByWorkoutName(workout).orElseThrow(() -> new WorkoutNotFoundException(workout)));
        result.put("exercises", exerciseRepository.findByWorkout(workout));
        return result;
    }

    //Update
    @PutMapping("/workouts/{id}")
    Workout updateWorkout(@RequestBody Workout newWorkout, @PathVariable Integer id) {
        return workoutRepository.findById(id)
                .map(workout -> {
                    workout.setWorkoutName(newWorkout.getWorkoutName());
                    workout.setLength(newWorkout.getLength());
                    return workoutRepository.save(workout);
                }).orElseGet(() -> {
                    newWorkout.setId(id);
                    return workoutRepository.save(newWorkout);
                });
    }

    //Delete
    @Transactional
    @DeleteMapping("/workouts/{workout}")
    String deleteAllWorkout(@PathVariable String workout) {
        exerciseRepository.deleteAllByWorkout(workout);
        workoutRepository.deleteByWorkoutName(workout);
        return "Deleted.";
    }


}
