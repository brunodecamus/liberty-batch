package batch.jobtest;

import java.util.Random;
import java.util.logging.Logger;

import javax.batch.api.AbstractBatchlet;
import javax.batch.runtime.context.JobContext;
import javax.inject.Inject;

public class Step2BatchLet extends AbstractBatchlet {

  Logger LOG = Logger.getLogger(Step2BatchLet.class.getName());

  @Inject
  JobContext jobContext;

  @Override
  public String process() throws Exception {

    LOG.info(" - InstanceId : " + jobContext.getInstanceId());
    LOG.info(" - ExecutionId : " + jobContext.getExecutionId());
    LOG.info(" - ExitStatus? : " + jobContext.getExitStatus());
    LOG.info(" - TransientUserData : " + jobContext.getTransientUserData());

    Random random = new Random();
    int n = random.nextInt(20);

    LOG.info(" - pause de " + n + "s");
    Thread.sleep(n * 1000);

    if (n < 9) {
      LOG.info(" => STEP_3");
      return "STEP_3";
    }

    if (n < 18) {
      LOG.info(" => STEP_4");
      return "STEP_4";
    }

    throw new Exception("Valeur de n : " + n);
  }
}
