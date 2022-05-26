package weather.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import weather.model.Temp;


@Service
public class ProducerService implements IProducerService {
    private RabbitTemplate rabbitTemplate;

    @Autowired
    public ProducerService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(Temp temp) {
        rabbitTemplate.convertAndSend("doy.exchange","doy.routingkey", temp);
    }
}
