package notes.service;

import notes.model.Temp;

public interface IConsumerService {
    public void receivedMessage(Temp temp);
}
