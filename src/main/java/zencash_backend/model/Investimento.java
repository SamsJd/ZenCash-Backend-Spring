package zencash_backend.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "CARTEIRA_INVESTIMENTO")
public class Investimento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "carteira_seq")
    @SequenceGenerator(
            name = "carteira_seq",
            sequenceName = "SQ_CARTEIRA",
            allocationSize = 1
    )
    @Column(name = "carteira_id")
    private Long id;

    @Column(name = "cliente_id", nullable = false)
    private Long clienteId;

    @Column(name = "produto_id", nullable = false)
    private Long produtoId;

    @Column(name = "quantidade")
    private BigDecimal quantidade;

    @Column(name = "valor_unitario_medio", precision = 18, scale = 2)
    private BigDecimal valorUnitarioMedio;

    @Column(name = "data_compra")
    private LocalDate dataCompra;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Long getClienteId() {
        return clienteId;
    }
    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public Long getProdutoId() {
        return produtoId;
    }
    public void setProdutoId(Long produtoId) {
        this.produtoId = produtoId;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValorUnitarioMedio() {
        return valorUnitarioMedio;
    }
    public void setValorUnitarioMedio(BigDecimal valorUnitarioMedio) {
        this.valorUnitarioMedio = valorUnitarioMedio;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }
    public void setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
    }
}