package batch.jobtest;

import java.util.Random;
import java.util.logging.Logger;

import javax.batch.api.AbstractBatchlet;
import javax.batch.runtime.BatchStatus;
import javax.batch.runtime.context.JobContext;
import javax.inject.Inject;

public class Step3BatchLet extends AbstractBatchlet {

	Logger LOG = Logger.getLogger(Step3BatchLet.class.getName());

	@Inject
	JobContext jobContext;

	@Override
	public String process() throws Exception {

		LOG.info(" - InstanceId : " + jobContext.getInstanceId());
		LOG.info(" - ExecutionId : " + jobContext.getExecutionId());
		LOG.info(" - ExitStatus? : " + jobContext.getExitStatus());

		Random random = new Random();
		int n = random.nextInt(10);

		LOG.info(" - pause de " + n + "s");
		Thread.sleep(n * 1000);

		if (n <= 3) {
			LOG.info(" - Step3BatchLet -- FAILED");
			return BatchStatus.FAILED.toString();
		}

		LOG.info(" - Step3BatchLet -- COMPLETED");
		return BatchStatus.COMPLETED.toString();
	}
}
