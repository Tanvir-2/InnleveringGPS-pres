package hvl.dat100.presentasjon.opp5;

import javax.swing.JOptionPane;

import easygraphics.EasyGraphics;
import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave2.GPSData;
import no.hvl.dat100ptc.oppgave2.GPSDataFileReader;
import no.hvl.dat100ptc.oppgave3.GPSUtils;
import no.hvl.dat100ptc.oppgave4.GPSComputer;

public class ShowSpeedEasyGraphics extends EasyGraphics {

	
	private static int MARGIN = 50;
	private static int BARHEIGHT = 200; // assume no speed above 200 km/t

	private GPSComputer gpscomputer;
	private GPSPoint[] gpspoints;
	
	public ShowSpeedEasyGraphics() {

		String filename = JOptionPane.showInputDialog("GPS data filnavn: ");
		gpscomputer = new GPSComputer(filename);

		gpspoints = gpscomputer.getGPSPoints();
		
	}
	
	// read in the files and draw into using EasyGraphics
	public static void main(String[] args) {
		launch(args);
	}

	private static void launch(String[] args) {
		
		
	}

	public void run() {

		int N = gpspoints.length-1; // number of data points
		
		makeWindow("Speed profile", 2*MARGIN + 2 * N, 2 * MARGIN + BARHEIGHT);
		
		showSpeedProfile(MARGIN + BARHEIGHT,N);
	}
	
	private void makeWindow(String string, int i, int j) {
		
		
	}

	public void showSpeedProfile(int ybase, int N) {
		
		System.out.println("Angi tidsskalering i tegnevinduet ...");
		int timescaling = Integer.parseInt(getText("Tidsskalering"));
				
		
		
		double[] speed = gpscomputer.speeds();
		setColor(0, 0, 255);
		
		for (int i = 0; i < N; i++) {
			int speeds = (int) speed[i];
			drawLine(i + timescaling, ybase - speeds, i + timescaling, ybase);
		}
		setColor(0, 255, 0);
		drawLine(0, ybase - (int) gpscomputer.averageSpeed(), N, ybase - (int) gpscomputer.averageSpeed());
		
	
		
	}

	private void drawLine(int i, int j, int k, int ybase) {
		
		
	}

	private void setColor(int i, int j, int k) {
		
		
	}

	private String getText(String string) {
		
		return null;
	}
}

