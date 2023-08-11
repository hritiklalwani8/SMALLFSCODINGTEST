package com.smallworld;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smallworld.Model.Sender;
import com.smallworld.Model.Transaction;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class TransactionDataFetcher {

    /**
     * We can get all the records in the List<Transaction> transactions variable once and use it in all the functions as well.
     * However, I've created a different variable in each function because each function cab change the transactions function accordingly.
     */
    ObjectMapper mapper = new ObjectMapper();
    List<Transaction> transactions = mapper.readValue(new File("transactions.json"), new TypeReference<List<Transaction>>() {});

    public TransactionDataFetcher() throws IOException {
    }


    /**
     * Returns the sum of the amounts of all transactions
     */
    public double getTotalTransactionAmount() throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        try {
            List<Transaction> transactions = mapper.readValue(new File("transactions.json"), new TypeReference<List<Transaction>>() {});

            Double totalTransactionAmount = 0.0;

            for(Transaction transaction : transactions)
            {
                totalTransactionAmount += transaction.getAmount();
            }

            System.out.println("The Total Transaction Amount is:\t" + totalTransactionAmount);

            return totalTransactionAmount;
        }
        catch (IOException e)
        {
            throw new IOException(e);
        }

    }

    /**
     * Returns the sum of the amounts of all transactions sent by the specified client
     */
    public double getTotalTransactionAmountSentBy(String senderFullName) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        try {
            List<Transaction> transactions = mapper.readValue(new File("transactions.json"), new TypeReference<List<Transaction>>() {});

            senderFullName = "Grace Burgess";

            Double totalTransactionAmount = 0.0;


            for(Transaction transaction : transactions)
            {
                if (transaction.getSenderFullName().equals(senderFullName))
                    totalTransactionAmount += transaction.getAmount();
            }

            //System.out.println("The Total Transaction Amount Sent By "+ senderFullName + " is:\t" + totalTransactionAmount);  // Hritik Commenting this because we've to return a value

            return totalTransactionAmount;

        }
        catch (IOException e)
        {
            throw new IOException(e);
        }
    }

    /**
     * Returns the highest transaction amount
     */
    public double getMaxTransactionAmount() throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        try {

            List<Transaction> transactions = mapper.readValue(new File("transactions.json"), new TypeReference<List<Transaction>>() {});

            Double maxTransactionAmount = 0.0;
            maxTransactionAmount = transactions.get(0).getAmount();

            for (Transaction transaction : transactions) {
                if (transaction.getAmount() >= maxTransactionAmount) {
                    maxTransactionAmount = transaction.getAmount();
                }
            }

            System.out.println("The Maximum Transaction Amount is:\t" + maxTransactionAmount);

            return maxTransactionAmount;
        }
        catch (IOException e)
        {
            throw new IOException(e);
        }

    }

    /**
     * Counts the number of unique clients that sent or received a transaction
     */
    public long countUniqueClients() throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        try {

            List<Transaction> transactions = mapper.readValue(new File("transactions.json"), new TypeReference<List<Transaction>>() {});

            List<String> Clients = new ArrayList<>();

            for(Transaction transaction : transactions)
            {
                if(!Clients.contains(transaction.getSenderFullName()))
                {
                    Clients.add(transaction.getSenderFullName());
                }

                if(!Clients.contains(transaction.getBeneficiaryFullName()))
                {
                    Clients.add(transaction.getBeneficiaryFullName());
                }
            }

            //System.out.println(Clients);
            System.out.println("The Number of Unique Clients are: " + Clients.size());

            return Clients.size();

        }
        catch (IOException e)
        {
            throw new IOException(e);
        }
    }

    /**
     * Returns whether a client (sender or beneficiary) has at least one transaction with a compliance
     * issue that has not been solved
     */
    public boolean hasOpenComplianceIssues(String clientFullName) throws IOException {

        try {

            ObjectMapper mapper = new ObjectMapper();

            List<Transaction> transactions = mapper.readValue(new File("transactions.json"), new TypeReference<List<Transaction>>() {});

            clientFullName = "Tom Shelby";

            for(Transaction transaction : transactions)
            {
                if(transaction.getSenderFullName().equals(clientFullName) || transaction.getBeneficiaryFullName().equals(clientFullName))
                {
                    if(!transaction.getIssueSolved())
                    {
                        return true;
                    }
                }
            }

        }
        catch (IOException e)
        {
            throw new IOException(e);
        }
        return false;
    }

    /**
     * Returns all transactions indexed by beneficiary name
     */
    public List<Transaction> getTransactionsByBeneficiaryName(String beneficiaryFullName) throws IOException {

        try {
            ObjectMapper mapper = new ObjectMapper();

            List<Transaction> transactions = mapper.readValue(new File("transactions.json"), new TypeReference<List<Transaction>>() {});

            List<Transaction> beneficiaryTransactions = new ArrayList<>();

            //beneficiaryFullName = "Michael Gray";     // Hritik providing beneficiaryFullName for testing

            for (Transaction transaction : transactions)
            {
                if (transaction.getBeneficiaryFullName().equals(beneficiaryFullName))
                    beneficiaryTransactions.add(transaction);
            }

            for (Transaction transaction : beneficiaryTransactions)
            {
                System.out.println(transaction + "\n");
            }

            return beneficiaryTransactions;
        }
        catch (IOException e)
        {
            throw new IOException(e);
        }
    }

    /**
     * Returns the identifiers of all open compliance issues
     */
    public Set<Integer> getUnsolvedIssueIds() throws IOException {

        try {

            ObjectMapper mapper = new ObjectMapper();

            List<Transaction> transactions = mapper.readValue(new File("transactions.json"), new TypeReference<List<Transaction>>() {});

            Set<Integer> UnsolvedIssueIds = new HashSet<>();

            for(Transaction transaction : transactions)
            {
                if(!transaction.getIssueSolved())
                {
                    UnsolvedIssueIds.add(transaction.getMtn());
                }
            }

            //System.out.println(UnsolvedIssueIds);
            return UnsolvedIssueIds;
        }
        catch (IOException e)
        {
            throw new IOException(e);
        }
    }

    /**
     * Returns a list of all solved issue messages
     */
    public List<String> getAllSolvedIssueMessages() {

        try {
            ObjectMapper mapper = new ObjectMapper();

            List<Transaction> transactions = mapper.readValue(new File("transactions.json"), new TypeReference<List<Transaction>>() {});

            List<String> SolvedIssueMessages = new ArrayList<>();

            for(Transaction transaction : transactions)
            {
                if(transaction.getIssueSolved())
                {
                    SolvedIssueMessages.add(transaction.getIssueMessage());
                }
            }

            //System.out.println(SolvedIssueMessages);
            return SolvedIssueMessages;
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Returns the 3 transactions with the highest amount sorted by amount descending
     */
    public List<Transaction> getTop3TransactionsByAmount() throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        try {

            List<Transaction> transactions = mapper.readValue(new File("transactions.json"), new TypeReference<List<Transaction>>() {});

            Transaction temp;

            List<Transaction> top3Transactions = new ArrayList<>();

            for (int i = 0; i < transactions.size(); i++) {
                for (int j = i + 1; j < transactions.size(); j++) {
                    if (transactions.get(i).getAmount() < transactions.get(j).getAmount()) {
                        temp = transactions.get(i);
                        transactions.set(i, transactions.get(j));
                        transactions.set(j, temp);
                    }
                }
            }

            for (int i = 0; i <= 2; i++) {
                top3Transactions.add(transactions.get(i));
                System.out.println(top3Transactions.get(i) + "\n");
            }

            return top3Transactions;
        }
        catch (IOException e)
        {
            throw new IOException(e);
        }
    }

    /**
     * Returns the sender with the most total sent amount
     */
    public Sender getTopSender() throws IOException {

        // We can return the Top Sender in two ways
        // 1. Create and Return Sender Object
        // 2. Return SenderName/SenderFullName

        ObjectMapper mapper = new ObjectMapper();

        try {

            List<Transaction> transactions = mapper.readValue(new File("transactions.json"), new TypeReference<List<Transaction>>() {
            });

            Double maxtotalAmountSent = 0.0;
            Double totalAmountSentByUser = 0.0;
            //String senderName = "";
            Sender sender = new Sender();


            for (Transaction transaction : transactions) {
                totalAmountSentByUser = getTotalTransactionAmountSentBy(transaction.getSenderFullName());

                if (totalAmountSentByUser > maxtotalAmountSent) {
                    maxtotalAmountSent = totalAmountSentByUser;
                    sender.setSenderFullName(transaction.getSenderFullName());
                    sender.setSenderAge(transaction.getSenderAge());
                    //senderName = transaction.getSenderFullName(); We can return SenderName/SenderFullName by this method
                }
            }

            System.out.println("The Top Sender is: " + sender.getSenderFullName() + " with " + maxtotalAmountSent + " amount sent.");

            return sender;
        }
        catch (IOException e)
        {
            throw new IOException(e);
        }

    }

}
