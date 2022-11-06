package hvl.dat100.presentasjon.opp2;


import java.io.*;

import javax.swing.*;

public class GPSDataFileReader {
	
	
		private static String SEP_STR = ",";

		private static  String GPSDATA_FORMAT = "time,lat,lon,elevation,accuracy,bearing,speed,satellites,"
				+ "provider,hdop,vdop,pdop,geoidheight,ageofdgpsdata,dgpsid,activity,battery,annotation";

		
		private static String GPSLOGS_DIR = System.getProperty("user.dir") + "/logs/";

		public static GPSData readGPSFile(String filename) {

			BufferedReader br = null;
			GPSData gpsdata = null;

			String time, latitude, longitude, elevation;

			try {

				br = new BufferedReader(new FileReader(GPSLOGS_DIR + filename + ".csv"));

				String line = br.readLine();

				
				int n = Integer.parseInt(line);

				
				gpsdata = new GPSData(n);

				
				line = br.readLine();

				int i = 0;

				line = br.readLine();

				while (line != null && i < n) {

					
					String[] gpsdatapoint = line.split(SEP_STR);

					time = gpsdatapoint[0];
					latitude = gpsdatapoint[1];
					longitude = gpsdatapoint[2];
					elevation = gpsdatapoint[3];
					
					gpsdata.insert(time,latitude,longitude,elevation);

					
					line = br.readLine();
					i++;
				}

			} catch (FileNotFoundException e) {
			    JOptionPane.showMessageDialog(null,"GPS filen " + filename + "finnes ikke");
				e.printStackTrace();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null,"GPS filen " + filename + "kunne ikke leses");
				e.printStackTrace();
			} finally {
				if (br != null) {
					try {
						br.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}

			return gpsdata;
		}

}
