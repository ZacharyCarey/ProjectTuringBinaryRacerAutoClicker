import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class BinaryRacer extends KeyAdapter {
	
public JFrame     window    = new JFrame();
public JTextField textField = new JTextField();

public static void main(String[] args) {
	new BinaryRacer();
}

public BinaryRacer(){
	textField.addKeyListener(this);

	window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	window.add(textField);
	window.setSize(300, 100);
	window.setVisible(true);
}

@Override
public void keyPressed(KeyEvent event) {
	
	//on ENTER: calculate and click bits; clear screen
	if (event.getKeyChar() =='\n') {
		doClicks(calcBits(textField.getText()));
		textField.setText("");
	}
}

public boolean[] calcBits(String intString) {
	boolean[] bits = new boolean[8];
	
	//no error handling :( you have to type numbers
	int input = Integer.parseInt(intString);
	
	for(int j=0;j<bits.length;j++) {
		if (input % 2 == 1)
			bits[j] = true;
		input = input / 2;
	}
	
	return bits;
}

public void doClicks(boolean [] bits) {
	
	//click bits
	int y = 1274;
	if (bits[7]) click( 908,y); // Bit 128
	if (bits[6]) click( 1004,y); // Bit 64
	if (bits[5]) click( 1099,y); // Bit 32
	if (bits[4]) click( 1196,y); // Bit 16
	if (bits[3]) click( 1294,y); // Bit 8
	if (bits[2]) click(1392,y); // Bit 4
	if (bits[1]) click(1484,y); // Bit 2
	if (bits[0]) click(1580,y); // Bit 1
	
	//click submit
	click( 1277,1347);
	
	//click back in the window (on second screen) to enter a new number
	click(window.getX()+50,window.getY()+50);
}

public void click(int x, int y) {
	Robot bot;
	try {
		bot = new Robot();
		bot.mouseMove(x, y);    
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	} catch (AWTException e) {
		e.printStackTrace();
	}
}
	
}