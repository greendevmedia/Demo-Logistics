package in.greendev.logistics.util;

import com.sun.org.apache.regexp.internal.RE;
import in.greendev.logistics.model.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.method.P;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class TestEntityProvider {

    //pymentType
    public static final PaymentType PAYMENT_TYPE_CASH = PaymentType.CASH;
    public static final PaymentType PAYMENT_TYPE_DKV = PaymentType.DKV;
    public static final ActivityType ACTIVITY_TYPE_DELIVERY = ActivityType.DELIVERY;
    public static final ActivityType ACTIVITY_TYPE_RECEPTION = ActivityType.RECEPTION;

    //page
    public static final Pageable pageRequest = new PageRequest(1,60);

    //car
    public static final Car CAR1 = new Car(1L, "GD184NU - IV04");
    public static final Car CAR2= new Car(2L, "GD199MX - IV03");
    public static final Car CAR3 = new Car(3L, "GD540LY - IV02");
    public static final Car CAR4 = new Car(4L, "GD763KC - IV01");

    public static final List<Car> CARS = Arrays.asList(CAR1, CAR2, CAR3, CAR4);
    public static final List<Car> CARS_EMPTY = Arrays.asList();
    public static final Page<Car> CARS_PAGE = new PageImpl<Car>(CARS_EMPTY);

    //currency
    public static final Currency CURRENCY1 = new Currency(1L, "PLN");
    public static final Currency CURRENCY2 = new Currency(2L, "EUR");

    public static final List<Currency> CURRENCIES = Arrays.asList(CURRENCY1, CURRENCY2);
    public static final List<Currency> CURRENCIES_EMPTY = Arrays.asList();
    public static final Page<Currency> CURRENCIES_PAGE = new PageImpl<Currency>(CURRENCIES_EMPTY);

    //additoinalPaymentName
    public static final AdditionalPaymentName ADDITIONAL_PAYMENT_NAME1 = new AdditionalPaymentName(1L, "Autostrada");
    public static final AdditionalPaymentName ADDITIONAL_PAYMENT_NAME2 = new AdditionalPaymentName(1L, "Prom");

    public static final List<AdditionalPaymentName> ADDITIONAL_PAYMENT_NAMES = Arrays.asList(ADDITIONAL_PAYMENT_NAME1, ADDITIONAL_PAYMENT_NAME2);
    public static final List<AdditionalPaymentName> ADDITIONAL_PAYMENT_NAMES_EMPTY = Arrays.asList();
    public static final Page<AdditionalPaymentName> TRAILER_PAGE = new PageImpl<AdditionalPaymentName>(ADDITIONAL_PAYMENT_NAMES_EMPTY);

    //trailer
    public static final Trailer TRAILER1 = new Trailer(1L, "GD 7897X p 2.49t");
    public static final Trailer TRAILER2 = new Trailer(2L, "GD 6235X p 2.50t");

    public static final List<Trailer> TRAILERS = Arrays.asList(TRAILER1, TRAILER2);
    public static final List<Trailer> TRAILERS_EMPTY = Arrays.asList();
    public static final Page<Trailer> TRAILERS_PAGE = new PageImpl<Trailer>(TRAILERS_EMPTY);

    //additonalPayment
    public static final AdditionalPayment ADDITIONAL_PAYMENT1 = new AdditionalPayment(1L, LocalDate.now(), ADDITIONAL_PAYMENT_NAME1, 20.2, PAYMENT_TYPE_CASH, CURRENCY1, "Włodzimierz Fertyk", CAR1);
    public static final AdditionalPayment ADDITIONAL_PAYMENT2 = new AdditionalPayment(2L, LocalDate.now(), ADDITIONAL_PAYMENT_NAME2, 20.2, PAYMENT_TYPE_DKV, CURRENCY2, "Paweł Plewiński", CAR2);

    public static final List<AdditionalPayment> ADDITIONAL_PAYMENTS = Arrays.asList(ADDITIONAL_PAYMENT1, ADDITIONAL_PAYMENT2);
    public static final List<AdditionalPayment> ADDITIONAL_PAYMENTS_EMPTY = Arrays.asList();
    public static final Page<AdditionalPayment> ADDITIONAL_PAYMENTS_PAGE = new PageImpl<AdditionalPayment>(ADDITIONAL_PAYMENTS_EMPTY);

    //refueling
    public static final Refueling REFUELING1 = new Refueling(1L, LocalDate.now(), 1224.3, 234.3, 34.56, PAYMENT_TYPE_DKV, "Krzysiek Chojnacki", CAR1, CURRENCY1, "Warning", 1.1, 2.2);
    public static final Refueling REFUELING2 = new Refueling(2L, LocalDate.now(), 1264.3, 2345.3, 354.56, PAYMENT_TYPE_CASH, "Tomasz Czekała", CAR2, CURRENCY2, "Warning note", 61.1, 25.2);

    public static final  List<Refueling> REFUELINGS = Arrays.asList(REFUELING1, REFUELING2);
    public static final List<Refueling> REFUELINGS_EMPTY = Arrays.asList();
    public static final Page<Refueling> REFUELING_PAGE = new PageImpl<Refueling>(REFUELINGS_EMPTY);

    //repair
    public static final Repair REPAIR1 = new Repair(1L, LocalDate.now(), 34.5, 34.3, "Wymiana oleju", "Adam Ciechański", "Gdańsk, Grunwaldzka", CAR1, TRAILER1, ACTIVITY_TYPE_DELIVERY, "Warning");
    public static final Repair REPAIR2 = new Repair(2L, LocalDate.now(), 3.67, 349.09, "Wymiana opon", "Leszek Tecław", "Gdańsk, Obrońców wybrzeża", CAR2, TRAILER2, ACTIVITY_TYPE_RECEPTION, "Warnign");

    public static final List<Repair> REPAIRS = Arrays.asList(REPAIR1, REPAIR2);
    public static final List<Repair> REPAIRS_EMPTY = Arrays.asList();
    public static final Page<Repair> REPAIRS_PAGE = new PageImpl<Repair>(REPAIRS_EMPTY);


}
