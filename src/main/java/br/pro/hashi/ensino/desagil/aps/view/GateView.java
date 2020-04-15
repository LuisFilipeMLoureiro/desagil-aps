package br.pro.hashi.ensino.desagil.aps.view;
import br.pro.hashi.ensino.desagil.aps.model.Gate;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;

public class GateView extends FixedPanel implements ActionListener, MouseListener{
    private final Gate gate;

    boolean

    private final JCheckBox entrada1 = new JCheckBox("Entrada 1");
    private final JCheckBox entrada2 = new JCheckBox("Entrada 2");
    private final JCheckBox saida = new JCheckBox("Saída");
    // Novos atributos necessários para esta versão da interface.
    private Color color;

    public GateView(Gate gate) {

        // Como subclasse de FixedPanel, esta classe agora
        // exige que uma largura e uma altura sejam fixadas.
        super(245, 346);

        this.gate = gate;


        JLabel entradaLabel = new JLabel("Entradas:");
        JLabel saidaLabel = new JLabel("Saída:");


        // Não há mais a chamada de setLayout, pois ela agora
        // acontece no construtor da superclasse FixedPanel.

        // Como subclasse de FixedPanel, agora podemos definir a
        // posição e o tamanho de cada componente ao adicioná-la.
        add(entradaLabel, 10, 10, 75, 25);
        add(entrada1, 10, 45, 150, 25);
        add(entrada2, 10, 80, 150, 25);
        add(saidaLabel, 10, 250, 75, 25);
        add(saida, 10, 311, 120, 25);

        // Inicializamos o atributo de cor simplesmente como preto.
        color = Color.BLACK;



        entrada1.addActionListener(this);
        entrada2.addActionListener(this);

        saida.setEnabled(false);

        // Toda componente Swing tem uma lista de observadores
        // que reagem quando algum evento de mouse acontece.
        // Usamos o método addMouseListener para adicionar a
        // própria componente, ou seja "this", nessa lista.
        // Só que addMouseListener espera receber um objeto
        // do tipo MouseListener como parâmetro. É por isso que
        // adicionamos o "implements MouseListener" lá em cima.
        addMouseListener(this);

        // update();
    }

    private void itemStateChanged(ItemEvent e) {

        result = gate.
    }

    /*private void update() {
        double weight;
        double radius;

        try {
            weight = Double.parseDouble(entrada1.get());
            radius = Double.parseDouble(entrada2.getText());
        } catch (NumberFormatException exception) {
            resultField.setText("?");
            return;
        }

        boolean result = gate.read();

        resultField.setText(Double.toString(result));
    }
*/

    @Override
    public void actionPerformed(ActionEvent event) {
        update();
    }

    @Override
    public void mouseClicked(MouseEvent event) {

        // Descobre em qual posição o clique ocorreu.
        int x = event.getX();
        int y = event.getY();

        // Se o clique foi dentro do quadrado colorido...
        if (x >= 210 && x < 235 && y >= 311 && y < 336) {

            // ...então abrimos a janela seletora de cor...
            color = JColorChooser.showDialog(this, null, color);

            // ...e chamamos repaint para atualizar a tela.
            repaint();
        }
    }

    @Override
    public void mousePressed(MouseEvent event) {
        // Não precisamos de uma reação específica à ação de pressionar
        // um botão do mouse, mas o contrato com MouseListener obriga
        // esse método a existir, então simplesmente deixamos vazio.
    }

    @Override
    public void mouseReleased(MouseEvent event) {
        // Não precisamos de uma reação específica à ação de soltar
        // um botão do mouse, mas o contrato com MouseListener obriga
        // esse método a existir, então simplesmente deixamos vazio.
    }

    @Override
    public void mouseEntered(MouseEvent event) {
        // Não precisamos de uma reação específica à ação do mouse
        // entrar no painel, mas o contrato com MouseListener obriga
        // esse método a existir, então simplesmente deixamos vazio.
    }

    @Override
    public void mouseExited(MouseEvent event) {
        // Não precisamos de uma reação específica à ação do mouse
        // sair do painel, mas o contrato com MouseListener obriga
        // esse método a existir, então simplesmente deixamos vazio.
    }

    @Override
    public void paintComponent(Graphics g) {

        // Não podemos esquecer desta linha, pois não somos os
        // únicos responsáveis por desenhar o painel, como era
        // o caso nos Desafios. Agora é preciso desenhar também
        // componentes internas, e isso é feito pela superclasse.
        super.paintComponent(g);

        // Desenha a imagem, passando sua posição e seu tamanho.
        g.drawImage(image, 10, 80, 221, 221, this);

        // Desenha um quadrado cheio.
        g.setColor(color);
        g.fillRect(210, 311, 25, 25);

        // Linha necessária para evitar atrasos
        // de renderização em sistemas Linux.
        getToolkit().sync();
    }
}
