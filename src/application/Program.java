package application;

import java.text.ParseException;
import java.util.Scanner;

import entities.NightShiftPremium;
import entities.Overtime;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		
	
		double salary = 3000;
		double salaryPerHour = salary / 220;
		double salaryPerMinute = salaryPerHour / 60;



		System.out.println("Digite a entrada: ");
		String startHour = sc.next();

		System.out.println("Digite a saida: ");
		String endHour = sc.next();
		
		
		
		System.out.printf("salario : %.2f \n", salary);
		System.out.printf("salario por Hora: %.2f \n", salaryPerHour);
		System.out.printf("salario por Minuto: %.2f \n", salaryPerMinute);
		
		
		NightShiftPremium nsp = new NightShiftPremium (startHour, endHour, salaryPerMinute);
		nsp.NightShiftPremiumCalc();

		Overtime overtime = new Overtime (startHour, endHour, salaryPerMinute);
		overtime.overtimeCalc();

		
		// System.out.println(dtf.format(startHourForm));

		sc.close();

		// usuario ira inserir o valor da hora

		// Array startDate recebendo horas e dias de entrada
		// Array endDate recebendo horas e dias de saida
		// usuario ira inserir as datas e horarios trabalhados inicio e fim (fazer for
		// recebendo dia a dia e perguntando se tem proxima data)

		// Array de Dates recebendo dias e horarios trabalhados com validação para nao
		// receber na saida um horario ou data menor que a de entrada

		// verificar horas extras na classe pertinente
		// guardar valor somente da hora adicional

		// Foreach ou map percorrendo array de dates e verificando qual se encaixa no
		// adicional noturno

		// Guardando quantas horas são de adicionais noturnos

		// Foreach ou map percorrendo array de dates e verificando qual se encaixa no
		// interjornada

		// Guardando quantas horas são de interjornadas

		// mandar a quantidade de horas de adicionais noturno a serem calculadas na
		// classe

		// mandar a quantidade de horas de interjornadas a serem calculadas na classe

		// somar os resultados do adicional noturno e interjornada

		// somar os creditos com o salario

	}
}