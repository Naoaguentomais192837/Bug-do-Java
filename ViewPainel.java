package TerceiroTrimestre;

import javax.swing.JOptionPane;

public class ViewPainel extends javax.swing.JFrame {

    private int select = 0;
    private ContaCorrente conta;

    public ViewPainel() {
        initComponents();
        conta = new ContaCorrente();
        conta.setNome("Adjailson F. Melo");
        conta.setCpf("12345678901");
        atualizarSaldo();
    }

    private void atualizarSaldo() {
        this.txtSaldo.setText("Saldo R$ " + String.format("%.2f", conta.getSaldo()));
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        btnDepositar = new javax.swing.JButton();
        btnSaque = new javax.swing.JButton();
        txtSaldo = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        btnProcessar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnDepositar.setFont(new java.awt.Font("Segoe UI", 1, 24));
        btnDepositar.setText("Depositar");
        btnDepositar.addActionListener(evt -> select = 1);

        btnSaque.setFont(new java.awt.Font("Segoe UI", 1, 24));
        btnSaque.setText("Saque");
        btnSaque.addActionListener(evt -> select = 2);

        txtSaldo.setFont(new java.awt.Font("Segoe UI", 1, 36));
        txtSaldo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        txtValor.setFont(new java.awt.Font("Segoe UI", 0, 24));
        txtValor.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btnProcessar.setFont(new java.awt.Font("Segoe UI", 1, 24));
        btnProcessar.setText("Ok");
        btnProcessar.addActionListener(evt -> processar());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLabel2.setText("R$");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSaldo, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(17)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnProcessar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(17)
                .addComponent(btnDepositar)
                .addGap(18)
                .addComponent(btnSaque, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addGap(17)
                .addComponent(txtSaldo)
                .addGap(18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDepositar)
                    .addComponent(btnSaque))
                .addGap(30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(btnProcessar))
                .addContainerGap(40, Short.MAX_VALUE)
        );

        pack();
    }

    private void processar() {
        try {
            double valor = Double.parseDouble(txtValor.getText());
            boolean sucesso = false;

            if (select == 1) {
                sucesso = conta.deposito(valor);
            } else if (select == 2) {
                sucesso = conta.saque(valor);
            } else {
                JOptionPane.showMessageDialog(this, "Escolha uma opção!");
                return;
            }

            if (sucesso) {
                JOptionPane.showMessageDialog(this, "Operação realizada com sucesso!");
            } else {
                JOptionPane.showMessageDialog(this, "Erro na operação! Verifique o valor.");
            }

            atualizarSaldo();
            txtValor.setText("");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Digite um valor válido!");
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new ViewPainel().setVisible(true));
    }

    private javax.swing.JButton btnDepositar;
    private javax.swing.JButton btnProcessar;
    private javax.swing.JButton btnSaque;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel txtSaldo;
    private javax.swing.JTextField txtValor;
          }
