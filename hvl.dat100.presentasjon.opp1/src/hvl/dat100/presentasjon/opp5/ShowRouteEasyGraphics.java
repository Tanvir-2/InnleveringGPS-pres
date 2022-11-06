package hvl.dat100.presentasjon.opp5;

import javax.swing.JOptionPane;

import easygraphics.EasyGraphics;
import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave3.GPSUtils;
import no.hvl.dat100ptc.oppgave4.GPSComputer;

public class ShowRouteEasyGraphics extends EasyGraphics {
	
	private static int MARGIN = 50;
	private static int MAPXSIZE = 800;
	private static int MAPYSIZE = 500;

	private GPSPoint[] gpspoints;
	private GPSComputer gpscomputer;
	
	public ShowRouteEasyGraphics() {

		String filename = JOptionPane.showInputDialog("GPS data filnavn: ");
		gpscomputer = new GPSComputer(filename);

		gpspoints = gpscomputer.getGPSPoints();

	}

	public static void main(String[] args) {
		launch(args);
	}

	private static void launch(String[] args) {
		
		
	}

	public void run() {

		makeWindow("Route", MAPXSIZE + 2 * MARGIN, MAPYSIZE + 2 * MARGIN);

		showRouteMap(MARGIN + MAPYSIZE);

		playRoute(MARGIN + MAPYSIZE);
		
		showStatistics();
	}

	private void makeWindow(String string, int i, int j) {
		
		
	}

	// antall x-pixels per lengdegrad
	public double xstep() {

		double maxlon = GPSUtils.findMax(GPSUtils.getLongitudes(gpspoints));
		double minlon = GPSUtils.findMin(GPSUtils.getLongitudes(gpspoints));

		double xstep = MAPXSIZE / (Math.abs(maxlon - minlon)); 

		return xstep;
	}

	// antall y-pixels per breddegrad
	public double ystep() {
	
		double ystep;
		
		double maxlat = GPSUtils.findMax(GPSUtils.getLatitudes(gpspoints));
		double minlat = GPSUtils.findMin(GPSUtils.getLatitudes(gpspoints));

		ystep = MAPYSIZE / (Math.abs(maxlat - minlat)); 

		return ystep;
		
		
		
	}

	public void showRouteMap(int ybase) {

		
		double minlon =  GPSUtils.findMin(GPSUtils.getLongitudes(gpspoints));
		double minlat =  GPSUtils.findMin(GPSUtils.getLatitudes(gpspoints));
		
		for (int i = 0; i < gpspoints.length; i++) {
			setColor(0, 255, 0);
			double latitude =  gpspoints[i].getLatitude();
			double longitude = gpspoints[i].getLongitude();
			int x = (int) ((longitude - minlon) * xstep());
			int y = (int) ((latitude - minlat) * ystep());
			fillCircle(x + MARGIN, ybase - y, 3);
		}
		
		
		
	}

	private int fillCircle(int i, int j, int k) {
		return k;
		
		
	}

	private void setColor(int i, int j, int k) {
		
		
	}

	public void showStatistics() {

		int TEXTDISTANCE = 20;

		setColor(0,0,0);
		setFont("Courier",12);
		
		drawString("Total time     : " + GPSUtils.formatTime(gpscomputer.totalTime()), MARGIN, TEXTDISTANCE);
		drawString("Total distance : " + GPSUtils.formatDouble(gpscomputer.totalDistance()), MARGIN, TEXTDISTANCE*2);
		drawString("Total elevation: " + GPSUtils.formatDouble(gpscomputer.totalElevation()), MARGIN, TEXTDISTANCE*3);
		drawString("Max speed      : " + GPSUtils.formatDouble(gpscomputer.maxSpeed()), MARGIN, TEXTDISTANCE*4);
		drawString("Average speed  : " + GPSUtils.formatDouble(gpscomputer.averageSpeed()), MARGIN, TEXTDISTANCE*5);
		drawString("Energy         : " + GPSUtils.formatDouble(gpscomputer.totalKcal(80)), MARGIN, TEXTDISTANCE*6);
		
		
		
	}

	private void drawString(String string, int mARGIN2, int tEXTDISTANCE) {
		
		
	}

	private void setFont(String string, int i) {
		
		
	}

	public void playRoute(int ybase) {

		
		setColor(0, 0, 255);
		double minlon =  GPSUtils.findMin(GPSUtils.getLongitudes(gpspoints));
		double minlat =  GPSUtils.findMin(GPSUtils.getLatitudes(gpspoints));
		double latitude =  gpspoints[0].getLatitude();
		double longitude = gpspoints[0].getLongitude();
		int x = (int) ((longitude - minlon) * xstep());
		int y = (int) ((latitude - minlat) * ystep());
		int id = fillCircle(x + MARGIN, ybase - y, 5);
		double max = gpscomputer.maxSpeed();
		
		for (int i = 1; i < gpspoints.length; i++) {
			double speed = 1 + Math.ceil(GPSUtils.speed(gpspoints[i - 1], gpspoints[i])/max*5);
			setSpeed((int) speed);
			setColor(0, 255, 0);
			latitude =  gpspoints[i].getLatitude();
			longitude = gpspoints[i].getLongitude();
			x = (int) ((longitude - minlon) * xstep());
			y = (int) ((latitude - minlat) * ystep());
			moveCircle(id, x + MARGIN, ybase - y);
		}

	}

	private void moveCircle(int id, int i, int j) {
		
		
	}

	private void setSpeed(int speed) {
		
		
	}
}
