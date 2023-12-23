package repository.impl;

import base.repository.impl.BaseEntityRepositoryImpl;
import entity.CreditCard;
import repository.CreditCardRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Optional;

public class CreditCardRepositoryImpl extends BaseEntityRepositoryImpl<CreditCard, Integer> implements CreditCardRepository {
    public CreditCardRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<CreditCard> getEntityClass() {
        return CreditCard.class;
    }

    @Override
    public Optional<CreditCard> findByCardDetails(CreditCard creditCard) {
        try {
            String hql = "select c from CreditCard c where c.bank = :bank and c.cardNumber= :cardNumber and c.cvv2= :cvv2 and c.expirationDate= :expirationDate and c.student= :student";
            TypedQuery<CreditCard> query = entityManager.createQuery(hql, CreditCard.class);
            query.setParameter("bank", creditCard.getBank());
            query.setParameter("cardNumber", creditCard.getCardNumber());
            query.setParameter("cvv2", creditCard.getCvv2());
            query.setParameter("expirationDate", creditCard.getExpirationDate());
            query.setParameter("student", creditCard.getStudent());
            return Optional.of(query.getSingleResult());
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
