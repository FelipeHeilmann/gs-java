package br.com.gs.com.monitoramento_api.services;

import br.com.gs.com.monitoramento_api.dto.PowerOutageReportRequestDto;
import br.com.gs.com.monitoramento_api.dto.PowerOutageReportResponseDto;
import br.com.gs.com.monitoramento_api.model.PowerOutageReport;
import br.com.gs.com.monitoramento_api.repository.PowerOutageReportRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PowerOutageReportService {

    private final PowerOutageReportRepository repository;

    public PowerOutageReportService(PowerOutageReportRepository repository) {
        this.repository = repository;
    }

    public PowerOutageReportResponseDto save(PowerOutageReportRequestDto dto) {
        PowerOutageReport report = new PowerOutageReport();
        report.setBairro(dto.bairro);
        report.setCidade(dto.cidade);
        report.setCep(dto.cep);
        report.setTempoInterrupcao(dto.tempoInterrupcao);
        report.setPrejuizos(dto.prejuizos);
        report.setOrientacoes(dto.orientacoes);

        PowerOutageReport saved = repository.save(report);
        return mapToResponseDto(saved);
    }

    public List<PowerOutageReportResponseDto> findAll() {
        return repository.findAll().stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    public PowerOutageReportResponseDto findById(Long id) {
        return repository.findById(id)
                .map(this::mapToResponseDto)
                .orElse(null);
    }

    private PowerOutageReportResponseDto mapToResponseDto(PowerOutageReport report) {
        PowerOutageReportResponseDto dto = new PowerOutageReportResponseDto();
        dto.id = report.getId();
        dto.bairro = report.getBairro();
        dto.cidade = report.getCidade();
        dto.cep = report.getCep();
        dto.tempoInterrupcao = report.getTempoInterrupcao();
        dto.prejuizos = report.getPrejuizos();
        dto.orientacoes = report.getOrientacoes();
        return dto;
    }
}