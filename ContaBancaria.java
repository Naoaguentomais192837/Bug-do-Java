package TerceiroTrimestre;

import java.util.Random;

public class ContaBancaria {

    public final static String AGENCIA = "4567";
    private int numero;
    private double saldo;
    private String nome;
    private String cpf;

    // Construtor padrão
    public ContaBancaria() {
        Random aleatorio = new Random();
        this.numero = aleatorio.nextInt(1000, 99999);
        this.saldo = 50.0;
        this.nome = "";
        this.cpf = "";
    }

    // Construtor com nome e CPF
    public ContaBancaria(String nome, String cpf) {
        Random aleatorio = new Random();
        this.numero = aleatorio.nextInt(1000, 99999);
        this.saldo = 50.0;
        this.nome = nome;
        this.cpf = cpf;
    }

    // MÉTODOS PRINCIPAIS
    public boolean depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            return true;
        }
        return false;
    }

    public boolean sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            this.saldo -= valor;
            return true;
        }
        return false;
    }

    // GETTERS E SETTERS
    public double getSaldo() {
        return saldo;
    }

    public int getNumero() {
        return numero;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
              }
