package com.example.demospringbatch.batch;

import com.example.demospringbatch.domain.oferta.OfertaEntity;
import lombok.AllArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@AllArgsConstructor
public class BatchConfig {

    private final JobRepository jobRepository;
    private final PlatformTransactionManager transactionManager;

    @Bean
    public Step exemploStep(ItemReader<OfertaEntity> reader,
                            ItemWriter<OfertaEntity> writer) {
        return new StepBuilder("exemploStep", jobRepository)
                .<OfertaEntity, OfertaEntity>chunk(10, transactionManager)
                .reader(reader)
                .writer(writer)
                .allowStartIfComplete(true)// Permite reexecução mesmo se estiver COMPLETED
                .build();
    }

    @Bean
    public Job exemploJob(Step exemploStep) {
        return new JobBuilder("exemploJob", jobRepository)
                .start(exemploStep)
                .build();
    }
}