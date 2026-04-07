record ResumenPago(
        String documento,
        String nombre,
        String tipoEmpleado,
        float salarioBruto,
        float descuentos,
        float salarioNeto
) {
    @Override
    public String toString() {
        return String.format(
                "=== RESUMEN DE PAGO ===%n" +
                        "Documento    : %s%n" +
                        "Nombre       : %s%n" +
                        "Tipo         : %s%n" +
                        "Salario Bruto: $%.2f%n" +
                        "Descuentos   : $%.2f%n" +
                        "Salario Neto : $%.2f%n" +
                        "======================",
                documento, nombre, tipoEmpleado, salarioBruto, descuentos, salarioNeto
        );
    }
}
