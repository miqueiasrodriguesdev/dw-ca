package com.miqueias_r.infrastructure.rest.dto.response;

import java.time.LocalDateTime;

public record ErrorResponse(int status, String message, LocalDateTime timestamp) {
}
