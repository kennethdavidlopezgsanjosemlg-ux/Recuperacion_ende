package modelo;

public class EmpleadoTiempoCompleto extends Empleado {
	private double pagaExtra;
	private int mesesProrratea;

	public EmpleadoTiempoCompleto(String nombre, double pagaExtra, int mesesProrratea) {
		super(nombre);
		this.pagaExtra = pagaExtra;
		this.mesesProrratea = mesesProrratea;
	}

	@Override
	public double calcularSalarioNeto() {
		return this.calcularSalarioBruto(this.pagaExtra, this.mesesProrratea)
				- (this.calcularSalarioBruto(this.pagaExtra, this.mesesProrratea) * this.irpf);
	}

}
