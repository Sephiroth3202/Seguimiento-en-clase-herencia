abstract class Empleado {

    protected String nombre;
    protected String documento;
    protected int edad;
    protected float salarioBase;
    protected CategoriaEmpleado categoria;
    protected float descuentoSalud;
    protected float descuentoPension;

    public Empleado(String nombre, String documento, int edad,
                    float salarioBase, CategoriaEmpleado categoria,
                    float descuentoSalud, float descuentoPension) {

        if (salarioBase < 0)
            throw new IllegalArgumentException("El salario base no puede ser negativo.");
        if (descuentoSalud < 0 || descuentoSalud > 100)
            throw new IllegalArgumentException("Descuento de salud inválido (0-100).");
        if (descuentoPension < 0 || descuentoPension > 100)
            throw new IllegalArgumentException("Descuento de pensión inválido (0-100).");

        this.nombre         = nombre;
        this.documento      = documento;
        this.edad           = edad;
        this.salarioBase    = salarioBase;
        this.categoria      = categoria;
        this.descuentoSalud    = descuentoSalud;
        this.descuentoPension  = descuentoPension;
    }

    public abstract float calcularSalarioBruto();

    public float calcularBonificacionCategoria() {
        return switch (categoria) {
            case JUNIOR      -> salarioBase * 0.05f;
            case SEMI_SENIOR -> salarioBase * 0.10f;
            case SENIOR      -> salarioBase * 0.15f;
        };
    }

    public float calcularDescuentos() {
        float bruto = calcularSalarioBruto();
        return bruto * (descuentoSalud + descuentoPension) / 100f;
    }
    public float calcularSalarioNeto() {
        return calcularSalarioBruto() - calcularDescuentos();
    }
    public ResumenPago generarResumenPago() {
        return new ResumenPago(
                documento,
                nombre,
                this.getClass().getSimpleName(),
                calcularSalarioBruto(),
                calcularDescuentos(),
                calcularSalarioNeto()
        );
    }
    public void mostrarInformacion() {
        System.out.println();
        System.out.println("--- " + nombre + " ---");
        System.out.println("Documento    : " + documento);
        System.out.println("Edad         : " + edad + " años");
        System.out.println("Categoría    : " + categoria);
        System.out.println("Salario Base : $" + salarioBase);
        System.out.println("Bonificación : $" + calcularBonificacionCategoria());
        System.out.println("Descuentos   : $" + calcularDescuentos());
        System.out.println("Salario Neto : $" + calcularSalarioNeto());
    }
    public String getDocumento() { return documento; }
    public String getNombre()    { return nombre; }
    public float getSalarioNeto(){ return calcularSalarioNeto(); }
}

