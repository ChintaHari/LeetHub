class Solution {
    
    class Transaction{
        String name;
        int time;
        int amount;
        String city;
        
        Transaction(String line){
            String[] transactionAttributes = line.split(",");
            name = transactionAttributes[0];
            time = Integer.parseInt(transactionAttributes[1]);
            amount = Integer.parseInt(transactionAttributes[2]);
            city = transactionAttributes[3];
        }
    }
    
    public List<String> invalidTransactions(String[] transactions) {
        Map<String, List<Transaction>> map = new HashMap<>();
        List<String> invalidTransactions = new ArrayList<>();
        
        for(String transaction : transactions){
            Transaction t = new Transaction(transaction);
            map.computeIfAbsent(t.name, k -> new ArrayList<>()).add(t);
        }
        
        for(String transaction : transactions){
            Transaction t = new Transaction(transaction);
            if(! isValidTransaction(t, map.getOrDefault(t.name, Collections.emptyList())))
                invalidTransactions.add(transaction);
        }
        return invalidTransactions;
    }
    
    public boolean isValidTransaction(Transaction memberTransaction, List<Transaction> listOfMemberTransactions){
        if(memberTransaction.amount > 1000)
            return false;
        for(Transaction transaction : listOfMemberTransactions){
            if(Math.abs(transaction.time - memberTransaction.time ) <= 60
               && !transaction.city.equals(memberTransaction.city))
                return false;
        }
        
        return true;
    }
}