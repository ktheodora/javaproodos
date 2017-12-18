import java.applet.Applet;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


public class THEMA_2 extends Applet implements ActionListener, ItemListener {
	private static final long serialVersionUID = -5761670892391473010L;
	private Button PRESS;
	private Label lblEURO, lblPAYMENT;
	private TextField txtEURO, txtPAYMENT;
	private Checkbox c1,c2;
	private Panel p;

	public void init() {
		CheckboxGroup lngGrp = new CheckboxGroup();
		setBackground(Color.pink);
		p = new Panel();
		p.setLayout(new GridLayout(3,4));
		txtEURO = new TextField(20);
		lblEURO = new Label("EURO");
		txtPAYMENT = new TextField(20);
		lblPAYMENT = new Label("PÁÕÌÅÍÔ");
		c1 = new Checkbox("PAYMENT",lngGrp,true);  //circle button
	    c2 = new Checkbox("INSTALLMENT",lngGrp,true); 
	    c1.addItemListener(this);
        c2.addItemListener(this);
		PRESS = new Button("PRESS");
		PRESS.addActionListener(this);
		p.add(lblEURO);
		p.add(txtEURO);
		p.add(lblPAYMENT);
		p.add(txtPAYMENT);
		p.add(c1);
		p.add(c2);
		p.add(PRESS);
		add (p);
	}


public void actionPerformed (ActionEvent event) {

double eisodima,foros = 0;
eisodima = Double.parseDouble((txtEURO.getText()));
if (eisodima <= 5000) {
	foros = eisodima*0.4;
}
else if (eisodima <= 10000) {
	foros = 5000*0.4 + (eisodima - 5000)*0.5;
}
else if (eisodima > 10000) {
	foros = 5000*0.4 + 5000*0.5 + (eisodima - 10000)*0.6;
}
if (c1.getState() == true) {
	txtPAYMENT.setText(" " + Double.toString((foros)));
	lblPAYMENT.setBackground(Color.YELLOW);
	txtPAYMENT.setBackground(Color.GREEN);
}
else if (c2.getState() == true) {
	txtPAYMENT.setText(" " + Double.toString((foros/6)));
	lblPAYMENT.setBackground(Color.BLUE);
	txtPAYMENT.setBackground(Color.RED);
}

}


@Override
public void itemStateChanged(ItemEvent arg0) {
	// TODO Auto-generated method stub
	
}
}
