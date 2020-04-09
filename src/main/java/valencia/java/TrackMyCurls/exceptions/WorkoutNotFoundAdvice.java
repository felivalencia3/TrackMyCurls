package valencia.java.TrackMyCurls.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class WorkoutNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(WorkoutNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String exerciseNotFoundHandler(WorkoutNotFoundException ex) {
        return ex.getMessage();
    }
}
