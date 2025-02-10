package dev.omar.moviebooking.repositories;

import dev.omar.moviebooking.models.Seat;
import dev.omar.moviebooking.models.SeatType;
import dev.omar.moviebooking.models.Show;
import dev.omar.moviebooking.models.ShowSeatType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowSeatTypeRepository extends JpaRepository<ShowSeatType, Long> {
    ShowSeatType findAllByShowAndSeatType(Show show, SeatType seatType);

    List<ShowSeatType> findAllByShow(Show show);
}
