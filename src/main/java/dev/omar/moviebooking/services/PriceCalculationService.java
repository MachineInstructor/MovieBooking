package dev.omar.moviebooking.services;

import dev.omar.moviebooking.models.Show;
import dev.omar.moviebooking.models.ShowSeat;
import dev.omar.moviebooking.models.ShowSeatType;
import dev.omar.moviebooking.repositories.ShowSeatTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceCalculationService {
    private final ShowSeatTypeRepository showSeatTypeRepository;

    public PriceCalculationService(ShowSeatTypeRepository showSeatTypeRepository) {
         this.showSeatTypeRepository = showSeatTypeRepository;
    }

    public int calculatePrice(Show show, List<ShowSeat> showSeats) {
        List<ShowSeatType> showSeatTypes = showSeatTypeRepository.findAllByShow(show);

        int price = 0;

        for(ShowSeat showSeat : showSeats) {
            for(ShowSeatType showSeatType : showSeatTypes) {
                if(showSeat.getSeat().getSeatType().equals(showSeatType.getSeatType())) {
                    price +=  showSeatType.getPrice();
                }
            }
        }
        return price;
    }
}
