package modelo;
/**
 * Clase que extiende a {@link Empleado}.
 * Representa a los empleados por horas
 */
public class EmpleadoPorHoras extends Empleado {
	/**Variable que representa la paga extra de la cuenta */
	private double pagaExtra;
	/**Variable que representa los meses que se prorratea la paga extra */
	private int mesesProrratea;
	/**
	 * Contructor de empleados por horas
	 * @param nombre - nombre de la cuenta
	 * @param salarioBase - salario base de la cuenta
	 * @param autonomo - representa si es autonomo o no
	 * @param irpf - irpf de la cuenta
	 * @param pagaExtra - paga extra de la cuenta
	 * @param mesesProrratea - meses que se prorratea la paga extra
	 */
	public EmpleadoPorHoras(String nombre, double salarioBase, Boolean autonomo, float irpf, double pagaExtra,
			int mesesProrratea) {
		super(nombre, salarioBase, autonomo, irpf);
		this.pagaExtra = pagaExtra;
		this.mesesProrratea = mesesProrratea;
	}
	
	/**
	 * Método que calcula el salario bruto a partir de las comisioens y el salario base.
	 * @param comisionesMes
	 * @return
	 */
	public double calcularSalarioBruto(double comisionesMes) {
		if (comisionesMes < 0) {
			throw new IllegalArgumentException("Las comisiones no pueden ser menor a 0");
		}
		return this.salarioBase + comisionesMes;

	}
	
	/**
	 * Método que calcula el salario neto dependiendo de si es autonomo o no
	 * @return autonomo si : se calcula restando al salario bruto su irpf
	 * 			autonomo no: se calcula sobre el bruto restando 7.
	 */
	@Override
	public double calcularSalarioNeto() {
		if (this.autonomo == false) {
			return this.calcularSalarioBruto(pagaExtra, mesesProrratea)
					- (this.calcularSalarioBruto(pagaExtra, mesesProrratea) * this.irpf);

		}

		return this.calcularSalarioBruto(pagaExtra, mesesProrratea)
				- (this.calcularSalarioBruto(pagaExtra, mesesProrratea) * 7);
	}
	
	/**
	 * Método que calcula el salario neto a partir de las comisioens del mes
	 * @param comisionesMes - comision del mes
	 * @return autonomo no: salabario burtono menos el 7 porciento
	 * 	autonomo si: se calcula salario base + comisiones
	 */
	public double calcularSalarioNeto(double comisionesMes) {

		if (this.autonomo=false) {
			return this.calcularSalarioBruto(comisionesMes) - (this.calcularSalarioBruto(comisionesMes) * 7);
		}
		
		return this.calcularSalarioBruto(comisionesMes);

	}

}
