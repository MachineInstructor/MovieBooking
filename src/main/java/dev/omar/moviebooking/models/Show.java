package dev.omar.moviebooking.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Show extends BaseModel {
    @ManyToOne
    private Movie movie;

    @ManyToOne
    private Theater theater;

    @OneToOne
    private Screen screen;

    private Date startTime;
    private Date endTime;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> features;

    @ManyToOne
    private Language language;
}