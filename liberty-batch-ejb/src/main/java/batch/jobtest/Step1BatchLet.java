package batch.jobtest;

import java.util.Random;
import java.util.logging.Logger;

import javax.batch.api.AbstractBatchlet;
import javax.batch.api.BatchProperty;
import javax.batch.runtime.BatchStatus;
import javax.batch.runtime.context.JobContext;
import javax.inject.Inject;

public class Step1BatchLet extends AbstractBatchlet {

  private Logger LOG = Logger.getLogger(Step1BatchLet.class.getName());

  @Inject
  JobContext jobContext;

  @Inject
  @BatchProperty(name = "timeMax")
  private String timeMax;

  @Inject
  @BatchProperty(name = "keep")
  private String keep;

  @Override
  public String process() throws Exception {

    LOG.info(" - InstanceId : " + jobContext.getInstanceId());
    LOG.info(" - ExecutionId : " + jobContext.getExecutionId());
    LOG.info(" - ExitStatus? : " + jobContext.getExitStatus());

    LOG.info(" - keep : " + keep);
    LOG.info(" - timeMax : " + timeMax);

    Random random = new Random();
    int n = random.nextInt(new Integer(timeMax));
    LOG.info(" - Random n : " + n);

    LOG.info(" - pause de " + n + "s");
    Thread.sleep(n * 1000);

    if (n <= new Integer(keep)) {
      LOG.info("(n <= 7) => FAILED");
      return BatchStatus.FAILED.toString();
    }

    LOG.info(" => COMPLETED");
    return BatchStatus.COMPLETED.toString();
  }
}
