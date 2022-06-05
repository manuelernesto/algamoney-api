package io.github.manuelernesto.money.api.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Manuel Ernesto (manuelernest0)
 * @version 1.0
 * @date 05/06/22 3:54 PM
 */
@Data
@Entity
@Table(name = "launch")
public class Launch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private String observation;
    private BigDecimal amount;

    @Column(name = "due_date")
    private LocalDate dueDate;
    private LocalDate payday;

    @Enumerated(EnumType.STRING)
    private Type type;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;
}

