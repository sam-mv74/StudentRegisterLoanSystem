package entity.enumeration;

import lombok.Getter;
public enum GradeLevel {
    ASSOCIATE(2),
    CONTINUOUS_BA(4),
    DISCONTINUOUS_BA(4),
    CONTINUOUS_MA(6),
    DISCONTINUOUS_MA(2),
    CONTINUOUS_DR(5),
    DISCONTINUOUS_DR(5),
    PROFESSIONAL_DR(5)
    ;

    @Getter
    private final int duration;


    GradeLevel(int duration) {
        this.duration = duration;
    }
}
