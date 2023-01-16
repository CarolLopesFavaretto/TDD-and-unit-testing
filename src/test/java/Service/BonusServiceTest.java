package Service;

import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.BonusService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BonusServiceTest {


    private BonusService service;

    @BeforeEach
    public void inicializer() {
        this.service = new BonusService();
    }

    @Test
    public void shouldBeZeroForHighSalary() {
        assertThrows(IllegalArgumentException.class,
                () -> service.calcularBonus(new Funcionario("Carol", LocalDate.now(), new BigDecimal("25000"))));

//        -- outra forma de testar exceptions
//        try {
//            service.calcularBonus(new Funcionario("Carol", LocalDate.now(), new BigDecimal("25000")));
//        }catch (Exception e){
//            assertEquals("Funcionário com salário maior que R$10000", e.getMessage());
//        }

    }

    @Test
    public void shouldBeTenPercentOfTheSalary() {
        BigDecimal salary = service.calcularBonus(new Funcionario("Carol", LocalDate.now(), new BigDecimal("2500")));

        assertEquals(new BigDecimal("250.00"), salary);
    }

    @Test
    public void shouldBeTenPercentOfTheSalaryOfOneThousandReais() {
        BigDecimal salary = service.calcularBonus(new Funcionario("Carol", LocalDate.now(), new BigDecimal("10000")));

        assertEquals(new BigDecimal("1000.00"), salary);
    }

}
