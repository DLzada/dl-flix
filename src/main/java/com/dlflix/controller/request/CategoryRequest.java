package com.dlflix.controller.request;

import jakarta.validation.constraints.NotEmpty;

public record CategoryRequest(@NotEmpty(message = "O nome da categoria é obrigatoria") String name) {
}
