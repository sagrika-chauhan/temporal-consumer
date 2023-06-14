package com.example.temporalconsumer.temporal;

import com.maersk.composition.service.TemporalClientProvider;
import io.temporal.client.WorkflowClient;
import io.temporal.worker.WorkerFactory;
import io.temporal.worker.WorkerFactoryOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class TemporalWorker implements ApplicationRunner {

  @Autowired
  private TemporalClientProvider temporalClientProvider;
  @Autowired
  private SendEmailConfirmationActivityImpl sendEmailConfirmationActivityImpl;
  WorkflowClient client;
  WorkerFactory factory;
  @Override
  public void run(ApplicationArguments args) throws Exception {
    client = temporalClientProvider.getTemporalClientInstance();

    WorkerFactoryOptions workerFactoryOptions = temporalClientProvider.getWorkerFactoryOptions();

    factory = WorkerFactory.newInstance(client, workerFactoryOptions);

    io.temporal.worker.Worker emailWorker = factory.newWorker("sendEmail");

    emailWorker.registerActivitiesImplementations(
      sendEmailConfirmationActivityImpl
    );

    factory.start();
  }
}
