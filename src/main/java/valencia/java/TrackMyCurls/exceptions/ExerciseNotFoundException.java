package valencia.java.TrackMyCurls.exceptions;

public class ExerciseNotFoundException extends RuntimeException {
    public ExerciseNotFoundException(Integer id) {
        super("Could not find exercise "+id);
    }
}
