package fr.bruno.ejb;

import java.util.Properties;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Startup
@Singleton
public class MyScheduler {

  /** LOGGER */
  private static final Logger LOGGER = LoggerFactory.getLogger(MyScheduler.class);

  private JobOperator jobOperator;

  @PostConstruct
  public void onStartup() {
    LOGGER.info("Demarrage du Scheduler pour la programation des batchs");
    jobOperator = BatchRuntime.getJobOperator();
    LOGGER.info("Init de jobOperator OK");
  }

  @Schedule(hour = "*", minute = "*/1", second = "0", persistent = false)
  public void runEveryOneMinutes(Timer timer) {

    LOGGER.info("Execution toutes les minutes");

    LOGGER.info("----@Schedule simpleBatchLet.xml---Start---");

    Random random = new Random();

    Properties jobParameters = new Properties();

    new Integer(random.nextInt(100));

    jobParameters.put("param_2", "" + random.nextInt(100));
    jobParameters.put("param_8", "" + random.nextInt(100));
    jobParameters.put("param_78", "" + random.nextInt(100));

    jobOperator.start("jobTest", jobParameters);
    LOGGER.info("----@Schedule simpleBatchLet.xml----End--");

  }
}
