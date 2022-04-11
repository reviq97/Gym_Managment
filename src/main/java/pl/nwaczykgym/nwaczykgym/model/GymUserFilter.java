package pl.nwaczykgym.nwaczykgym.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class GymUserFilter {
    private String pesel;
    private String city;
}
