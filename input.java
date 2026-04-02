public class input {
    public static int scanInt(String message) {
        while (true) {
            try {
                int resultado = Integer.parseInt(IO.readln(message));
                return resultado;
            } catch (NumberFormatException e) {
                IO.println("valor invalido! Digite um numero inteiro");
            } catch (Exception e) {
                IO.println("Ocorreu um erro inesperado: " + e.getMessage());
            }
        }
    }
}