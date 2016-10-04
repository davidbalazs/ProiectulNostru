import com.catdav.transactions.model.Account;
import com.catdavd.transactions.providers.AccountsProvider;
import com.catdavd.transactions.providers.impl.DefaultAccountsProvider;
import exceptions.AccountsRetrievalException;

import java.util.List;

/**
 * Dummy class used only for tests.
 * Created by David on 10/4/2016.
 */
public class TransactionsPersisterMain {
    public static void main(String[] args) throws AccountsRetrievalException {
        AccountsProvider accountsProvider = new DefaultAccountsProvider();
        List<Account> accountList = accountsProvider.getAccounts();
        System.out.println(accountList);
    }
}
