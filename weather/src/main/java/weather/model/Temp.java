package weather.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Temp {
    private final Long id;
    private final String temp;

    public Temp(Long id, String temp){
        this.id = id;
        this.temp = temp;
    }

    @JsonProperty("id")
    public Long getId(){
        return id;
    }

    @JsonProperty("temp")
    public String getTemp() {
        return temp;
    }
}
