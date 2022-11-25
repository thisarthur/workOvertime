package entities;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Overtime {

	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");

	private String startHour;
	private String endHour;
	private double salaryPerMinute;

	public Overtime() {

	}

	public Overtime(String startHour, String endHour, double salaryPerMinute) {
		super();
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
		Overtime other = (Overtime) obj;
		return Objects.equals(endHour, other.endHour)
				&& Double.doubleToLongBits(salaryPerMinute) == Double.doubleToLongBits(other.salaryPerMinute)
				&& Objects.equals(startHour, other.startHour);
	}

	public double overtimeCalc() {
		LocalTime startHourF = LocalTime.parse(startHour, dtf);
		LocalTime endHourF = LocalTime.parse(endHour, dtf);

		if (startHourF.getHour() < 8 || endHourF.getHour() >= 18) {
			// adicional de 50%
			// horario de trabalho baseado em 8-18h
			String workStarter = "08:00";
			LocalTime workStarterF = LocalTime.parse(workStarter, dtf);

			String workEnd = "18:00";
			LocalTime workEndF = LocalTime.parse(workEnd, dtf);

			long min1 = Duration.between(workEndF, endHourF).toMinutes();
			long min2 = Duration.between(startHourF, workStarterF).toMinutes();

			double totalMinutes = min1 + min2;

			double sum = (totalMinutes * salaryPerMinute);
			double overtime = sum * 0.5;

			System.out.printf("Hora Extra: %.2f \n", overtime);

			return overtime;
		}
		return 0;
	}

}
