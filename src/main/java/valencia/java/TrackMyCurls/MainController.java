package valencia.java.TrackMyCurls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api")
public class MainController {
    @Autowired
    private ExerciseRepository exerciseRepository;

    @Autowired
    private WorkoutRepository workoutRepository;

    @PostMapping(path="/add")
    public Exercise addNewWorkout(@RequestParam() String exerciseName , @RequestParam Integer rpe, @RequestParam Integer rangeStart, @RequestParam Integer rangeEnd, @RequestParam Integer sets, @RequestParam String workout) {
        Exercise n = new Exercise();
        n.setExerciseName(exerciseName);
        n.setRangeStart(rangeStart);
        n.setRangeEnd(rangeEnd);
        n.setRPE(rpe);
        n.setSets(sets);
        n.setWorkout(workout);
        exerciseRepository.save(n);
        if(workoutRepository.existsWorkoutByWorkoutName(workout)) {
            Optional<Workout> workoutOptional = workoutRepository.findByWorkoutName(workout);
            Workout toUpdate = workoutOptional.orElseThrow();
            toUpdate.setLength(toUpdate.getLength()+1);
            workoutRepository.save(toUpdate);
        }
        else {
            Workout workout1 = new Workout();
            workout1.setWorkoutName(workout);
            workout1.setLength(1);
            workoutRepository.save(workout1);
        }
        return n;
    }

    @GetMapping(path = "/get")
    public HashMap<String,Object> getWorkout(@RequestParam(value = "workout") String workout) {
        HashMap<String,Object> result = new HashMap<String, Object>();
        result.put("workoutInfo", workoutRepository.findByWorkoutName(workout));
        result.put("exercises", exerciseRepository.findByWorkout(workout));
        return result;
    }

    @GetMapping(path = "/update")
    public Exercise updateWorkout(@RequestParam String exerciseName, @RequestParam Integer rpe, @RequestParam Integer rangeStart, @RequestParam Integer rangeEnd, @RequestParam Integer sets, @RequestParam String workout, @RequestParam Integer id) {
        Exercise n = new Exercise();
        n.setId(id);
        n.setExerciseName(exerciseName);
        n.setRangeStart(rangeStart);
        n.setRangeEnd(rangeEnd);
        n.setRPE(rpe);
        n.setSets(sets);
        n.setWorkout(workout);
        exerciseRepository.save(n);
        return n;
    }

    @PostMapping(path = "/deleteOne")
    @Transactional
    public String deleteOneExercise(@RequestParam(value = "exerciseName") String exerciseName) {
        exerciseRepository.deleteByExerciseName(exerciseName);
        return "Deleted.";
    }

    @PostMapping(path = "/delete")
    @Transactional
    public String deleteAllWorkout(@RequestParam(value = "workout") String workout) {
        exerciseRepository.deleteAllByWorkout(workout);
        workoutRepository.deleteByWorkoutName(workout);
        return "Deleted.";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Exercise> getAllWorkouts() {
        return exerciseRepository.findAll();
    }
}
