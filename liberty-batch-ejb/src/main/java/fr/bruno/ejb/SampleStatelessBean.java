package fr.bruno.ejb;

import javax.ejb.Stateless;

@Stateless
public class SampleStatelessBean {

  // /** LOGGER */
  // private static final Logger LOGGER = LoggerFactory.getLogger(MyScheduler.class);

  public String hello() {
    // LOGGER.info("gggggggggggg");
    return "Hello EJB World ------------.";
  }
}
