package weather.service;

import weather.model.Temp;

public interface IProducerService {
    public void sendMessage(Temp temp);
}
