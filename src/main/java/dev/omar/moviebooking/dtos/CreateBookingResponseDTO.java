package dev.omar.moviebooking.dtos;

import dev.omar.moviebooking.models.Booking;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateBookingResponseDTO {
    private Booking booking;
    private ResponseStatus responseStatus;
}

/*
/Users/omar/Documents/IdeaProjects/MovieBooking/src/main/java/dev/omar/moviebooking/controllers/BookingController.java:35:91
java: incompatible types: dev.omar.moviebooking.dtos.BookingResponseStatus cannot be converted to org.springframework.web.bind.annotation.ResponseStatus
 */