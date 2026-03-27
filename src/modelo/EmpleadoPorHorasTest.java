package modelo;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class EmpleadoPorHorasTest {

	private static ArrayList<EmpleadoPorHoras> listaEmpleadosPorHoras;
	private EmpleadoPorHoras empleadoPorHoras;

	private String nombre;
	private double salarioBase;
	private Boolean autonomo;
	private float irpf;
	private double pagaExtra;
	private int mesesProrratea;
	private double salarioNetoEsperado;
	private double comisiones;

	@BeforeClass
	public static void beforeClass() {

		listaEmpleadosPorHoras = new ArrayList<>();
		System.out.println("Iniciando test parametrizado");
	}

	@AfterClass
	public static void afterClass() {
		listaEmpleadosPorHoras = null;
		System.out.println("Finalizado test parametrizado");

	}

	@Before
	public void before() {
		empleadoPorHoras = new EmpleadoPorHoras(nombre, salarioBase, autonomo, irpf, pagaExtra, mesesProrratea);
		System.out.println("Iniciando prueba");

	}

	@After
	public void after() {
		empleadoPorHoras = null;
		System.out.println("Prueba finalizada");

	}

	public EmpleadoPorHorasTest(String nombre, double salarioBase, Boolean autonomo, float irpf, double pagaExtra,
			int mesesProrratea, double salarioNetoEsperado, double comisiones) {
		this.nombre = nombre;
		this.salarioBase = salarioBase;
		this.autonomo = autonomo;
		this.irpf = irpf;
		this.pagaExtra = pagaExtra;
		this.mesesProrratea = mesesProrratea;
		this.salarioNetoEsperado = salarioNetoEsperado;
		this.comisiones = comisiones;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> parametros() {
		return Arrays.asList(new Object[][] { { "Test", 1234, true, 3, 452, 2, 1235, 1 },
				{ "Test", 1512, true, 7, 45122, 12, 1522, 10 },
				{ "Test", 1512, true, 7, 45122, 12, 1532, 20 }});
	}

	@Test
	public void test() {

		assertEquals(salarioNetoEsperado, empleadoPorHoras.calcularSalarioNeto(comisiones), 0.1);

	}

	@Ignore
	@Test
	public void testSalario() {

	}

}
