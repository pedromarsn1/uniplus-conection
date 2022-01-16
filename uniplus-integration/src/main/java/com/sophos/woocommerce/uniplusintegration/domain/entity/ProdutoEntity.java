package com.sophos.woocommerce.uniplusintegration.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "produto")
public class ProdutoEntity {
    @Id
    private Long id;
    private String codigo;

    @Column(name = "nomeecf")
    private String nomeEcf;

    private Boolean inativo;
    private BigDecimal preco;

    @Column(name = "precopauta4")
    private BigDecimal precoPautaQuatro;

    @Column(name = "dataalteracao")
    private LocalDateTime dataAlteracao;

    @Column(name = "datacadastro")
    private LocalDateTime dataCadastro;
}
