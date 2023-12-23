package utility;

import menu.*;
import repository.*;
import repository.impl.*;
import service.*;
import service.impl.*;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class ApplicationContext {

    private static EnrollMenu enrollMenu;
    private static LoginMenu loginMenu;
    private static RegisterLoanMenu registerLoanMenu;
    private static RegisterHousingLoanMenu registerHousingLoanMenu;
    private static RegisterEducationalLoanMenu registerEducationalLoanMenu;
    private static RegisterTuitionLoanMenu registerTuitionLoanMenu;

    private static final EntityManager entityManager =
            Persistence.createEntityManagerFactory(
                    "default"
            ).createEntityManager();

    private static PersonRepository personRepository;
    private static StudentRepository studentRepository;
    private static AddressRepository addressRepository;
    private static CityRepository cityRepository;
    private static UniversityRepository universityRepository;
    private static InstallmentRepository installmentRepository;
    private static CreditCardRepository creditCardRepository;
    private static EducationalLoanRepository educationalLoanRepository;
    private static TuitionLoanRepository tuitionLoanRepository;
    private static HousingLoanRepository housingLoanRepository;
    //
    private static EducationalLoanCategoryRepository educationalLoanCategoryRepository;
    private static HousingLoanCategoryRepository housingLoanCategoryRepository;
    private static TuitionLoanCategoryRepository tuitionLoanCategoryRepository;
    //
    private static AddressService addressService;
    private static CityService cityService;
    private static StudentService studentService;
    private static UniversityService universityService;
    private static InstallmentService installmentService;
    private static CreditCardService creditCardService;
    private static EducationalLoanService educationalLoanService;
    private static HousingLoanService housingLoanService;
    private static TuitionLoanService tuitionLoanService;
    //
    private static EducationalLoanCategoryService educationalLoanCategoryService;
    private static HousingLoanCategoryService housingLoanCategoryService;
    private static TuitionLoanCategoryService tuitionLoanCategoryService;
    //
    private static PersonService personService;

    public static EntityManager getEntityManager() {
        return entityManager;
    }

    public static AddressRepository getAddressRepository() {
        if (addressRepository == null) {
            addressRepository = new AddressRepositoryImpl(entityManager);
        }
        return addressRepository;
    }

    public static CityRepository getCityRepository() {
        if (cityRepository == null) {
            cityRepository = new CityRepositoryImpl(entityManager);
        }
        return cityRepository;
    }

    public static StudentRepository getStudentRepository() {
        if (studentRepository == null) {
            studentRepository = new StudentRepositoryImpl(entityManager);
        }
        return studentRepository;
    }

    public static UniversityRepository getUniversityRepository() {
        if (universityRepository == null) {
            universityRepository = new UniversityRepositoryImpl(entityManager);
        }
        return universityRepository;
    }

    public static InstallmentRepository getInstallmentRepository() {
        if (installmentRepository == null) {
            installmentRepository = new InstallmentRepositoryImpl(entityManager);
        }
        return installmentRepository;
    }

    public static CreditCardRepository getCreditCardRepository() {
        if (creditCardRepository == null) {
            creditCardRepository = new CreditCardRepositoryImpl(entityManager);
        }
        return creditCardRepository;
    }

    public static EducationalLoanRepository getEducationalLoanRepository() {
        if (educationalLoanRepository == null) {
            educationalLoanRepository = new EducationalLoanRepositoryImpl(entityManager);
        }
        return educationalLoanRepository;
    }

    public static TuitionLoanRepository getTuitionLoanRepository() {
        if (tuitionLoanRepository == null) {
            tuitionLoanRepository = new TuitionLoanRepositoryImpl(entityManager);
        }
        return tuitionLoanRepository;
    }

    public static HousingLoanRepository getHousingLoanRepository() {
        if (housingLoanRepository == null) {
            housingLoanRepository = new HousingLoanRepositoryImpl(entityManager);
        }
        return housingLoanRepository;
    }

    //
    public static EducationalLoanCategoryRepository getEducationalLoanCategoryRepository() {
        if (educationalLoanCategoryRepository == null) {
            educationalLoanCategoryRepository = new EducationalLoanCategoryRepositoryImpl(entityManager);
        }
        return educationalLoanCategoryRepository;
    }

    public static TuitionLoanCategoryRepository getTuitionLoanCategoryRepository() {
        if (tuitionLoanCategoryRepository == null) {
            tuitionLoanCategoryRepository = new TuitionLoanCategoryRepositoryImpl(entityManager);
        }
        return tuitionLoanCategoryRepository;
    }

    public static HousingLoanCategoryRepository getHousingLoanCategoryRepository() {
        if (housingLoanCategoryRepository == null) {
            housingLoanCategoryRepository = new HousingLoanCategoryRepositoryImpl(entityManager);
        }
        return housingLoanCategoryRepository;
    }

    //
    public static PersonRepository getPersonRepository() {
        if (personRepository == null) {
            personRepository = new PersonRepositoryImpl(entityManager);
        }
        return personRepository;
    }

    public static AddressService getAddressService() {
        if (addressService == null) {
            addressService = new AddressServiceImpl(
                    getAddressRepository()
            );
        }
        return addressService;
    }

    public static CityService getCityService() {
        if (cityService == null) {
            cityService = new CityServiceImpl(
                    getCityRepository()
            );
        }
        return cityService;
    }

    public static StudentService getStudentService() {
        if (studentService == null) {
            studentService = new StudentServiceImpl(
                    getStudentRepository()
            );
        }
        return studentService;
    }


    public static InstallmentService getInstallmentService() {
        if (installmentService == null) {
            installmentService = new InstallmentServiceImpl(
                    getInstallmentRepository()
            );
        }
        return installmentService;
    }

    public static CreditCardService getCreditCardService() {
        if (creditCardService == null) {
            creditCardService = new CreditCardServiceImpl(
                    getCreditCardRepository()
            );
        }
        return creditCardService;
    }


    public static EducationalLoanService getEducationalLoanService() {
        if (educationalLoanService == null) {
            educationalLoanService = new EducationalLoanServiceImpl(
                    getEducationalLoanRepository()
            );
        }
        return educationalLoanService;
    }

    public static TuitionLoanService getTuitionLoanService() {
        if (tuitionLoanService == null) {
            tuitionLoanService = new TuitionLoanServiceImpl(
                    getTuitionLoanRepository()
            );
        }
        return tuitionLoanService;
    }

    public static HousingLoanService getHousingLoanService() {
        if (housingLoanService == null) {
            housingLoanService = new HousingLoanServiceImpl(
                    getHousingLoanRepository()
            );
        }
        return housingLoanService;
    }

    //
    public static EducationalLoanCategoryService getEducationalLoanCategoryService() {
        if (educationalLoanCategoryService == null) {
            educationalLoanCategoryService = new EducationalLoanCategoryServiceImpl(
                    getEducationalLoanCategoryRepository()
            );
        }
        return educationalLoanCategoryService;
    }

    public static TuitionLoanCategoryService getTuitionLoanCategoryService() {
        if (tuitionLoanCategoryService == null) {
            tuitionLoanCategoryService = new TuitionLoanCategoryServiceImpl(
                    getTuitionLoanCategoryRepository()
            );
        }
        return tuitionLoanCategoryService;
    }

    public static HousingLoanCategoryService getHousingLoanCategoryService() {
        if (housingLoanCategoryService == null) {
            housingLoanCategoryService = new HousingLoanCategoryServiceImpl(
                    getHousingLoanCategoryRepository()
            );
        }
        return housingLoanCategoryService;
    }
    //

    public static PersonService getPersonService() {
        if (personService == null) {
            personService = new PersonServiceImpl(
                    getPersonRepository()
            );
        }
        return personService;
    }

    public static UniversityService getUniversityService() {
        if (universityService == null) {
            universityService = new UniversityServiceImpl(
                    getUniversityRepository()
            );
        }
        return universityService;
    }

    public static EnrollMenu getEnrollMenu() {
        if (enrollMenu == null)
            enrollMenu = new EnrollMenu();
        return enrollMenu;
    }

    public static LoginMenu getLoginMenu() {
        if (loginMenu == null)
            loginMenu = new LoginMenu();
        return loginMenu;
    }

    public static RegisterLoanMenu getRegisterLoanMenu() {
        if (registerLoanMenu == null)
            registerLoanMenu = new RegisterLoanMenu();
        return registerLoanMenu;
    }

    public static RegisterHousingLoanMenu getRegisterHousingLoanMenu() {
        if (registerHousingLoanMenu == null)
            registerHousingLoanMenu = new RegisterHousingLoanMenu();

        return registerHousingLoanMenu;
    }

    public static RegisterEducationalLoanMenu getRegisterEducationalLoanMenu() {
        if (registerEducationalLoanMenu == null)
            registerEducationalLoanMenu = new RegisterEducationalLoanMenu();
        return registerEducationalLoanMenu;
    }

    public static RegisterTuitionLoanMenu getRegisterTuitionLoanMenu() {
        if (registerTuitionLoanMenu == null)
            registerTuitionLoanMenu = new RegisterTuitionLoanMenu();

        return registerTuitionLoanMenu;
    }
}
