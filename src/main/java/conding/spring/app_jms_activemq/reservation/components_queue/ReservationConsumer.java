package conding.spring.app_jms_activemq.reservation.components_queue;

import com.fasterxml.jackson.databind.ObjectMapper;
import conding.spring.app_jms_activemq.reservation.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ReservationConsumer {

    @Autowired
    private ObjectMapper objectMapper;

    @JmsListener(destination = "reservation.queue")
    public void receiveMessage(String message) {
        try {
            User user = objectMapper.readValue(message, User.class);
            System.out.println("Received reservation for user: " + user.getUsername());
            // Add logic to handle the reservation here
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
