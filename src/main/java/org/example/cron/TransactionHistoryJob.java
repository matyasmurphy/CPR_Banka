package org.example.cron;

import com.google.inject.Inject;
import org.example.services.TransactionHistoryService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class TransactionHistoryJob implements Job {
    @Inject
    private TransactionHistoryService transactionHistoryService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        transactionHistoryService.saveAndProcessTransactionHistory();
    }
}
