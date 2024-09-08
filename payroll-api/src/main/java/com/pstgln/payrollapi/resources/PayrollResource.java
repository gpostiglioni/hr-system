package com.pstgln.payrollapi.resources;

import com.pstgln.payrollapi.domain.Payroll;
import com.pstgln.payrollapi.domain.User;
import com.pstgln.payrollapi.integration.UsuarioClient;
import com.pstgln.payrollapi.services.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/payments")
public class PayrollResource {

    private final PayrollService payrollService;

    @Autowired
    public PayrollResource(PayrollService payrollService) {
        this.payrollService = payrollService;
    }

    @PostMapping(value = "/{workerId}")
    public ResponseEntity<Payroll> getPayment(
            @PathVariable Long workerId,
            @RequestBody Payroll payment) {
        return ResponseEntity.ok().body(payrollService.getPayment(workerId, payment));
    }
}
