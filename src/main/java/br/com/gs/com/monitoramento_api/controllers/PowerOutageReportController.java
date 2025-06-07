package br.com.gs.com.monitoramento_api.controllers;

import br.com.gs.com.monitoramento_api.dto.PowerOutageReportRequestDto;
import br.com.gs.com.monitoramento_api.dto.PowerOutageReportResponseDto;
import br.com.gs.com.monitoramento_api.services.PowerOutageReportService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/outages")
@Tag(name = "Relatórios de Queda de Energia", description = "Gerencia os registros de interrupções de energia")
public class PowerOutageReportController {

    private final PowerOutageReportService service;

    public PowerOutageReportController(PowerOutageReportService service) {
        this.service = service;
    }

    @PostMapping
    @Operation(summary = "Cria um novo relatório de queda de energia")
    public ResponseEntity<PowerOutageReportResponseDto> create(@RequestBody PowerOutageReportRequestDto dto) {
        var created = service.save(dto);
        var location = URI.create(String.format("/api/outages/%d", created.id));
        return ResponseEntity.created(location).body(created);
    }

    @GetMapping
    @Operation(summary = "Lista todos os relatórios")
    public ResponseEntity<List<PowerOutageReportResponseDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca relatório por ID")
    public ResponseEntity<PowerOutageReportResponseDto> getReportById(@PathVariable Long id) {
        var report = service.findById(id);
        return report != null
                ? ResponseEntity.ok(report)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza um relatório existente")
    public ResponseEntity<PowerOutageReportResponseDto> update(
            @PathVariable Long id,
            @RequestBody PowerOutageReportRequestDto dto) {
        var updated = service.update(id, dto);
        return updated != null
                ? ResponseEntity.ok(updated)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove um relatório por ID")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean deleted = service.deleteById(id);
        return deleted
                ? ResponseEntity.noContent().build()
                : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}