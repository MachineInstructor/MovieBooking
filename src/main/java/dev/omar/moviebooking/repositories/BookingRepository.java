package dev.omar.moviebooking.repositories;

import dev.omar.moviebooking.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    @Override
    Booking save(Booking booking);
}