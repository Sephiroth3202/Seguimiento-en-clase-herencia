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
        return "=== RESUMEN DE PAGO 0===\n" +
                "Documento    : " + documento + "\n" +
                "Nombre       : " + nombre + "\n" +
                "Tipo         : " + tipoEmpleado + "\n" +
                "Salario Bruto: $" + salarioBruto + "\n" +
                "Descuentos   : $" + descuentos + "\n" +
                "Salario Neto : $" + salarioNeto + "\n";
    }
    }

