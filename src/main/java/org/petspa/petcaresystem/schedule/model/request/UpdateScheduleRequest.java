package org.petspa.petcaresystem.schedule.model.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.petspa.petcaresystem.enums.Status;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdateScheduleRequest {
    LocalDate date;
    Long doctor_id;
    Status status;
}
