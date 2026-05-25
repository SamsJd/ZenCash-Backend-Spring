package zencash_backend.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "TRANSACAO")
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transacao_seq")
    @SequenceGenerator(
            name = "transacao_seq",
            sequenceName = "SQ_TRANSACAO",
            allocationSize = 1
    )
    @Column(name = "transacao_id")
    private Long id;

    @Column(name = "conta_origem_id")
    private Long contaOrigemId;

    @Column(name = "tipo_transacao_id")
    private Integer tipoTransacaoId;

    @Column(name = "valor", nullable = false, precision = 18, scale = 2)
    private BigDecimal valor;

    @Column(name = "data_hora")
    private LocalDateTime dataHora;

    @Column(name = "descricao")
    private String descricao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getContaOrigemId() {
        return contaOrigemId;
    }

    public void setContaOrigemId(Long contaOrigemId) {
        this.contaOrigemId = contaOrigemId;
    }

    public Integer getTipoTransacaoId() {
        return tipoTransacaoId;
    }

    public void setTipoTransacaoId(Integer tipoTransacaoId) {
        this.tipoTransacaoId = tipoTransacaoId;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}