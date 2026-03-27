package modelo;

public abstract class Empleado {

	private static final int SALARIO_MINIMO_INTERPROFESIONAL = 1221;
	protected String nombre;
	protected double salarioBase;
	protected boolean autonomo;
	protected float irpf;

	public Empleado(String nombre, double salarioBase, Boolean autonomo, float irpf) {
		if (salarioBase < SALARIO_MINIMO_INTERPROFESIONAL) {
			throw new IllegalArgumentException("El salario base no puede ser negativo");
		}
		this.nombre = nombre;
		this.salarioBase = salarioBase;
		this.autonomo = autonomo;
		this.irpf = irpf;
	}

	public Empleado(String nombre) {
		this.nombre = nombre;
		this.salarioBase = SALARIO_MINIMO_INTERPROFESIONAL;
		this.autonomo = false;
		this.irpf = 0;
	}

	// Métodos

	public double calcularSalarioBruto(double pagaExtra, int mesesProrratea) {
		return (this.salarioBase + pagaExtra) * mesesProrratea;

	}

	public abstract double calcularSalarioNeto();

	// Getters y Setters

	public String getNombre() {
		return nombre;
	}

	public double getSalarioBase() {
		return salarioBase;
	}

	public boolean isAutonomo() {
		return autonomo;
	}

	public float getIrpf() {
		return irpf;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setSalarioBase(double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public void setAutonomo(boolean autonomo) {
		this.autonomo = autonomo;
	}

	public void setIrpf(float irpf) {
		this.irpf = irpf;
	}

}
