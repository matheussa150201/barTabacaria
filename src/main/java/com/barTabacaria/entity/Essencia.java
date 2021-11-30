package com.barTabacaria.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Essencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "data_cadastro", updatable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCadastro;

    @PrePersist
    public void prePersist(){
        setDataCadastro(LocalDate.now());
    }

    @Column(nullable = false, name = "nome")
    private String nome;

    @Column(nullable = false, name = "marca")
    private String marca;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "sabor")
    private String sabor;

    @Column(nullable = false, name = "valor_compra")
    private Double valorCompra;

    @Column(nullable = false, name = "valor_venda")
    private Double valorVenda;

    @Column(nullable = false, name = "valor_lucro")
    private Double valorLucro;
}
