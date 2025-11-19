package org.example.cron;

import com.google.inject.Inject;
import org.example.factories.FactoryTrigger;
import org.example.factories.JobFactory;
import org.example.logger.Logger;
import org.quartz.*;

public class QuartzSchedulerService {
    @Inject
    JobFactory jobFactory;

    @Inject
    FactoryTrigger factoryTrigger;

    public void scheduleJob(Scheduler scheduler, Class<? extends Job> jobClass, String groupName, int intervalInMinutes) throws SchedulerException {
        String jobName = jobClass.getName();
        JobDetail job = jobFactory.createJob(jobClass, jobName, groupName);
        String triggerName = jobName + "Trigger";
        Trigger trigger = factoryTrigger.createTrigger(triggerName, groupName, intervalInMinutes);

        scheduler.scheduleJob(job, trigger);
    }
}
