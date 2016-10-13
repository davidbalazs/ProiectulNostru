package com.catdav.transactions.parser.impl;

import com.catdav.transactions.parser.TransactionListParser;
import com.catdav.transactions.model.TransactionsContainer;

import java.util.List;

/**
 * PATTERN PRINCIPAL CHELTUIALA:  Valoare cont descriere data
 * -Valoare = valoarea total a cheltuielii, fara moneda (e.g. lei)
 * -Cont = contul cu care s-a facut cheltuiala (ing, ingcat, cash, etc)
 * -Descriere = descrierea cheltuielii, lista de cuvinte (“masa Cata, cumparaturi profi”)
 * -Data = format variabil (8 aug, 10 aug, 10.08)
 * <p>
 * PATTERN PRINCIPAL OPERATIUNE CONT:  Valoare tip_operatiune cont descriere data
 * -Tip_operatiune = scos, intrat
 * <p>
 * PATTERN PRINCIPAL TRANSFER:         Valoare tip_operatiune cont_sursa cont-destinatie descriere data
 * -tip_operatiune = transfer
 */
public class DefaultTransactionListParser implements TransactionListParser {

    public TransactionsContainer parse(List<String> transactionsToBeParsed) {
        return null;
    }
}
