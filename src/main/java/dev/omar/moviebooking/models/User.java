package dev.omar.moviebooking.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class User extends BaseModel {
    private String name;
    private String email;
    private String password;

    @OneToMany
    private List<Booking> bookings;
}
