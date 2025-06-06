package br.com.gs.com.monitoramento_api.repository;

import br.com.gs.com.monitoramento_api.model.PowerOutageReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PowerOutageReportRepository extends JpaRepository<PowerOutageReport, Long> {
}
