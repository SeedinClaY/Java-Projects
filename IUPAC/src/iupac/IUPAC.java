/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iupac;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.Random;
import javax.swing.*;
/**
 *
 * @author leijurv
 */
public class IUPAC {
    static int s = 0;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Molecule> demos = new ArrayList<Molecule>();
        HydroCarbon demo = new HydroCarbon(6);
        demo.addMolecule(Atom.get("flourine"), 1);
        demo.addBond(2);
        demo.addBond(2);
        demo.addBond(4);
        demo.addBond(4);
        demo.addMolecule(Atom.get("bromine"), 1);
        demo.addMolecule(Atom.get("flourine"), 3);
        demo.addMolecule(Atom.get("flourine"), 3);
        HydroCarbon side = new HydroCarbon(2);
        side.addBond(1);
        demo.addMolecule(side, 3);
        demo.addMolecule(new HydroCarbon(2), 6);
        HydroCarbon tetraflourine = new HydroCarbon(6);
        for (int i = 1; i <= 6; i++) {
            for (int j = 0; j < 2; j++) {
                tetraflourine.addMolecule(Atom.get("flourine"), i);
            }
        }
        tetraflourine.addMolecule(Atom.get("flourine"), 1);
        tetraflourine.addMolecule(Atom.get("flourine"), 6);
        HydroCarbon benzene = new HydroCarbon(6);
        //t.addMolecule(new CovalentBond(2), Atom.get("oxygen"), 3);
        benzene.addBond(1);
        benzene.addBond(3);
        benzene.addBond(5);
        benzene.isCyclic = true;
        HydroCarbon big = new HydroCarbon(24);
        big.addBond(6);
        big.addBond(13);
        big.addBond(19);
        big.addBond(19);
        big.addMolecule(new CovalentBond(2), Atom.get("oxygen"), 3);
        big.addMolecule(new CovalentBond(2), Atom.get("oxygen"), 9);
        big.addMolecule(new HydroCarbon(2), 4);
        big.addMolecule(new HydroCarbon(2), 8);
        big.addMolecule(new HydroCarbon(4), 12);
        big.addMolecule(new HydroCarbon(1), 15);
        big.addMolecule(Atom.get("bromine"), 18);
        big.addMolecule(Atom.get("chlorine"), 11);
        big.addMolecule(new Hydroxy(), 5);
        HydroCarbon methanol = new HydroCarbon(1);
        methanol.addMolecule(new Hydroxy(), 1);
        demos.add(methanol);
        HydroCarbon methanoic = new HydroCarbon(1);
        methanoic.isAcid = true;
        demos.add(methanoic);
        HydroCarbon ethanoic = new HydroCarbon(2);
        ethanoic.isAcid = true;
        demos.add(ethanoic);
        HydroCarbon hexanoic = new HydroCarbon(6);
        hexanoic.isAcid = true;
        demos.add(hexanoic);
        HydroCarbon diflouro = new HydroCarbon(2);
        diflouro.addMolecule(Atom.get("flourine"), 1);
        diflouro.addMolecule(Atom.get("flourine"), 1);
        demos.add(diflouro);
        HydroCarbon pentaflouro = new HydroCarbon(3);
        pentaflouro.addMolecule(Atom.get("flourine"), 1);
        pentaflouro.addMolecule(Atom.get("flourine"), 1);
        pentaflouro.addMolecule(Atom.get("flourine"), 1);
        pentaflouro.addMolecule(Atom.get("flourine"), 3);
        pentaflouro.addMolecule(Atom.get("flourine"), 3);
        demos.add(pentaflouro);
        demos.add(tetraflourine);
        HydroCarbon but = new HydroCarbon(5);
        but.addBond(1);
        but.addBond(3);
        demos.add(but);
        demos.add(benzene);
        HydroCarbon methylbenzene = new HydroCarbon(6);
        methylbenzene.addBond(1);
        methylbenzene.addBond(3);
        methylbenzene.addBond(5);
        methylbenzene.addMolecule(new HydroCarbon(1), 1);
        methylbenzene.isCyclic = true;
        demos.add(methylbenzene);
        HydroCarbon tnt = new HydroCarbon(6);
        tnt.addBond(1);
        tnt.addBond(3);
        tnt.addBond(5);
        tnt.addMolecule(new HydroCarbon(1), 1);
        tnt.addMolecule(new Nitro(), 2);
        tnt.addMolecule(new Nitro(), 4);
        tnt.addMolecule(new Nitro(), 6);
        tnt.isCyclic = true;
        demos.add(tnt);
        HydroCarbon trimethyl = new HydroCarbon(5);
        trimethyl.addMolecule(new HydroCarbon(1), 2);
        trimethyl.addMolecule(new HydroCarbon(1), 2);
        trimethyl.addMolecule(new HydroCarbon(1), 4);
        demos.add(trimethyl);
        demos.add(big);
        demos.add(demo);
        demos.add(side);
        JFrame frame = new JFrame("dank");
        JComponent M = new JComponent() {
            public void paintComponent(Graphics g) {
                g.setFont(new Font("Courier", Font.PLAIN, 12));
                demos.get(s).draw(g, 100, 100, 0, null);
            }
        };
        M.setLayout(new FlowLayout());
        String[] names = new String[demos.size()];
        for (int i = 0; i < names.length; i++) {
            names[i] = demos.get(i).toString();
        }
        JComboBox<String> jc = new JComboBox(names);
        jc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                s = jc.getSelectedIndex();
                frame.repaint();
            }
        });
        M.add(jc);
        frame.setContentPane(M);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(100000, 10000);
        frame.setVisible(true);
    }
}
