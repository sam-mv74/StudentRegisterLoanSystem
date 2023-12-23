package service;

import base.service.BaseEntityService;
import dto.CreditCardDTO;
import entity.CreditCard;

import java.util.List;

public interface CreditCardService extends BaseEntityService<CreditCard,Integer> {
    List<String> registerCard(CreditCardDTO creditCardDTO);

    List<String> existByCardDetails(CreditCardDTO creditCardDetails);
}
