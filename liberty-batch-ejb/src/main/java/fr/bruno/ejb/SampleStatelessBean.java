package fr.bruno.ejb;

import javax.ejb.Stateless;

@Stateless
public class SampleStatelessBean {

  public String hello() {
    return "Hello EJB World ------------.";
  }
}
