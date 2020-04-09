package valencia.java.TrackMyCurls.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String exerciseName;

    private String workout;

    private Integer rangeStart;

    private Integer rangeEnd;

    private Integer sets;

    private Integer RPE;

    public Exercise(String exerciseName, String workout, Integer rangeStart, Integer rangeEnd, Integer sets, Integer rpe) {
        this.exerciseName = exerciseName;
        this.workout = workout;
        this.rangeStart = rangeStart;
        this.rangeEnd = rangeEnd;
        this.sets = sets;
        this.RPE = rpe;
    }

    public Exercise() {
    }
}
