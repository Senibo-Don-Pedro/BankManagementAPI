package com.senibo.bank_management_api.Generator;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.HibernateException;

import java.io.Serializable;
import java.util.concurrent.ThreadLocalRandom;

public class AccountNumberGenerator implements IdentifierGenerator {
    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object)
            throws HibernateException {
        // Generate a random 10-digit number
        long min = 1000000000L;   // 1,000,000,000
        long max = 9999999999L;  // 9,999,999,999
        return ThreadLocalRandom.current().nextLong(min, max + 1);
    }
}
