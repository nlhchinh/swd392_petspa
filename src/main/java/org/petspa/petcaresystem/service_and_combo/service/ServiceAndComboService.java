package org.petspa.petcaresystem.service_and_combo.service;

import java.util.Collection;

import org.petspa.petcaresystem.service_and_combo.model.Combo;
import org.petspa.petcaresystem.service_and_combo.model.Services;
import org.springframework.stereotype.Service;

@Service
public interface ServiceAndComboService {

    public Collection<Services> findAllService();

    public Services findServiceById(String serviceId);

    public Services saveService(Services service);

    public Services updateService(Services service);

    public Services deleteService(String serviceId);

    public Collection<Combo> findAllCombo();

    public Combo findComboById(String comboId);

    public Combo saveCombo(Combo combo);

    public Combo updateCombo(Combo combo);

    public Combo deleteCombo(String comboId);
}
