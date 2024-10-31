package batch.jobtest;

import java.util.Random;
import java.util.logging.Logger;

import javax.batch.api.AbstractBatchlet;
import javax.batch.runtime.BatchStatus;
import javax.batch.runtime.context.JobContext;
import javax.inject.Inject;

public class Step4BatchLet extends AbstractBatchlet {

	Logger LOG = Logger.getLogger(Step4BatchLet.class.getName());

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

		if (n <= 2) {
			String statut = BatchStatus.STARTING.toString();
			LOG.info(" - statut du step : " + statut);
			return statut;
		}
		if (n <= 4) {
			String statut = BatchStatus.STARTED.toString();
			LOG.info(" - statut du step : " + statut);
			return statut;
		}
		if (n <= 6) {
			String statut = BatchStatus.STOPPING.toString();
			LOG.info(" - statut du step : " + statut);
			return statut;
		}
		if (n <= 8) {
			String statut = BatchStatus.STOPPED.toString();
			LOG.info(" - statut du step : " + statut);
			return statut;
		}
		if (n <= 10) {
			String statut = BatchStatus.FAILED.toString();
			LOG.info(" - statut du step : " + statut);
			return statut;
		}
		if (n <= 12) {
			String statut = BatchStatus.ABANDONED.toString();
			LOG.info(" - statut du step : " + statut);
			return statut;
		}

		String statut = BatchStatus.COMPLETED.toString();
		LOG.info(" - statut du step : " + statut);
		return statut;

	}
}
