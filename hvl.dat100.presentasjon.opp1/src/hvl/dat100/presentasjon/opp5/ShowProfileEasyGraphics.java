package hvl.dat100.presentasjon.opp5;

import easygraphics.EasyGraphics;
import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave2.GPSData;
import no.hvl.dat100ptc.oppgave2.GPSDataConverter;
import no.hvl.dat100ptc.oppgave2.GPSDataFileReader;
import no.hvl.dat100ptc.oppgave4.GPSComputer;

import javax.swing.JOptionPane;

public class ShowProfileEasyGraphics extends EasyGraphics {
	
private static int MARGIN = 50;		
	
	
	private static int MAXBARHEIGHT = 500; 
	
	private GPSPoint[] gpspoints;

	public ShowProfileEasyGraphics() {

		String filename = JOptionPane.showInputDialog("GPS data filnavn: ");
		GPSComputer gpscomputer =  new GPSComputer(filename);

		gpspoints = gpscomputer.getGPSPoints();
		
	}

	public static void main(String[] args) {
		launch(args);
	}

	private static void launch(String[] args) {
		
		
	}

	public void run() {

		int N = gpspoints.length; 

		makeWindow("Height profile", 2 * MARGIN + 3 * N, 2 * MARGIN + MAXBARHEIGHT);

		
		showHeightProfile(MARGIN + MAXBARHEIGHT); 
	}

	private void makeWindow(String string, int i, int j) {
		
		
	}

	public void showHeightProfile(int ybase) {

		// ybase indicates the position on the y-axis where the columns should start
		
		
		for (int i = 0; i < gpspoints.length; i++) {
			setColor(0, 0, 255);
			int elevation = (int) gpspoints[i].getElevation();
			drawLine(i + MARGIN, ybase - elevation, i + MARGIN, ybase);
		}
	
		
	}

	private void drawLine(int i, int j, int k, int ybase) {
		
		
	}

	private void setColor(int i, int j, int k) {
		
		
	}

}
