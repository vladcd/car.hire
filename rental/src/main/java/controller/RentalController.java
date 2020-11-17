package controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ro.agilehub.javacourse.car.hire.api.model.Reservation;
import ro.agilehub.javacourse.car.hire.api.model.ResourceCreatedDTO;
import ro.agilehub.javacourse.car.hire.api.model.ResponseDTO;
import ro.agilehub.javacourse.car.hire.api.specification.RentApi;

import javax.validation.Valid;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
public class RentalController implements RentApi {

    @Override
    public ResponseEntity<ResourceCreatedDTO> createReservation(@Valid Reservation reservation) {
        ResourceCreatedDTO resourceCreatedDTO = new ResourceCreatedDTO();
        resourceCreatedDTO.setId(1L);
        return ResponseEntity.ok(resourceCreatedDTO);
    }

    @Override
    public ResponseEntity<ResponseDTO> deleteReservation(Integer id) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setMessage("Reservation has been successfully");
        return ResponseEntity.ok(responseDTO);
    }

    @Override
    public ResponseEntity<List<Reservation>> getAllReservations(@Valid String status) {
        List<Reservation> reservations = new ArrayList<>();
        reservations.add(mockReservation());
        return ResponseEntity.ok(reservations);
    }

    @Override
    public ResponseEntity<Reservation> getReservationByID(Integer id) {
        return ResponseEntity.ok(mockReservation());
    }

    @Override
    public ResponseEntity<ResponseDTO> updateReservationDetails(Integer id, @Valid Reservation reservation) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setMessage("Reservation has been updated successfully");
        return ResponseEntity.ok(responseDTO);
    }

    private Reservation mockReservation() {
        Reservation reservation = new Reservation();
        reservation.setCarID(1L);
        reservation.setEndDateTime(OffsetDateTime.now());
        reservation.setStartDateTime(OffsetDateTime.now());
        reservation.setStatus("ACTIVE");
        reservation.setUserID(1L);

        return reservation;
    }
}
