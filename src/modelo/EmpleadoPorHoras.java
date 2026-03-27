package modelo;

public class EmpleadoPorHoras extends Empleado {

	private double pagaExtra;
	private int mesesProrratea;
	private boolean esAutonomo;

	public EmpleadoPorHoras(String nombre, double pagaExtra, int mesesProrratea, boolean esAutonomo) {
		super(nombre);
		this.pagaExtra = pagaExtra;
		this.mesesProrratea = mesesProrratea;
		this.esAutonomo = esAutonomo;
	}

	public double calcularSalarioBruto(double comisionesMes) {
		if (comisionesMes < 0) {
			throw new IllegalArgumentException();
		}
		return this.salarioBase + comisionesMes;

	}

	@Override
	public double calcularSalarioNeto() {
		if (this.esAutonomo == false) {
			return this.calcularSalarioBruto(pagaExtra, mesesProrratea)
					- (this.calcularSalarioBruto(pagaExtra, mesesProrratea) * this.irpf);

		}

		return this.calcularSalarioBruto(pagaExtra, mesesProrratea)
				- (this.calcularSalarioBruto(pagaExtra, mesesProrratea) * 7);
	}

	public double calcularSalarioNeto(double comisionesMes) {
		if (this.esAutonomo == true) {
			this.calcularSalarioBruto(comisionesMes);
		}

		return this.calcularSalarioBruto(comisionesMes) - (this.calcularSalarioBruto(comisionesMes) * 7);

	}

}
