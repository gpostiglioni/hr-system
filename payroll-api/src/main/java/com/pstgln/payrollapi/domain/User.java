package com.pstgln.payrollapi.domain;

public record User(
        Long id,
        String name,
        String email,
        String password,
        Double hourlyPrice) {}