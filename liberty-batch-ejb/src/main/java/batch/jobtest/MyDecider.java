package batch.jobtest;

import java.util.logging.Logger;

import javax.batch.api.Decider;
import javax.batch.runtime.StepExecution;
import javax.inject.Named;

@Named
public class MyDecider implements Decider {

	// private static final Logger LOG = LoggerFactory.getLogger(MyDecider.class);
	Logger LOG = Logger.getLogger(MyDecider.class.getName());

	@Override
	public String decide(StepExecution[] ses) throws Exception {

		LOG.info("------ MyDecider MyDecider MyDecider----------");

		return "?";
	}
}