package TerceiroTrimestre;

public class ContaCorrente extends ContaBancaria {

    private double taxaJuros = 0;
    private double taxaSaque = 1.0;
    private double taxaDeposito = 0;
    private int limiteDepositosGratis = 3;
    private int contadorDepositos = 0;

    public boolean deposito(double valor) {
        try {
            if (valor <= 0) {
                return false;
            }

            contadorDepositos++;

            if (contadorDepositos > limiteDepositosGratis) {
                this.taxaDeposito = 1.5;
                super.setSaldo(super.getSaldo() + (valor - taxaDeposito));
                System.out.println("Depósito com taxa de R$ " + taxaDeposito);
            } else {
                super.setSaldo(super.getSaldo() + valor);
                System.out.println("Depósito sem taxa.");
            }

            System.out.println("Saldo atual: R$ " + super.getSaldo());
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public boolean saque(double valor) {
        if (valor > 0 && valor + taxaSaque <= super.getSaldo()) {
            super.setSaldo(super.getSaldo() - (valor + taxaSaque));
            System.out.println("Saque realizado com taxa de R$ " + taxaSaque);
            return true;
        }
        return false;
    }

    // GETTERS E SETTERS
    public double getTaxaJuros() {
        return taxaJuros;
    }

    public void setTaxaJuros(double taxaJuros) {
        this.taxaJuros = taxaJuros;
    }

    public double getTaxaSaque() {
        return taxaSaque;
    }

    public void setTaxaSaque(double taxaSaque) {
        this.taxaSaque = taxaSaque;
    }

    public double getTaxaDeposito() {
        return taxaDeposito;
    }

    public void setTaxaDeposito(double taxaDeposito) {
        this.taxaDeposito = taxaDeposito;
    }

    public int getContadorDepositos() {
        return contadorDepositos;
    }

    public void setContadorDepositos(int contadorDepositos) {
        this.contadorDepositos = contadorDepositos;
    }
}
