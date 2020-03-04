package com.rabobank.chris.model.generator;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.enhanced.SequenceStyleGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.LongType;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.util.Properties;

/**
 * This generator generates id for PowerOfAttorney
 * It generates sequential id with 4 zero fills in the form of string
 * e.g. 0001, 0002, etc
 */
public class POASequenceGenerator extends SequenceStyleGenerator {

    /**
     * Generates 4 zero filled id in string
     * @param session
     * @param object
     * @return
     * @throws HibernateException
     */
    @Override
    public Serializable generate(SharedSessionContractImplementor session,
                                 Object object) throws HibernateException {
        Integer id = Integer.valueOf((Integer) super.generate(session, object));
        return generateId(id);
    }

    protected String generateId(Integer id) {
        return String.format("%04d", id);
    }

    /**
     * Hibernate can not handle string based sequences, thus we set the Type parameter to LongType
     * @param type
     * @param params
     * @param serviceRegistry
     * @throws MappingException
     */
    @Override
    public void configure(Type type, Properties params,
                          ServiceRegistry serviceRegistry) throws MappingException {
        super.configure(LongType.INSTANCE, params, serviceRegistry);
    }
}
