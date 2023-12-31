package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {
	
 
	//Screen settings
	final int originalTileSize = 16; //16x16 tile
	final int scale = 3;
	final int tileSize = originalTileSize * scale; //48x48 tile
	final int maxScreenCol = 16;
	final int maxScreenRow = 12;
	final int screenWidth = tileSize * maxScreenCol; //768 pixels
	final int screenHeight = tileSize * maxScreenRow; // 576 pixels
	//fps
	int fps = 60;
	
	//set player position
	int playerY = 100;
	int playerX = 100;
	int playerSpeed = 4;
	
	Thread gameThread;
	KeyHandler keyH = new KeyHandler(); 
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth,screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
		
	}
	
	public void startGameThread() {
		
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	
//public void run() {
//	
//	double drawInterval = 1000000000/fps; //0.016666s
//	double nextDrawTime = System.nanoTime()+ drawInterval;
//	
//		while (gameThread != null ) {
//		
//			
//			//update
//			update();
//			
//			//Draw
//			repaint();
//			
//			try {
//				double remainingTime = nextDrawTime - System.nanoTime();
//				remainingTime = remainingTime/1000000;
//				
//				if(remainingTime<0) {
//					remainingTime =0;
//				}
//				
//				Thread.sleep((long) remainingTime);
//				
//				nextDrawTime += drawInterval;
//				
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//	}

	
	
	
	
	
public void update() {
	if (keyH.upPressed==true) {
		playerY -= playerSpeed;
		
	}else if (keyH.downPressed == true) {
		playerY += playerSpeed;
		
	}
	else if (keyH.leftPressed == true) {
		playerX -= playerSpeed;
		
	}
	else if (keyH.rightPressed == true) {
		playerX += playerSpeed;
		
	}
}

public void paintComponent (Graphics g) {
	super.paintComponent(g);
	Graphics g2 = (Graphics2D)g;
	
	g2.setColor(Color.white);
	g2.fillRect(playerX, playerY, tileSize, tileSize);
	g2.dispose();
	
	
	
}


}







