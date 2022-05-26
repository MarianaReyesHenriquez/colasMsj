package weather.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import weather.model.Temp;
import weather.model.Temperatura;

@Service
public class ConsumerService {

    private static final Logger logger = LoggerFactory.getLogger(ConsumerService.class);

    @Autowired
    private ITimeService timeService;

    @Autowired
    private IProducerService producerService;

    @RabbitListener(queues = "dame.queue")
    public void receivedMessage(Long id) {
        logger.info("Id recieved: " + id);
        Temperatura temperatura =  timeService.getByCity("Madrid");
        Temp temp = new Temp(id, temperatura.getTemp());
        producerService.sendMessage(temp);
        logger.info("Id sent: " + temp.getId() + " - Temp sent: " + temp.getTemp());
    }

}
