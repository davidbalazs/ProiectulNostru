import com.catdav.transactions.parser.date.impl.DefaultDateParser;
import com.catdav.transactions.parser.exceptions.DateParseException;

import java.time.LocalDate;

public class TransactionParserMain {
    static public void main(String[] args) throws DateParseException {
        DefaultDateParser dp = new DefaultDateParser();

        String dateString = null;
        //LocalDate localDate2 = dp.parse(dateString);
        LocalDate localDate3 = dp.parse("1a feb");






    }
}
