package org.example.control;

import lombok.RequiredArgsConstructor;
import org.example.dto.RentalDto;
import org.example.service.RentalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RentalController {
    private final RentalService rentalService;

    @GetMapping("/rentals")
    public ResponseEntity<List<RentalDto>> findAllRentals(){
        return ResponseEntity.ok(rentalService.findAllRentals());
    }
}