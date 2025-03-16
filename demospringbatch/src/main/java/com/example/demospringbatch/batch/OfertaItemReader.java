package com.example.demospringbatch.batch;

import com.example.demospringbatch.domain.oferta.OfertaEntity;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.batch.item.database.builder.JpaPagingItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OfertaItemReader {

    @Bean
    public JpaPagingItemReader<OfertaEntity> reader(EntityManagerFactory entityManagerFactory) {
        return new JpaPagingItemReaderBuilder<OfertaEntity>()
                .name("ofertaReader")
                .entityManagerFactory(entityManagerFactory)
                .queryString("SELECT o FROM OfertaEntity o WHERE o.statusOferta.id = 1")
                .pageSize(10)
                .transacted(true) // Garantir que a transação seja gerenciada corretamente
                .build();
    }

}
