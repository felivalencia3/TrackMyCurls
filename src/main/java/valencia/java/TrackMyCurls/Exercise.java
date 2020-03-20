package valencia.java.TrackMyCurls;

import lombok.Data;

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
}
