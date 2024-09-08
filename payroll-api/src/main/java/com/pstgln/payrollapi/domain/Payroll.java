package com.pstgln.payrollapi.domain;

public record Payroll (
    String workerName,
    String description,
    Double hourlyPrice,
    Double workedHours,
    Double totalPayment
) {}