package fr.bruno.ejb;

import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless(name = "SampleStatelessBean")
public class SampleStatelessBean {

  /** LOGGER */
  private static final Logger LOGGER = LoggerFactory.getLogger(SampleStatelessBean.class);

  public String hello() {
    LOGGER.info("On est dans SampleStatelessBean");
    return "Hello EJB World";
  }
}
