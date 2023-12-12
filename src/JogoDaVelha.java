import java.util.Scanner;

public class JogoDaVelha {

    public static void main(String[] args) {
        
        Campo[][] velha = new Campo[3][3];
        char simboloAtual = 'X';//guarda o simbolo da vez
        Boolean game = true; //indica se o jogo está acontacendo ou não
        String vitoria = "";
        Scanner scan = new Scanner(System.in);

        iniciaJogo(velha);

        while(game){
            desenhaJogo(velha);

            vitoria = verificaVitoria(velha);

            if(!vitoria.equals("")){
                System.out.println("Jogador "+ vitoria+ " venceu.");
                game = false;
                break;
            }
            try {
                if (verificarJogada(velha, jogar(scan, simboloAtual), simboloAtual)) {
                    if (simboloAtual == 'X') {
                        simboloAtual = 'O';
                    }else{
                        simboloAtual = 'X';
                    }
                }
            } catch (Exception e) {
                System.out.println("ERRO durante a execução do jogo" + e);
            }
        }
        System.out.println("Fim de Jogo");
    }

    public static void desenhaJogo(Campo[][] velha){
        limparTela();
        System.out.println(" 0    1    2");
        System.err.printf("0 %c | %c | %c %n", velha[0][0].getSimbolo(), velha[0][1].getSimbolo(), velha[0][2].getSimbolo());
        System.out.println(" ------------");
        System.err.printf("1 %c | %c | %c %n", velha[1][0].getSimbolo(), velha[1][1].getSimbolo(), velha[1][2].getSimbolo());
        System.out.println(" ------------");
        System.err.printf("2 %c | %c | %c %n", velha[2][0].getSimbolo(), velha[2][1].getSimbolo(), velha[2][2].getSimbolo());

    }

    public static void limparTela(){
        for(int cont = 0; cont < 200; cont++){
            System.out.println("");
        }
    }

    public static int[] jogar(Scanner scan, char simboloAtual){
        int ponto[] = new int[2];
        System.out.println("Quem joga: " + simboloAtual);
        System.out.println("Informe a linha:");
        ponto[0] = scan.nextInt();
        System.out.println("Informe a coluna:");
        ponto[1] = scan.nextInt();

        return ponto;
    }
    
    public static Boolean verificarJogada(Campo[][] velha, int ponto[], char simboloAtual){
        if(velha[ponto[0]][ponto[1]].getSimbolo() == ' '){
            velha[ponto[0]][ponto[1]].setSimbolo(simboloAtual);
            return true;
        }else{
            return false;
        }
    }

    public static void iniciaJogo(Campo[][] velha){
        for(int linha = 0; linha < 3; linha++){
            for(int coluna = 0; coluna < 3; coluna++){
                velha[linha][coluna] = new Campo();
            }
        }
    }

    public static String verificaVitoria(Campo[][] velha) {
        for(int i=0;i<3;i++){
			if((velha[i][0].getSimbolo()=='X' && velha[i][1].getSimbolo()=='X' && velha[i][2].getSimbolo()=='X')||(velha[i][0].getSimbolo()=='O' && velha[i][1].getSimbolo()=='O' && velha[i][2].getSimbolo()=='O')){
				return Character.toString(velha[i][0].getSimbolo());
                
			}
		}
		for(int i=0;i<3;i++){
			if((velha[0][i].getSimbolo()=='X' && velha[1][i].getSimbolo()=='X' && velha[2][i].getSimbolo()=='X')||(velha[0][i].getSimbolo()=='O' && velha[1][i].getSimbolo()=='O' && velha[2][i].getSimbolo()=='O')){
				return Character.toString(velha[0][i].getSimbolo());
			}
		}
		if((velha[0][0].getSimbolo()=='X' && velha[1][1].getSimbolo()=='X' && velha[2][2].getSimbolo()=='X')||(velha[0][2].getSimbolo()=='O' && velha[1][1].getSimbolo()=='O' && velha[2][0].getSimbolo()=='O')){
			return Character.toString(velha[0][0].getSimbolo());
		}
        return "";
    } 
}
