package org.example.services;

import com.google.gson.Gson;
import com.google.inject.Inject;
import org.example.logger.Logger;
import org.example.serialization.TransactionSerializationJsonService;
import org.example.transactions.Transaction;
import org.example.transactions.manager.TransactionManager;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.stream.Collectors;

public class TransactionHistoryService {

    @Inject
    private TransactionManager transactionManager;

    @Inject
    private TransactionSerializationJsonService transactionSerializationJsonService;

    @Inject
    private Gson gson;

    @Inject
    private Logger logger;

    public void saveAndProcessTransactionHistory() {
        logger.log("processAndSaveTransactionHistory called");

        ArrayList<Transaction> transactions = transactionManager.getTransactions();
        logger.log("Total transactions found: " + transactions.size());

        Map<String, ArrayList<Transaction>> transactionsByAccount = transactions.stream()
                .collect(Collectors.groupingBy(Transaction::getAccountUuid, Collectors.toCollection(ArrayList::new)));

        transactionsByAccount.forEach((accountUuid, accountTransactions) -> {
            if (accountTransactions.isEmpty()) {
                System.out.println("No transactions found for account: " + accountUuid);
                return;
            }

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String dateSuffix = dateFormat.format(new Date());
            String filePath = "C:\\Users\\Murphy Matyáš Josef\\IdeaProjects\\CPR_Banka\\data";
            String fileName = accountUuid + "-TransactionHistory-" + dateSuffix + ".json";
            new File(filePath).mkdirs();

            try (FileWriter writer = new FileWriter(filePath + "\\" + fileName)) {
                gson.toJson(accountTransactions, writer);
            } catch (IOException e) {
                logger.log("Error saving transactions: " + e.getMessage());
            }
        });
    }
}
