package _08_California_Weather;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/*
 * OBJECTIVE:
 * 1. Create a program that allows the user to search for the weather
 * conditions of a given city in California. Use the example program below
 * and the Utilities class inside this project to get the temperature data
 * from a day in December 2020.
 * Example: User: Encinitas
 *          Program: Encinitas is Overcast with a tempeature of 59.01 �F
 * 
 * 2. Create a way for the user to specify the weather condition and then
 * list the cities that have those conditions.
 * Example: User: Mostly Cloudy
 *          Program: Long Beach, Pomona, Oceanside, ...
 * 
 * 3. Create a way for the user to enter a minimum and maximum temperature
 * and then list the cities that have temperatures within that range
 * Example: User: minimum temperature �F = 65.0, max temperature �F = 70.0
 *          Program: Fortana, Glendale, Escondido, Del Mar, ...
 * 
 * EXTRA:
 * Feel free to add pictures for specific weather conditions or a thermometer
 * for the temperature. Also If you want your program to get the current day's
 * temperature, you can get a free API key at: https://openweathermap.org/api
 */

public class CaliforniaWeather implements ActionListener {

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton enterCity = new JButton("Enter a city");
	JButton condition = new JButton("Enter a weather");
	JButton minMax = new JButton("Enter a minimum and maximum temperature");
	HashMap<String, WeatherData> weatherData;

	void start() {
		weatherData = Utilities.getWeatherData();

		// All city keys have the first letter capitalized of each word
		String cityName = Utilities.capitalizeWords("National City");
		WeatherData datum = weatherData.get(cityName);

		if (datum == null) {
			System.out.println("Unable to find weather data for: " + cityName);
		} else {
			System.out.println(
					cityName + " is " + datum.weatherSummary + " with a temperature of " + datum.temperatureF + " F");
		}

		frame.setVisible(true);
		frame.add(panel);
		panel.add(enterCity);
		panel.add(condition);
		panel.add(minMax);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();

		enterCity.addActionListener(this);
		condition.addActionListener(this);
		minMax.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

		if (arg0.getSource() == enterCity) {
			String s = JOptionPane.showInputDialog(null, "Enter a city");
			s = Utilities.capitalizeWords(s); 
			if (weatherData.keySet().contains(s)) {
				JOptionPane.showMessageDialog(null, s + " is " + weatherData.get(s).weatherSummary + " temperature of "
						+ weatherData.get(s).temperatureF + " F");
			} else {

			}
		}
		if (arg0.getSource() == condition) {
			String s = JOptionPane.showInputDialog(null, "Enter a weather condition");
			s = Utilities.capitalizeWords(s); 

			String x = "";
			int counter = 1;
			
			for (Entry<String, WeatherData> entry : weatherData.entrySet()) {
				if (entry.getValue().weatherSummary.equals(s)) {
					x = x + entry.getKey() + ", ";
					counter++;
					if (counter % 10 == 0) {
						x = x + " \n";
					}
				}

			}
			JOptionPane.showMessageDialog(null, x);

		}
		if (arg0.getSource() == minMax) {
			String x = JOptionPane.showInputDialog(null, "Enter the minimum temperature");
			Double min = Double.parseDouble(x);

			String y = JOptionPane.showInputDialog(null, "Enter the maximum temperature");
			Double max = Double.parseDouble(y);

			String z = "";
			int counter = 1;

			for (Entry<String, WeatherData> entry : weatherData.entrySet()) {
				if (min <= entry.getValue().temperatureF && entry.getValue().temperatureF <= max) {
					z = z + entry.getKey() + ", ";
					counter++;
					if (counter % 10 == 0) {
						z = z + " \n";
					}
				}
			}
			
			JOptionPane.showMessageDialog(null, z);
		}
	}
}
