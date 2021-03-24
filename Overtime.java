import java.util.Scanner;

public class Overtime {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Funcionario funcionario = new Funcionario();
        funcionario.jornada = new JornadaTrabalho();

        // Ponto de entrada
        System.out.print("Digite a hora de inicio: ");
        funcionario.jornada.startHour = sc.nextInt();
        System.out.print("Digite o minuto de inicio: ");
        funcionario.jornada.startMinute = sc.nextInt();

        // Ponto de saída
        System.out.print("Digite a hora de saída: ");
        funcionario.jornada.endHour = sc.nextInt();
        System.out.print("Digite o minuto de saída: ");
        funcionario.jornada.endMinute = sc.nextInt();

        // Valor da hora de trabalho
        System.out.print("Digite o valor da hora de trabalho: R$ ");
        funcionario.valueWorkedHour = sc.nextDouble();

        sc.close();

        // Diferença entre as horas
        int gapWorkedHour = funcionario.jornada.endHour - funcionario.jornada.startHour;
        int gapWorkedMinute = funcionario.jornada.endMinute - funcionario.jornada.startMinute;

        // Verificar se ultrapassou 8 horas
        int compensableHours = gapWorkedHour - 8;
        double valueDailyOvertime = compensableHours >= 0 ? 8 * funcionario.valueWorkedHour : (8 + compensableHours) * funcionario.valueWorkedHour;

        // Verificar se ultrapassou 10 horas
        int overtime = compensableHours - 2;
        valueDailyOvertime += overtime >= 0 ? (funcionario.valueWorkedHour * 1.55) * 2 : (funcionario.valueWorkedHour * 1.55) * compensableHours;

        // Calcular o valor da diária
        valueDailyOvertime += overtime > 0 ? (funcionario.valueWorkedHour * 1.60) * overtime : (funcionario.valueWorkedHour * 1.55) * compensableHours;
        valueDailyOvertime += gapWorkedMinute > 0 ? valueDailyOvertime : 0;

        // Exibir valor
        System.out.println("O valor da diária é: R$ " + valueDailyOvertime);
    }
}