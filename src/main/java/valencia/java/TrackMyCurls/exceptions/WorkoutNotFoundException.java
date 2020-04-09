package valencia.java.TrackMyCurls.exceptions;

public class WorkoutNotFoundException extends RuntimeException {
    public WorkoutNotFoundException(String workoutName) {
        super("Could not find workout: "+workoutName);
    }
}