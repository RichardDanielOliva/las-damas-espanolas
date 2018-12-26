public abstract class JuegoDeMesa{
	protected EstadoTablero [][] tablero;
	protected final int TAMANOTABLERO = 8;
	protected int auxBlancas, auxNegras;

	public void mostrar(){
		char auxChar= 'A';
		for (int a = 0; a < TAMANOTABLERO; a++) {
			if (a==0) System.out.println("  | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 |");
			for (int b = 0; b < TAMANOTABLERO; b++ ) {
				if (b==0) {
					System.out.print(auxChar + " | ");
					auxChar++;
					}
				if (tablero[a][b] == EstadoTablero.V) System.out.print(" ");
					else  System.out.print (tablero[a][b]);
				System.out.print(" | ");
			}
			System.out.println(" ");
		}
	}

	public void inicializar(){
		tablero = new EstadoTablero [TAMANOTABLERO][TAMANOTABLERO];
		auxBlancas = 8;
		auxNegras = 8;

		inicializarVacio();
		posicionarBlancas();
		posicionarNegras();


	}

	public void inicializarVacio(){
		for (int a = 0; a < TAMANOTABLERO; a++) {
			for (int b = 0; b < TAMANOTABLERO; b++ ) {
				tablero[a][b] = EstadoTablero.V;
			}
		}
	}

	public void posicionarBlancas(){
		for (int a = 0; a < 3; a++) {
			for (int b = 0; b < TAMANOTABLERO; b++) {
				if (a%2 == 0) {
					if (b % 2 == 0) tablero[a][b] = EstadoTablero.b;
				} else{
					if (b % 2 != 0) tablero[a][b] = EstadoTablero.b;
				}
			}
		}
	}

	public void posicionarNegras(){
		for (int a = (TAMANOTABLERO-1); a >4 ; a--) {
			for (int b = 0; b < TAMANOTABLERO; b++) {
				if (a%2 != 0) {
					if (b % 2 != 0) tablero[a][b] = EstadoTablero.n;
				} else{
					if (b % 2 == 0) tablero[a][b] = EstadoTablero.n;
				}
			}
		}
	}

	public void convertirADama(){
		for (int a = 0; a < TAMANOTABLERO; a++) {
			if (tablero[0][a] == EstadoTablero.n) tablero[0][a] = EstadoTablero.N;
			if (tablero[(TAMANOTABLERO-1)][a] == EstadoTablero.b) tablero[(TAMANOTABLERO-1)][a] = EstadoTablero.B;
		}
	}
}