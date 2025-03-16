package com.example.demospringbatch.domain.oferta;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "status_oferta")
public class StatusOfertaEntity {

    @Id
    @Column(name = "id_status_oferta")
    private Integer id;

    @Column(name = "descricao_status_oferta", nullable = false)
    private String descricao;
}