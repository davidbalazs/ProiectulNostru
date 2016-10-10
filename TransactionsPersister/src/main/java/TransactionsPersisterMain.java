import com.catdav.transactions.model.Account;
import com.catdav.transactions.model.TransactionsContainer;
import com.catdav.transactions.persister.TransactionsPersister;
import com.catdav.transactions.persister.impl.DefaultTransactionsPersister;
import com.catdav.transactions.providers.AccountsProvider;
import com.catdav.transactions.providers.impl.DefaultAccountsProvider;
import com.catdav.transactions.exceptions.AccountsRetrievalException;

import java.util.List;

/**
 * Dummy class used only for tests.
 * Created by David on 10/4/2016.
 */
public class TransactionsPersisterMain {
    public static void main(String[] args) throws AccountsRetrievalException {
//        AccountsProvider accountsProvider = new DefaultAccountsProvider();
//        List<Account> accountList = accountsProvider.getAccounts();
//        System.out.println(accountList);

        TransactionsPersister transactionsPersister=new DefaultTransactionsPersister();
        transactionsPersister.persist(new TransactionsContainer());
    }
}
