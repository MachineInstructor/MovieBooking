package dev.omar.moviebooking.controllers;

import dev.omar.moviebooking.dtos.CreateBookingRequestDTO;
import dev.omar.moviebooking.dtos.CreateBookingResponseDTO;
import dev.omar.moviebooking.dtos.ResponseStatus;
import dev.omar.moviebooking.models.Booking;
import dev.omar.moviebooking.services.BookingService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/booking")
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/book")
    public CreateBookingResponseDTO createBooking(@RequestBody CreateBookingRequestDTO requestDTO) {
        CreateBookingResponseDTO responseDTO = new CreateBookingResponseDTO();


        try {
            Booking booking = bookingService.createBooking(
                    requestDTO.getUserId(),
                    requestDTO.getShowId(),
                    requestDTO.getShowSeatIds()
            );
            responseDTO.setBooking(booking);
            responseDTO.setResponseStatus(ResponseStatus.SUCCESS);
        } catch(Exception e) {
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDTO;
    }
}
