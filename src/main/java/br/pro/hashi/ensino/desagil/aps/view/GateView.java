package br.pro.hashi.ensino.desagil.aps.view;

import br.pro.hashi.ensino.desagil.aps.model.*;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

public class GateView extends FixedPanel implements ActionListener, MouseListener {
    private final Gate gate;

    private final JCheckBox checkBox1;
    private final JCheckBox checkBox2;
    private final JCheckBox checkBoxresult;


    public GateView(Gate gate) {
        super(245, 346);

        this.gate = gate;
        checkBox1 = new JCheckBox("Entrada 1");
        checkBox2 = new JCheckBox("Entrada 2");
        checkBoxresult = new JCheckBox("Result");

        add(checkBox1, 85, 10, 150, 25);
        if (gate.getInputSize() == 2) {
            add(checkBox2, 85, 45, 150, 25);
        };
        add(checkBoxresult, 85, 311, 120, 25);

        checkBoxresult.setEnabled(false);
        checkBox1.addActionListener(this);
        checkBox2.addActionListener(this);

        addMouseListener(this);

        update();
    }

    private void update() {
        Boolean entrada1;
        Boolean entrada2;

        entrada1 = checkBox1.isSelected();
        entrada2 = checkBox2.isSelected();

        System.out.println(entrada1);
        System.out.println(entrada2);

        Switch switch1 = new Switch();
        Switch switch2 = new Switch();

        if (entrada1) {
            switch1.turnOn();
        };
        this.gate.connect(0, switch1);

        if (this.gate.getInputSize() > 1) {
            if (entrada2) {
                switch2.turnOn();
            };
            this.gate.connect(1, switch2);
        };


        Boolean result = this.gate.read();


        if (result) {
            checkBoxresult.setSelected(true);
        } else {
            checkBoxresult.setSelected(false);
        };
    };

    @Override
    public void actionPerformed(ActionEvent event) {
        update();
    }

    @Override
    public void mouseClicked(MouseEvent event) {

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
    }

}
