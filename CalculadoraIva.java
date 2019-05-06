package iva;
import javax.swing.*;
import java.awt.event.*;
public class CalculadoraIva extends JFrame implements ActionListener{
    private JLabel cantidad;
    private JComboBox iva;
    private JTextField espacio;
    private JButton calcular;
    private String selectIva;
    
    public CalculadoraIva(){
        super();
        ventana();
        componentes();
    }
    private void ventana(){
        this.setTitle("Calculador de iva");
        this.setSize(300,300);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private void componentes(){
        cantidad = new JLabel();
        cantidad.setText("Cantidad");
        cantidad.setBounds(60, 10, 100, 30);
        this.add(cantidad);
        espacio = new JTextField();
        espacio.setBounds(60, 35, 100, 20);
        this.add(espacio);
        String[] ivaLista = new String[]{"16","8"};
        JComboBox<String> iva = new JComboBox<>(ivaLista);
        iva.setBounds(60,70,100,20);
        iva.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                selectIva= iva.getItemAt(iva.getSelectedIndex());
                System.out.println("El valor de iva es: "+selectIva);
            }
        });
        this.add(iva);
        calcular = new JButton();
        calcular.setText("Calcular");
        calcular.setBounds(60,100,100,20);
        calcular.addActionListener(this);
        this.add(calcular);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        String cantidad1 = espacio.getText();
        String cantidad2 = selectIva;
        int numEntero = Integer.parseInt(cantidad1);
        int numEntero2 = Integer.parseInt(cantidad2);
        float resultado=((numEntero*numEntero2)/100)+numEntero;
        JOptionPane.showMessageDialog(this, "Precio con iva $"+resultado);
    }
    public static void main(String[] args){
        CalculadoraIva calculador = new CalculadoraIva();
        calculador.setVisible(true);
    }
}
