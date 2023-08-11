package com.smallworld;

import com.fasterxml.jackson.core.type.TypeReference;
import com.smallworld.Model.Transaction;
import org.codehaus.jackson.JsonParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.sql.SQLRecoverableException;
import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.*;

public class TransactionAmount {

//    public static void main(String[] args) throws IOException {
//
//        ObjectMapper mapper = new ObjectMapper();
//
//        List<Transaction> transactions = mapper.readValue(new File("transactions.json"), new TypeReference<List<Transaction>>() {});
//
//        Double totalTransactionAmount = 0.0;
//
////        System.out.println("Transaction -> " + transactions);
////
////        for(Transaction transaction : transactions)
////        {
////            System.out.println(transaction + "\n");
////        }
//
//        for(Transaction transaction : transactions)
//        {
//            totalTransactionAmount += transaction.getAmount();
//        }
//
//        System.out.println("The Total Transaction Amount is:\t" + totalTransactionAmount);
//
//    }

//    try
//    {
//        FileReader reader = new FileReader("transactions.json");
//        //Object obj = jsonParser.parse();
//    }
//    catch(FileNotFoundException e)
//    {
//        e.printStackTrace();
//    }
//
//    public TransactionAmount() throws FileNotFoundException {
//    }

//    public static void main(String[] args) throws IOException {
//
//        ObjectMapper mapper = new ObjectMapper();
//
//        List<Transaction> transactions = mapper.readValue(new File("transactions.json"), new TypeReference<List<Transaction>>() {});
//
//        Double maxTransactionAmount = 0.0;
//        maxTransactionAmount = transactions.get(0).getAmount();
//
//        for (Transaction transaction : transactions) {
//            if (transaction.getAmount() >= maxTransactionAmount) {
//                maxTransactionAmount = transaction.getAmount();
//            }
//        }
//
//        System.out.println("The Maximum Transaction Amount is:\t" + maxTransactionAmount);
//    }

//    public static void main(String[] args) throws IOException {
//
//        ObjectMapper mapper = new ObjectMapper();
//
//        List<Transaction> transactions = mapper.readValue(new File("transactions.json"), new TypeReference<List<Transaction>>() {});
//
//        Transaction temp;
//
//        List<Transaction> top3Transactions = new ArrayList<>();
//
//        for (int i=0; i<transactions.size(); i++)
//        {
//            for (int j = i+1; j<transactions.size(); j++)
//            {
//                if (transactions.get(i).getAmount() < transactions.get(j).getAmount())
//                {
//                    temp = transactions.get(i);
//                    transactions.set(i, transactions.get(j));
//                    transactions.set(j, temp);
//                }
//            }
//        }
//
//        for (int i=0; i<=2; i++)
//        {
//            top3Transactions.add(transactions.get(i));
//            System.out.println(top3Transactions.get(i) + "\n");
//        }
//
//    }

//        public static void main(String[] args) throws IOException {
//
//        ObjectMapper mapper = new ObjectMapper();
//
//        List<Transaction> transactions = mapper.readValue(new File("transactions.json"), new TypeReference<List<Transaction>>() {});
//
//        List<Transaction> beneficiaryTransactions = new ArrayList<>();
//
//        String beneficiaryFullName = "Michael Gray";
//
//        for (Transaction transaction : transactions)
//        {
//            if (transaction.getBeneficiaryFullName().equals(beneficiaryFullName))
//                beneficiaryTransactions.add(transaction);
//        }
//
//        for (Transaction transaction : beneficiaryTransactions)
//        {
//            System.out.println(transaction + "\n");
//        }
//    }

//    public static void main(String[] args) throws IOException {
//
//        ObjectMapper mapper = new ObjectMapper();
//
//        List<Transaction> transactions = mapper.readValue(new File("transactions.json"), new TypeReference<List<Transaction>>() {});
//
//        Double maxtotalAmountSent = 0.0;
//        Double totalAmountSentByUser = 0.0;
//        String senderName = "";
//
//
//
//        for(Transaction transaction : transactions)
//        {
//            totalAmountSentByUser = getTotalTransactionAmountSentBy(transaction.getSenderFullName());
//
//            if(totalAmountSentByUser > maxtotalAmountSent)
//            {
//                maxtotalAmountSent = totalAmountSentByUser;
//                senderName = transaction.getSenderFullName();
//            }
//        }
//
//        System.out.println("The Top Sender is: " + senderName + " with " + maxtotalAmountSent + " amount sent.");
//
//    }
//
//    public static double getTotalTransactionAmountSentBy(String senderFullName) throws IOException {
//        ObjectMapper mapper = new ObjectMapper();
//
//        try {
//            List<Transaction> transactions = mapper.readValue(new File("transactions.json"), new TypeReference<List<Transaction>>() {});
//
//            //senderFullName = "Grace Burgess";
//
//            Double totalTransactionAmount = 0.0;
//
//
//            for(Transaction transaction : transactions)
//            {
//                if (transaction.getSenderFullName().equals(senderFullName))
//                    totalTransactionAmount += transaction.getAmount();
//            }
//
//            System.out.println("The Total Transaction Amount Sent By "+ senderFullName + " is:\t" + totalTransactionAmount);
//
//            return totalTransactionAmount;
//
//        }
//        catch (IOException e)
//        {
//            throw new IOException(e);
//        }
//    }

//    public static void main(String[] args) throws IOException {
//
//        ObjectMapper mapper = new ObjectMapper();
//
//        List<Transaction> transactions = mapper.readValue(new File("transactions.json"), new TypeReference<List<Transaction>>() {});
//
//        List<String> Clients = new ArrayList<>();
//
//        for(Transaction transaction : transactions)
//        {
//            if(!Clients.contains(transaction.getSenderFullName()))
//            {
//                Clients.add(transaction.getSenderFullName());
//            }
//
//            if(!Clients.contains(transaction.getBeneficiaryFullName()))
//            {
//                Clients.add(transaction.getBeneficiaryFullName());
//            }
//        }
//
//        System.out.println(Clients);
//        System.out.println("The Number of Unique Clients are: " + Clients.size());
//
//    }

//    public static void main(String[] args) throws IOException {
//
//        ObjectMapper mapper = new ObjectMapper();
//
//        List<Transaction> transactions = mapper.readValue(new File("transactions.json"), new TypeReference<List<Transaction>>() {});
//
//        String clientFullName = "Tom Shelby";
//
//        for(Transaction transaction : transactions)
//        {
//           if(transaction.getSenderFullName().equals(clientFullName) || transaction.getBeneficiaryFullName().equals(clientFullName))
//           {
//               if(!transaction.getIssueSolved())
//               {
//                   System.out.println("true");
//                   break;
//               }
//           }
//        }
//        //System.out.println("false");
//    }

//    public static void main(String[] args) throws IOException {
//
//        ObjectMapper mapper = new ObjectMapper();
//
//        List<Transaction> transactions = mapper.readValue(new File("transactions.json"), new TypeReference<List<Transaction>>() {});
//
//        Set<Integer> UnsolvedIssueIds = new HashSet<>();
//
//        for(Transaction transaction : transactions)
//        {
//            if(!transaction.getIssueSolved())
//            {
//                UnsolvedIssueIds.add(transaction.getMtn());
//            }
//        }
//
//        System.out.println(UnsolvedIssueIds);
//
//        //return UnsolvedIssueIds;
//    }

    public static void main(String[] args) throws IOException {

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

        System.out.println(SolvedIssueMessages);

        //return UnsolvedIssueIds;
    }

}
