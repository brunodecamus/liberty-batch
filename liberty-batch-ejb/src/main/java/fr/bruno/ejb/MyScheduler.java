package fr.bruno.ejb;

import javax.annotation.PostConstruct;
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

  @PostConstruct
  public void onStartup() {
    LOGGER.info("Demarrage de l'application");
  }

  @Schedule(hour = "*", minute = "*/1", second = "0", persistent = false)
  public void runEveryOneMinutes(Timer timer) {
    LOGGER.info("Execution toutes les minutes");
  }
}
