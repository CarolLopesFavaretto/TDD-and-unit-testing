package Service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.ReajusteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReajusteServiceTest {

    private ReajusteService service;

    private Funcionario funcionario;


    @BeforeEach
    public void inicializer() {
        this.service = new ReajusteService();
        this.funcionario = new Funcionario("Carol", LocalDate.now(), new BigDecimal("1000.00"));
    }

    @Test
    void shouldHaveReadjustmentOfThreePercent() {
        service.concederReajuste(funcionario, Desempenho.A_Desejar);
        assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }

    @Test
    void shouldHaveReadjustmentOfFifteenPercent() {
        service.concederReajuste(funcionario, Desempenho.BOM);
        assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }

    @Test
    void shouldHaveReadjustmentOfTwentyPercent() {
        service.concederReajuste(funcionario, Desempenho.OTIMO);
        assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }
}
