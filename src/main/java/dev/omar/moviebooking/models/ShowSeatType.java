package dev.omar.moviebooking.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ShowSeatType extends BaseModel {

    private int price;

    @ManyToOne
    private Show show;

    @ManyToOne
    private SeatType seatType;
}
