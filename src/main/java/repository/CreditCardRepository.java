package repository;

import base.repository.BaseEntityRepository;
import entity.CreditCard;

import java.util.Optional;

public interface CreditCardRepository extends BaseEntityRepository<CreditCard,Integer> {
    Optional<CreditCard> findByCardDetails(CreditCard creditCard);
}
