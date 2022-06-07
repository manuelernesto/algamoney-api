package io.github.manuelernesto.money.api.repository.filter;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * @author Manuel Ernesto (manuelernest0)
 * @version 1.0
 * @date 06/06/22 9:13 PM
 */

public record LaunchFilter(String description, @DateTimeFormat(pattern = "yyyy-MM-dd")
LocalDate dueDateFrom, @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dueDateTo) {
}
