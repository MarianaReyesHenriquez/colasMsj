package notes.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Temp {
    private Long id;
    private String temp;

    public Temp() {
    }

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
