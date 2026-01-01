package com.poins.api.entities;

import lombok.Value;
import lombok.Builder;
import java.text.DateFormat;
import com.poins.api.enums.Journey;


@Value
@Builder
public class Employee {
    String firstName;
    String lastName;
    DateFormat dateBirth;
    Journey journey;
}
