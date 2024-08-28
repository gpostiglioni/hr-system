package com.pstgln.usuario.resources.exceptions;

import java.time.LocalDateTime;

public record StandardError(
        LocalDateTime timestamp,
        String error,
        Integer status,
        String path) {}
