package com.example.demospringbatch.batch;

import com.example.demospringbatch.domain.oferta.OfertaEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OfertaItemWriter implements ItemWriter<OfertaEntity> {
    @Override
    public void write(Chunk<? extends OfertaEntity> chunk) throws Exception {
        chunk.getItems().forEach(oferta -> {
            // Implemente aqui a lógica de gravação, como persistir no repositório
            log.info("XXXXXXXXXXXXXX Salvando oferta: {}", oferta);
        });
    }
}