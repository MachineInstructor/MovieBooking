package dev.omar.moviebooking.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Actor extends BaseModel {
    private String name;
}
