package com.farmacia.farmacia.prescription.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.farmacia.farmacia.inventory.model.Medicamento;
import com.farmacia.farmacia.inventory.repository.MedicamentoRepository;
import com.farmacia.farmacia.prescription.dto.RecetaItemRequest;
import com.farmacia.farmacia.prescription.dto.RecetaRequest;
import com.farmacia.farmacia.prescription.model.Medico;
import com.farmacia.farmacia.prescription.model.Paciente;
import com.farmacia.farmacia.prescription.model.Receta;
import com.farmacia.farmacia.prescription.model.RecetaDetalle;
import com.farmacia.farmacia.prescription.repository.MedicoRepository;
import com.farmacia.farmacia.prescription.repository.PacienteRepository;
import com.farmacia.farmacia.prescription.repository.RecetaDetalleRepository;
import com.farmacia.farmacia.prescription.repository.RecetaRepository;
import com.farmacia.farmacia.shared.exception.NotFoundException;

@Service
@RequiredArgsConstructor
public class RecetaService {
    private final RecetaRepository recetaRepo;
    private final RecetaDetalleRepository detalleRepo;
    private final PacienteRepository pacienteRepo;
    private final MedicoRepository medicoRepo;
    private final MedicamentoRepository medRepo;

    @Transactional
    public Receta crear(RecetaRequest dto) {
        Paciente paciente = pacienteRepo.findById(dto.getPacienteId())
                .orElseThrow(() -> new NotFoundException("Paciente no encontrado"));
        Medico medico = medicoRepo.findById(dto.getMedicoId())
                .orElseThrow(() -> new NotFoundException("Médico no encontrado"));

        Receta receta = new Receta();
        receta.setPaciente(paciente);
        receta.setMedico(medico);
        receta.setFecha(dto.getFecha());
        receta = recetaRepo.save(receta);

        for (RecetaItemRequest it : dto.getItems()) {
            Medicamento med = medRepo.findById(it.getMedicamentoId())
                    .orElseThrow(() -> new NotFoundException("Medicamento no encontrado"));
            RecetaDetalle d = new RecetaDetalle();
            d.setReceta(receta);
            d.setMedicamento(med);
            d.setCantidad(it.getCantidad());
            d.setIndicaciones(it.getIndicaciones());
            detalleRepo.save(d);
        }
        return receta;
    }
}
