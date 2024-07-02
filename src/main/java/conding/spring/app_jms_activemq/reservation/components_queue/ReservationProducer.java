package conding.spring.app_jms_activemq.reservation.components_queue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import conding.spring.app_jms_activemq.reservation.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
//Le producteur envoie les informations de réservation à la file d'attente  activeMQ
public class ReservationProducer {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    public void sendMessage(User user) throws JsonProcessingException {
        String message = objectMapper.writeValueAsString(user);
        jmsTemplate.convertAndSend("reservation.queue", message);
    }
}
