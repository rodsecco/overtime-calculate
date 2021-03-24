import java.util.Scanner;

public class Overtime {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Ponto de entrada
        System.out.print("Digite a hora de inicio: ");
        int startHour = sc.nextInt();
        System.out.print("Digite o minuto de inicio: ");
        int startMinute = sc.nextInt();

        // Ponto de saída
        System.out.print("Digite a hora de saída: ");
        int endHour = sc.nextInt();
        System.out.print("Digite o minuto de saída: ");
        int endMinute = sc.nextInt();

        // Valor da hora de trabalho
        System.out.print("Digite o valor da hora de trabalho: R$ ");
        double valueWorkedHour = sc.nextDouble();

        sc.close();

        // Diferença entre as horas
        int gapWorkedHour = endHour - startHour;
        int gapWorkedMinute = endMinute - startMinute;

        // Verificar se ultrapassou 8 horas
        int compensableHours = gapWorkedHour - 8;
        double valueDailyOvertime = compensableHours >= 0 ? 8 * valueWorkedHour : (8 + compensableHours) * valueWorkedHour;

        // Verificar se ultrapassou 10 horas
        int overtime = compensableHours - 2;
        valueDailyOvertime += overtime >= 0 ? (valueWorkedHour * 1.55) * 2 : (valueWorkedHour * 1.55) * compensableHours;

        // Calcular o valor da diária
        valueDailyOvertime += overtime > 0 ? (valueWorkedHour * 1.60) * overtime : (valueWorkedHour * 1.55) * compensableHours;
        valueDailyOvertime += gapWorkedMinute > 0 ? valueDailyOvertime : 0;

        // Exibir valor
        System.out.println("O valor da diária é: R$ " + valueDailyOvertime);
    }
}