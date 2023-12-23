package service.impl;

import base.service.impl.BaseEntityServiceImpl;
import dto.CreditCardDTO;
import entity.CreditCard;
import entity.Student;
import entity.enumeration.Bank;
import repository.CreditCardRepository;
import service.CreditCardService;
import service.validation.CardValidation;
import utility.SecurityContext;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class CreditCardServiceImpl extends BaseEntityServiceImpl<CreditCard, Integer, CreditCardRepository>
        implements CreditCardService {
    public CreditCardServiceImpl(CreditCardRepository repository) {
        super(repository);
    }

    @Override
    public List<String> registerCard(CreditCardDTO creditCardDTO) {
        Student currentStudent = SecurityContext.getCurrentStudent();
        List<String> results = CardValidation.validateCardDTO(creditCardDTO);
        boolean isValid = results.isEmpty();
        if (isValid) {
            CreditCard card = new CreditCard();
            card.setBank(Bank.valueOf(creditCardDTO.getBank().toUpperCase()));
            card.setCardNumber(creditCardDTO.getCardNumber());
            card.setCvv2(Integer.parseInt(creditCardDTO.getCvv2()));
            card.setExpirationDate(convertExpireDate(creditCardDTO));
            card.setStudent(currentStudent);
            if (repository.findByCardDetails(card).isEmpty()) {
                repository.saveOrUpdate(card);
            }
        }
        return results;
    }

    @Override
    public List<String> existByCardDetails(CreditCardDTO creditCardDTO) {
        Student currentStudent = SecurityContext.getCurrentStudent();
        List<String> results = CardValidation.validateCardDTO(creditCardDTO);
        boolean isValid = results.isEmpty();
        if (isValid) {
            CreditCard card = new CreditCard();
            card.setBank(Bank.valueOf(creditCardDTO.getBank().toUpperCase()));
            card.setCardNumber(creditCardDTO.getCardNumber());
            card.setCvv2(Integer.parseInt(creditCardDTO.getCvv2()));
            card.setExpirationDate(convertExpireDate(creditCardDTO));
            card.setStudent(currentStudent);
            if (repository.findByCardDetails(card).isEmpty())
                results.add("This Card Is Not Registered For User");
        }
        return results;
    }

    private LocalDate convertExpireDate(CreditCardDTO creditCardDTO) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(creditCardDTO.getExpirationDate(), formatter);
    }
}
