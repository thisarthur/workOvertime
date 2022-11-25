package entities;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class NightShiftPremium {

	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");

	private String startHour;
	private String endHour;
	private double salaryPerMinute;

	public NightShiftPremium() {

	}

	public NightShiftPremium(String startHour, String endHour, double salaryPerMinute) {
		this.startHour = startHour;
		this.endHour = endHour;
		this.salaryPerMinute = salaryPerMinute;

	}

	public String getStartHour() {
		return startHour;
	}

	public void setStartHour(String startHour) {
		this.startHour = startHour;
	}

	public String getEndHour() {
		return endHour;
	}

	public void setEndHour(String endHour) {
		this.endHour = endHour;
	}

	public double getSalaryPerMinute() {
		return salaryPerMinute;
	}

	public void setSalaryPerMinute(double salaryPerMinute) {
		this.salaryPerMinute = salaryPerMinute;
	}

	@Override
	public int hashCode() {
		return Objects.hash(endHour, salaryPerMinute, startHour);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NightShiftPremium other = (NightShiftPremium) obj;
		return Objects.equals(endHour, other.endHour)
				&& Double.doubleToLongBits(salaryPerMinute) == Double.doubleToLongBits(other.salaryPerMinute)
				&& Objects.equals(startHour, other.startHour);
	}

	public double NightShiftPremiumCalc() {
		LocalTime startHourF = LocalTime.parse(startHour, dtf);
		LocalTime endHourF = LocalTime.parse(endHour, dtf);

		if (startHourF.getHour() < 5 || endHourF.getHour() >= 22) {
			// adicional de 20%
			String workStarter = "05:00";
			LocalTime workStarterF = LocalTime.parse(workStarter, dtf);

			String workEnd = "22:00";
			LocalTime workEndF = LocalTime.parse(workEnd, dtf);

			long min1 = Duration.between(workEndF, endHourF).toMinutes();
			long min2 = Duration.between(startHourF, workStarterF).toMinutes();

			double totalMinutes = min1 + min2;

			double sum2 = (totalMinutes * salaryPerMinute);
			double nightShift = sum2 * 0.2;

			System.out.printf("Adicional Noturno: %.2f \n", nightShift);

			return nightShift;

		}
		return 0;
	}

}