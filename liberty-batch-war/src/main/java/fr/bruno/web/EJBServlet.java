package fr.bruno.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.bruno.ejb.MyScheduler;
import fr.bruno.ejb.SampleStatelessBean;

@WebServlet({ "/", "/liberty-batchServlet" })
public class EJBServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  /** LOGGER */
  private static final Logger LOGGER = LoggerFactory.getLogger(MyScheduler.class);

  @EJB
  MyScheduler myScheduler;

  @EJB
  SampleStatelessBean statelessBean;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    LOGGER.info("doGet ............");

    PrintWriter writer = response.getWriter();

    // Call hello method on a stateless session bean
    String message = statelessBean.hello();

    writer.println(message);
  }
}
