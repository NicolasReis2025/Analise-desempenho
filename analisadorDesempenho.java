import java.util.Locale;
import java.util.Scanner;
import java.util.ArrayList;


public class Main{
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Analisador de desempenho ===");

        ArrayList<String> nomes = new ArrayList<>();
        ArrayList<Double> notas = new ArrayList<>();


        System.out.print("Quantos alunos: ");
        int qtdAlunos = sc.nextInt();

        for(int i=0; i < qtdAlunos; i++){
            System.out.println((i+1) + "# aluno: ");
            sc.nextLine();
            System.out.print("Nome: ");
            String nome = sc.nextLine();

            System.out.print("Nota: ");
            double nota = sc.nextDouble();
            nomes.add(nome);
            notas.add(nota);
        }

        System.out.println("=== Resultado ====");
        double media = calcularMedia(notas);
        System.out.printf("Media das notas inseridas:\t%.2f\n", media);
        System.out.println("-=-=-=-=-=-=-=-=-=-==-=-=-=\n");
        double variancia = calcularVariancia(notas);
        System.out.printf("Variância das notas inseridas:\t%.2f\n", variancia);
        System.out.println("-=-=-=-=-=-=-=-=-=-==-=-=-=\n");
        double desvioPadrao = calcularDesvioPadrao(notas);
        System.out.printf("Desvio padrão das notas inseridas:\t%.2f\n", desvioPadrao);
        System.out.println("-=-=-=-=-=-=-=-=-=-==-=-=-=\n");
        System.out.println("Alunos acima da média: ");
        for(int i=0; i < nomes.size(); i++){
            if(notas.get(i) > media){
                System.out.printf("Aluno:\t%s\nNota:\t%.2f\n", nomes.get(i), notas.get(i));
                System.out.println("--------------------------------------------");
            }
        }
        System.out.println("-=-=-=-=-=-=-=-=-=-==-=-=-=\n");
        System.out.println("Alunos abaixo da média: ");
        for(int i=0; i < nomes.size(); i++){
            if(notas.get(i) < media){
                System.out.printf("Aluno:\t%s\nNota:\t%.2f\n", nomes.get(i), notas.get(i));
                System.out.println("--------------------------------------------");
            }
        }
        System.out.println("-=-=-=-=-=-=-=-=-=-==-=-=-=\n");

        System.out.println("Alunos com nota máxima (10):");
        boolean encontrou = false;
        for(int i=0; i < notas.size(); i++){
            if(notas.get(i) == 10.0){
                System.out.printf("Aluno:\t%s\nNota:\t%.2f\n", nomes.get(i), notas.get(i));
                System.out.println("------------------------");
                encontrou = true;
            }
        }
        if(!encontrou){
            System.out.println("Nenhum aluno tirou nota máxima.");
        }

        sc.close();
    }

    public static double calcularMedia(ArrayList<Double> notas){
        int quantidadeElementos = notas.size();
        double total = 0.0;
        for(double i: notas){
            total += i;
        }
        return total / quantidadeElementos;
    }

    public static double calcularVariancia(ArrayList<Double> notas){
        double media = calcularMedia(notas);
        double variancia = 0.0;
        for(double i: notas){
            variancia += Math.pow(i - media, 2);
        }
        return variancia / (notas.size() - 1);
    }

    public static double calcularDesvioPadrao(ArrayList<Double> notas){
        return Math.pow(calcularVariancia(notas), 0.5);
    }

}
