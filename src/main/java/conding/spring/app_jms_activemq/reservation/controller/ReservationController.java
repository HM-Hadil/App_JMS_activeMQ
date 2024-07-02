package conding.spring.app_jms_activemq.reservation.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import conding.spring.app_jms_activemq.reservation.components_queue.ReservationProducer;
import conding.spring.app_jms_activemq.reservation.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservations")

public class ReservationController {
    @Autowired
    private ReservationProducer reservationProducer;

    @PostMapping
    public String createReservation(@RequestBody User user) {
        try {
            reservationProducer.sendMessage(user);
            return "Reservation added to the queue";
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "Error adding reservation to the queue";
        }}

}
