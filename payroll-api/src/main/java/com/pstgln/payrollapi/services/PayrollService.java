package com.pstgln.payrollapi.services;

import com.pstgln.payrollapi.domain.Payroll;
import com.pstgln.payrollapi.domain.User;
import com.pstgln.payrollapi.integration.UsuarioClient;
import com.pstgln.payrollapi.services.exceptions.ObjectNotFoundException;
import feign.FeignException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class PayrollService {

    private static final Logger LOG = LoggerFactory.getLogger(PayrollService.class);
    private final Environment env;
    private final UsuarioClient usuarioClient;

    @Autowired
    public PayrollService(Environment env,
                          UsuarioClient usuarioClient) {
        this.env = env;
        this.usuarioClient = usuarioClient;
    }

    public Payroll getPayment(Long workerId, Payroll payroll) {
        LOG.info("PAYROLL_SERVICE ::: Obteve requisição na porta: " + env.getProperty("local.server.port"));

        try {
            User user = usuarioClient.findById(workerId).getBody();
            if(user != null) {
                return new Payroll(
                        user.name(),
                        payroll.description(),
                        user.hourlyPrice(),
                        payroll.workedHours(),
                        user.hourlyPrice() * payroll.workedHours()
                );
            }
        } catch (FeignException.NotFound fenf) {
            throw new ObjectNotFoundException("Objeto não encontrado");
        } catch (Exception e) {
            throw new IllegalArgumentException("Agumento inválido");
        }

        return null;
    }
}
