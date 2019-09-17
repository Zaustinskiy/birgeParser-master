import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Window extends JFrame {
    Window(){
        super("Exchange");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //elements buy
        JLabel buyLabel = new JLabel("Buy USD:");
        JTextField buyValue = new JTextField(6);
        JTextField buyBankInf = new JTextField(30);
        //elements sell
        JLabel sellLabel = new JLabel("Sell USD:");
        JTextField sellValue = new JTextField(6);
        JTextField sellBankInf = new JTextField(30);
        //btn
        JButton showBtn = new JButton("SHOW");

        showBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Parsing parsing = new Parsing();
                parsing.setBuyProposal();
                buyValue.setText(parsing.getBuyProposal().getExRate().toString());
                buyBankInf.setText(parsing.getBuyProposal().getBankInf());

                parsing.setSellProposal();
                sellValue.setText(parsing.getSellProposal().getExRate().toString());
                sellBankInf.setText(parsing.getSellProposal().getBankInf());
            }
        });


        //create Boxes
        Box mainBox = Box.createVerticalBox();

        //first Line
        Box buyBox = Box.createHorizontalBox();
        buyBox.add(buyLabel);
        buyBox.add(Box.createHorizontalStrut(20));
        buyBox.add(buyValue);
        buyBox.add(Box.createHorizontalStrut(150));


        //second Line
        Box buyFielfBox = Box.createHorizontalBox();
        buyFielfBox.add(buyBankInf);


        //third Line
        Box sellBox = Box.createHorizontalBox();
        sellBox.add(sellLabel);
        sellBox.add(Box.createHorizontalStrut(20));
        sellBox.add(sellValue);
        sellBox.add(Box.createHorizontalStrut(150));


        //4-th Line
        Box sellBankBox = Box.createHorizontalBox();
        sellBankBox.add(sellBankInf);



        //5-th Line
        Box buttonBox = Box.createHorizontalBox();
        buttonBox.add(Box.createHorizontalGlue());
        buttonBox.add(showBtn);



        //build
        mainBox.add(buyBox);
        mainBox.add(Box.createVerticalStrut(10));
        mainBox.add(buyFielfBox);
        mainBox.add(Box.createVerticalStrut(15));
        mainBox.add(sellBox);
        mainBox.add(Box.createVerticalStrut(10));
        mainBox.add(sellBankInf);
        mainBox.add(Box.createVerticalStrut(15));
        mainBox.add(buttonBox);
        mainBox.setBorder(new EmptyBorder(12, 10, 10, 12));

        //add to panel
        //setResizable(false);
        getContentPane().add(mainBox);
        pack();
    }
}
