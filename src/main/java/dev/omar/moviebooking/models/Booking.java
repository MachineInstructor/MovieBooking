package dev.omar.moviebooking.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Booking extends BaseModel {

    private int amount;

    @ManyToOne
    private User user;

    @ManyToOne
    private Show show;

    @OneToMany
    private List<ShowSeat> showSeat;

    @OneToMany
    private List<Payment> payment;

    @Enumerated(EnumType.ORDINAL)
    private BookingStatus bookingStatus;

}
