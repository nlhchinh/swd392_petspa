package org.petspa.petcaresystem.department.model.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateDepartmentRequest {
    String departmentName;
    String address;
}
