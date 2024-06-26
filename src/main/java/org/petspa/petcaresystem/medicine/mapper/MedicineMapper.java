package org.petspa.petcaresystem.medicine.mapper;

import org.petspa.petcaresystem.medicine.model.entity.Medicine;
import org.petspa.petcaresystem.medicine.model.response.MedicineResponse;

public class MedicineMapper {
    public static MedicineResponse toMedicineResponse(Medicine medicine){
        return MedicineResponse.builder()
                .medicine_id(medicine.getMedicine_id())
                .medicineName(medicine.getMedicine_name())
                .price(medicine.getPrice())
                .medicalRecords(medicine.getMedicalRecord())
                .status(medicine.getStatus())
                .build();
    }
}
