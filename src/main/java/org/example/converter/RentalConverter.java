package org.example.converter;

import org.example.dto.RentalDto;
import org.example.model.Rental;
import org.springframework.stereotype.Component;

@Component
public class RentalConverter extends Converter<RentalDto , Rental>{
    public RentalConverter() {
        super(RentalConverter::convertToEntity, RentalConverter::convertToDto);
    }

    private static RentalDto convertToDto(Rental rental){
        return new RentalDto(new BookConverter().convertFromEntity(rental.getBook()), new PersonConverter().convertFromEntity(rental.getPerson()),
                rental.getRentedOn(), rental.getRentedUntil(), rental.getReturnedOn(), rental.isReturned());
    }

    private static Rental convertToEntity(RentalDto dto){
        return new Rental (new BookConverter().convertFromDto(dto.getBookDto()), new PersonConverter().convertFromDto(dto.getPersonDto()),dto.getRentedOn(),
                dto.getRentedUntil(), dto.getReturnedOn(), dto.isReturned());
    }
}