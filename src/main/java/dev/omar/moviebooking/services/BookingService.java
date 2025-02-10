package dev.omar.moviebooking.services;

import dev.omar.moviebooking.models.*;
import dev.omar.moviebooking.repositories.BookingRepository;
import dev.omar.moviebooking.repositories.ShowRepository;
import dev.omar.moviebooking.repositories.ShowSeatRepository;
import dev.omar.moviebooking.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    private final UserRepository userRepository;
    private final ShowRepository showRepository;
    private final ShowSeatRepository showSeatRepository;
    private final BookingRepository bookingRepository;
    private final PriceCalculationService priceCalculationService;

    public BookingService(UserRepository userRepository, ShowRepository showRepository,
                          ShowSeatRepository showSeatRepository,
                          BookingRepository bookingRepository,
                          PriceCalculationService priceCalculationService) {

        this.userRepository = userRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
        this.bookingRepository = bookingRepository;
        this.priceCalculationService = priceCalculationService;
    }

    public Booking createBooking(Long userId, Long showId, List<Long> showSeatIds) {

        Optional<User> optionalUser = userRepository.findById(userId);

        if(optionalUser.isEmpty()) {
            throw new RuntimeException("UserID" + userId + " is Invalid");
        }

        User user = optionalUser.get();

        Optional<Show> optionalShow = showRepository.findById(showId);

        if(optionalShow.isEmpty()) {
            // throw exception
        }

        Show show = optionalShow.get();

        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatIds);

        for(ShowSeat showSeat : showSeats) {
            if(!showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)) {
                throw new RuntimeException("Show seat is not available");
            }
        }

        for(ShowSeat showSeat : showSeats) {
            showSeat.setShowSeatStatus(ShowSeatStatus.BLOCKED);
            showSeatRepository.save(showSeat);
        }

        Booking booking = new Booking();
        booking.setUser(user);
        booking.setBookingStatus(BookingStatus.PENDING);
        booking.setShowSeat(showSeats);
        booking.setShow(show);
        booking.setAmount(priceCalculationService.calculatePrice(show, showSeats));
        
        return bookingRepository.save(booking);
    }
}
