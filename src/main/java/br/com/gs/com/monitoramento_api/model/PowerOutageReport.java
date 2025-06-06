package br.com.gs.com.monitoramento_api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "power_outage_reports")
public class PowerOutageReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bairro;
    private String cidade;
    private String cep;

    private String eventoNatural;

    private String tempoInterrupcao;

    @Column(columnDefinition = "TEXT")
    private String prejuizos;

    @Column(columnDefinition = "TEXT")
    private String orientacoes;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getBairro() { return bairro; }

    public void setBairro(String bairro) { this.bairro = bairro; }

    public String getCidade() { return cidade; }

    public void setCidade(String cidade) { this.cidade = cidade; }

    public String getCep() { return cep; }

    public void setCep(String cep) { this.cep = cep; }

    public String getEventoNatural() { return eventoNatural; }

    public void setEventoNatural(String eventoNatural) { this.eventoNatural = eventoNatural; }

    public String getTempoInterrupcao() { return tempoInterrupcao; }

    public void setTempoInterrupcao(String tempoInterrupcao) { this.tempoInterrupcao = tempoInterrupcao; }

    public String getPrejuizos() { return prejuizos; }

    public void setPrejuizos(String prejuizos) { this.prejuizos = prejuizos; }

    public String getOrientacoes() { return orientacoes; }

    public void setOrientacoes(String orientacoes) { this.orientacoes = orientacoes; }
}