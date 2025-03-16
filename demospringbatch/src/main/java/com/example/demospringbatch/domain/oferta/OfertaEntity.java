package com.example.demospringbatch.domain.oferta;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "oferta")
public class OfertaEntity {

    @Id
    @GeneratedValue
    @Column(name = "id_oferta", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "id_status_oferta", nullable = false)
    private StatusOfertaEntity statusOferta;
}