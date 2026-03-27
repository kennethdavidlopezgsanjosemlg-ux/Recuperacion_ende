package modelo;

public class EmpleadoPorHoras extends Empleado {

	private double pagaExtra;
	private int mesesProrratea;

	public EmpleadoPorHoras(String nombre, double salarioBase, Boolean autonomo, float irpf, double pagaExtra,
			int mesesProrratea) {
		super(nombre, salarioBase, autonomo, irpf);
		this.pagaExtra = pagaExtra;
		this.mesesProrratea = mesesProrratea;
	}

	public double calcularSalarioBruto(double comisionesMes) {
		if (comisionesMes < 0) {
			throw new IllegalArgumentException("Las comisiones no pueden ser menor a 0");
		}
		return this.salarioBase + comisionesMes;

	}

	@Override
	public double calcularSalarioNeto() {
		if (this.autonomo == false) {
			return this.calcularSalarioBruto(pagaExtra, mesesProrratea)
					- (this.calcularSalarioBruto(pagaExtra, mesesProrratea) * this.irpf);

		}

		return this.calcularSalarioBruto(pagaExtra, mesesProrratea)
				- (this.calcularSalarioBruto(pagaExtra, mesesProrratea) * 7);
	}

	public double calcularSalarioNeto(double comisionesMes) {

		if (this.autonomo=false) {
			return this.calcularSalarioBruto(comisionesMes) - (this.calcularSalarioBruto(comisionesMes) * 7);
		}
		
		return this.calcularSalarioBruto(comisionesMes);

	}

}
