package batch.jobtest;

import java.util.Random;
import java.util.logging.Logger;

import javax.batch.api.AbstractBatchlet;
import javax.batch.api.BatchProperty;
import javax.batch.runtime.BatchStatus;
import javax.batch.runtime.context.JobContext;
import javax.inject.Inject;

public class Step1BatchLet extends AbstractBatchlet {

	// java.util.logging.Logger
	Logger LOG = Logger.getLogger(Step1BatchLet.class.getName());

	@Inject
	JobContext jobContext;

	@BatchProperty
	private String propertyName1;

	@Override
	public String process() throws Exception {

		LOG.info(" - InstanceId : " + jobContext.getInstanceId());
		LOG.info(" - ExecutionId : " + jobContext.getExecutionId());
		LOG.info(" - ExitStatus? : " + jobContext.getExitStatus());
		LOG.info(" - propertyName1 : " + propertyName1);

		Random random = new Random();
		int n = random.nextInt(21);

		LOG.info(" - pause de " + n + "s");
		Thread.sleep(n * 1000);

		if (n <= 7) {
			LOG.info(" => FAILED");
			return BatchStatus.FAILED.toString();
		}

		jobContext.setTransientUserData("Valeur step 1 " + n);

		LOG.info(" => COMPLETED");
		return BatchStatus.COMPLETED.toString();
	}
}
