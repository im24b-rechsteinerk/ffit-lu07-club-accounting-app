package ch.bzz.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id", nullable = false, unique = true)
    private Long id;

    @Column(name = "booking_number", nullable = false)
    private Integer bookingNumber;

    @Column(name = "booking_date", nullable = false)
    private LocalDate date;

    @Column(name = "booking_text", nullable = false, length = 255)
    private String text;

    @ManyToOne
    @JoinColumn(name = "debit_account_id", nullable = false)
    private Account debitAccount;

    @ManyToOne
    @JoinColumn(name = "credit_account_id", nullable = false)
    private Account creditAccount;

    @Column(name = "amount", nullable = false, precision = 12, scale = 2)
    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name = "project_name", nullable = false)
    private Project project;
}
