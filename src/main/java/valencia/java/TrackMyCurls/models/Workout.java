package valencia.java.TrackMyCurls.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
public class Workout {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer length;
    private String workoutName;
}
