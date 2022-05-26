package notes.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import notes.model.Temp;

@Service
public class ConsumerService {

    private static final Logger logger = LoggerFactory.getLogger(ConsumerService.class);

    @Autowired
    private INoteService noteService;

    @RabbitListener(queues = "doy.queue")
    public void receivedMessage(Temp temp) {
        logger.info("Id recieved: " + temp.getId() + " - Temp received: " + temp.getTemp());

        noteService.actualizarTemp(temp.getTemp(), temp.getId());
    }

}
