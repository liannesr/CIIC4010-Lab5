import java.awt.Color;

import java.awt.Component;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JFrame;

public class MyMouseAdapter extends MouseAdapter {
	private int oldRandom=5;
	private Random generator = new Random();
	public void mousePressed(MouseEvent e) {
		switch (e.getButton()) {
		case 1:		//Left mouse button
			Component c = e.getComponent();
			while (!(c instanceof JFrame)) {
				c = c.getParent();
				if (c == null) {
					return;
				}
			}
			JFrame myFrame = (JFrame) c;
			MyPanel myPanel = (MyPanel) myFrame.getContentPane().getComponent(0);
			Insets myInsets = myFrame.getInsets();
			int x1 = myInsets.left;
			int y1 = myInsets.top;
			e.translatePoint(-x1, -y1);
			int x = e.getX();
			int y = e.getY();
			myPanel.x = x;
			myPanel.y = y;
			myPanel.mouseDownGridX = myPanel.getGridX(x, y);
			myPanel.mouseDownGridY = myPanel.getGridY(x, y);
			myPanel.repaint();
			break;
		case 3:		//Right mouse button
			//Do nothing
			break;
		default:    //Some other button (2 = Middle mouse button, etc.)
			//Do nothing
			break;
		}
	}
	public void mouseReleased(MouseEvent e) {
		
		switch (e.getButton()) {
		case 1:		//Left mouse button
			Component c = e.getComponent();
			while (!(c instanceof JFrame)) {
				c = c.getParent();
				if (c == null) {
					return;
				}
			}
			JFrame myFrame = (JFrame)c;
			MyPanel myPanel = (MyPanel) myFrame.getContentPane().getComponent(0);  //Can also loop among components to find MyPanel
			Insets myInsets = myFrame.getInsets();
			int x1 = myInsets.left;
			int y1 = myInsets.top;
			e.translatePoint(-x1, -y1);
			int x = e.getX();
			int y = e.getY();
			myPanel.x = x;
			myPanel.y = y;
			int gridX = myPanel.getGridX(x, y);
			int gridY = myPanel.getGridY(x, y);
			if ((myPanel.mouseDownGridX == -1) || (myPanel.mouseDownGridY == -1)) {
				//Had pressed outside
				//Do nothing
			} else {
				if ((gridX == -1) || (gridY == -1)) {
					//Is releasing outside
					//Do nothing
				} else {
					if ((myPanel.mouseDownGridX != gridX) || (myPanel.mouseDownGridY != gridY)) {
						//Released the mouse button on a different cell where it was pressed
						//Do nothing
					} else {
						//Released the mouse button on the same cell where it was pressed
						if ((gridX == 0) || (gridY == 0)) {
							Color cellColor = null;
							Color newCellColor = null;
							//On the left column and on the top row... do nothing
							if (gridX == 0 && 0 < gridY && gridY < 10){
								for(int i=1; i<10;i++){
									cellColor = myPanel.colorArray[i][myPanel.mouseDownGridY];
									do{
									switch (generator.nextInt(5)) {
									case 0:
										newCellColor = Color.YELLOW;
										break;
									case 1:
										newCellColor = Color.MAGENTA;
										break;
									case 2:
										newCellColor = Color.BLACK;
										break;
									case 3:
										newCellColor = new Color(0x964B00);   //Brown (from http://simple.wikipedia.org/wiki/List_of_colors)
										break;
									case 4:
										newCellColor = new Color(0xB57EDC);   //Lavender (from http://simple.wikipedia.org/wiki/List_of_colors)
										break;
									}
									}while(cellColor.equals(newCellColor));
									myPanel.colorArray[i][myPanel.mouseDownGridY]=newCellColor;
								}
							}
							else if(gridY==0 && gridX>0 && gridX<10){
								for(int j=1; j<10;j++){
									cellColor = myPanel.colorArray[myPanel.mouseDownGridX][j];
									do{
									switch (generator.nextInt(5)) {
									case 0:
										newCellColor = Color.YELLOW;
										break;
									case 1:
										newCellColor = Color.MAGENTA;
										break;
									case 2:
										newCellColor = Color.BLACK;
										break;
									case 3:
										newCellColor = new Color(0x964B00);   //Brown (from http://simple.wikipedia.org/wiki/List_of_colors)
										break;
									case 4:
										newCellColor = new Color(0xB57EDC);   //Lavender (from http://simple.wikipedia.org/wiki/List_of_colors)
										break;
									}
									}while(cellColor.equals(newCellColor));
									myPanel.colorArray[myPanel.mouseDownGridX][j]=newCellColor;
								}
							}
							else if(gridX==0 && gridY==0){
								for(int i=1; i<10; i++){
								for(int j=1; j<10;j++){
									if(i==j){
									cellColor = myPanel.colorArray[i][j];
									do{
									switch (generator.nextInt(5)) {
									case 0:
										newCellColor = Color.YELLOW;
										break;
									case 1:
										newCellColor = Color.MAGENTA;
										break;
									case 2:
										newCellColor = Color.BLACK;
										break;
									case 3:
										newCellColor = new Color(0x964B00);   //Brown (from http://simple.wikipedia.org/wiki/List_of_colors)
										break;
									case 4:
										newCellColor = new Color(0xB57EDC);   //Lavender (from http://simple.wikipedia.org/wiki/List_of_colors)
										break;
									}
									}while(cellColor.equals(newCellColor));
									myPanel.colorArray[i][j]=newCellColor;
									}
								}
								}
							}
							else if(gridX==0 && gridY==10){
								//x va de 4-7
								//y va de 4 - 7
								for(int i=4;i<7;i++){
								for(int j=4; j<7;j++){
									cellColor = myPanel.colorArray[i][j];
									do{
									switch (generator.nextInt(5)) {
									case 0:
										newCellColor = Color.YELLOW;
										break;
									case 1:
										newCellColor = Color.MAGENTA;
										break;
									case 2:
										newCellColor = Color.BLACK;
										break;
									case 3:
										newCellColor = new Color(0x964B00);   //Brown (from http://simple.wikipedia.org/wiki/List_of_colors)
										break;
									case 4:
										newCellColor = new Color(0xB57EDC);   //Lavender (from http://simple.wikipedia.org/wiki/List_of_colors)
										break;
									}
									}while(cellColor.equals(newCellColor));
									myPanel.colorArray[i][j]=newCellColor;
									
							}}
						}} else {
							//On the grid other than on the left column and on the top row:
							int random = generator.nextInt(5);
							
							while(oldRandom == random){
								random = generator.nextInt(5);
							}
							
							Color newColor = null;
							switch (random) {
							case 0:
								newColor = Color.YELLOW;
								break;
							case 1:
								newColor = Color.MAGENTA;
								break;
							case 2:
								newColor = Color.BLACK;
								break;
							case 3:
								newColor = new Color(0x964B00);   //Brown (from http://simple.wikipedia.org/wiki/List_of_colors)
								break;
							case 4:
								newColor = new Color(0xB57EDC);   //Lavender (from http://simple.wikipedia.org/wiki/List_of_colors)
								break;
							}
							oldRandom = random;
							myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY] = newColor;
							myPanel.repaint();
						}
					}
				}
			}
			myPanel.repaint();
			break;
		case 3:		//Right mouse button
		{
			
			c = e.getComponent();
			while (!(c instanceof JFrame)) {
				c = c.getParent();
				if (c == null) {
					return;
				}
			}
			myFrame = (JFrame)c;
			myPanel = (MyPanel) myFrame.getContentPane().getComponent(0);  //Can also loop among components to find MyPanel
			myInsets = myFrame.getInsets();
			x1 = myInsets.left;
			y1 = myInsets.top;
			e.translatePoint(-x1, -y1);
			x = e.getX();
			y = e.getY();
			myPanel.x = x;
			myPanel.y = y;
			gridX = myPanel.getGridX(x, y);
			gridY = myPanel.getGridY(x, y);
			if ((myPanel.mouseDownGridX == -1) || (myPanel.mouseDownGridY == -1)) {
				//Had pressed outside
				//Do nothing
			} else {
				int random = generator.nextInt(3);
				
				while(oldRandom == random){
					random = generator.nextInt(3);
				}
				
				Color newGrayColor = null;
				switch(random){
				case 0:
					newGrayColor = Color.CYAN;
					break;
				case 1:
					newGrayColor = Color.ORANGE;
					break;
				case 2:
					newGrayColor = Color.GREEN;
					break;
				}
				oldRandom = random;
				for(int i =0; i<10;i++){
					for(int j = 0; j<11;j++){
						if(i==0){
							myPanel.colorArray[i][j] = newGrayColor;
							myPanel.repaint();
						}
						else if(j==0){
							myPanel.colorArray[i][j] = newGrayColor;
							myPanel.repaint();
						}
					}
				}
			}
		}
			//Do nothing
			break;
		default:    //Some other button (2 = Middle mouse button, etc.)
			//Do nothing
			
			break;
		}
	}
}