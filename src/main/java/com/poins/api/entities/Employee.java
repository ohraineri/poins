package com.poins.api.entities;

import lombok.Value;
import lombok.Builder;
import java.util.Date;
import com.poins.api.enums.Journey;


@Value
@Builder
public class Employee {
    String firstName;
    String lastName;
    Date dateBirth;
    Journey journey;
}
