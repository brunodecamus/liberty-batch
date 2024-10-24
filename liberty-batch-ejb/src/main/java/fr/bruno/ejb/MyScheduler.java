package fr.bruno.ejb;

import javax.annotation.PostConstruct;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timer;

@Startup
@Singleton
public class MyScheduler {

  @PostConstruct
  public void onStartup() {
    System.out.println("L'application a démerrée");
  }

  @Schedule(hour = "*", minute = "*", second = "*/5", persistent = false)
  public void runEveryFiveMinutes(Timer timer) {
    System.out.println("Execution toute les 5 seconce : " + timer.getInfo());
  }
}
