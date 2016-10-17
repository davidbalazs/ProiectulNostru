import com.catdav.transactions.parser.accounts.impl.DefaultAccountParser;
import com.catdav.transactions.parser.date.impl.DefaultDateParser;
import com.catdav.transactions.parser.exceptions.AccountParseException;
import com.catdav.transactions.parser.exceptions.DateParseException;
import org.apache.log4j.BasicConfigurator;

import java.time.LocalDate;

public class TransactionParserMain {
    static public void main(String[] args) throws DateParseException {
        DefaultDateParser dp = new DefaultDateParser();

        String dateString = null;
        //LocalDate localDate2 = dp.parse(dateString);
        //LocalDate localDate3 = dp.parse("1a feb");


        DefaultAccountParser dac = new DefaultAccountParser();

        try {
            System.out.println("ing    parsed:"+dac.parse("ing"));
            System.out.println("ingcat parsed:"+dac.parse("ingcat"));
            System.out.println("bcr    parsed:"+dac.parse("bcr"));
            System.out.println("ecocat parsed:"+dac.parse("ecocat"));
            System.out.println("ecodav parsed:"+dac.parse("ecodav"));
            System.out.println("bonuri parsed:"+dac.parse("bonuri"));
            //exception
            System.out.println(dac.parse("blabla"));

        } catch (AccountParseException e) {
            e.printStackTrace();
        }







    }
}
