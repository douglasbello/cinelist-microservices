package com.cinelist.ms.catalog.dtos.certificates;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CertificateRequest(@NotNull(message = "Age cannot be null.") @NotBlank(message = "Age cannot be blank.") String age) {
}