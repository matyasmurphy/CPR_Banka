package org.example.factories;

import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;

public class JobFactory {

    public JobDetail createJob(Class<? extends Job> jobClass, String jobName, String groupName) {
        return JobBuilder.newJob(jobClass)
                .withIdentity(jobName, groupName)
                .build();
    }
}
