package se.ifmo.operations.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public record PriceReduceDto(
        @Min(value = 0, message = "Percent must be >= 0")
        @Max(value = 100, message = "Percent must be <= 100")
        double percent
) {
}
