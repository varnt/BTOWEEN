package model;

import java.util.ArrayList;

public class Musica {

	private static final double aumenta10porcento = 1.1, DOBRA_VOLUME = 2.0;
	private MusicFrame atualFrame;
	private ArrayList<MusicFrame> listaFrames;
	private static final int A = 69, B = 71, C = 60, D = 62, E = 64, F = 65, G = 67, SILENCIO = 0, ESPACO = 32,
			HARPSICHORD = 7;
	private static final int OITAVA_DEFAULT = 4;

	public ArrayList<MusicFrame> getListaFrames() {
		return this.listaFrames;
	}

	public Musica() {
		this.atualFrame = new MusicFrame();
		this.listaFrames = new ArrayList<MusicFrame>();
	}

	public Musica(MusicFrame atualFrame) {

		this.atualFrame = atualFrame;
		this.listaFrames.add(atualFrame);
	}

	public void adicionaNovoFrame(MusicFrame novoFrame) {

		this.listaFrames.add(novoFrame);
		this.atualFrame = novoFrame;

	}

	public MusicFrame frameAtual() {

		return this.atualFrame;

	}

	public int tamanhoLista() {
		return this.listaFrames.size();
	}

	public void mudaNota(int codigoNovaNota) {
		final MusicFrame novoFrame;
		final Nota novaNota = new Nota(codigoNovaNota);
		novoFrame = new MusicFrame(novaNota, this.atualFrame);
		this.adicionaNovoFrame(novoFrame);
		this.atualFrame = novoFrame;
		System.out.println(novoFrame.getNota() + " adicionada\n");
	}

	public void mudaOitava(int codigoNovaOitava) {
		final MusicFrame novoFrame;
		final Oitava novaOitava = new Oitava(codigoNovaOitava);
		novoFrame = new MusicFrame(novaOitava, this.atualFrame);
		this.adicionaNovoFrame(novoFrame);
		this.atualFrame = novoFrame;
		System.out.println(novoFrame.getOitava() + "adicionada\n");
	}

	public void mudaInstrumento(int codigoNovoInstrumento) {
		final MusicFrame novoFrame;
		final Instrumento novoInstrumento = new Instrumento(codigoNovoInstrumento);
		novoFrame = new MusicFrame(novoInstrumento, this.atualFrame);
		this.adicionaNovoFrame(novoFrame);
		this.atualFrame = novoFrame;
		System.out.println(novoFrame.getCodigotInstrumento() + "adicionado\n");
	}

	public void mudaBPM(int codigoNovoBPM) {
		final MusicFrame novoFrame;
		final BPM novoBPM = new BPM(codigoNovoBPM);
		novoFrame = new MusicFrame(novoBPM, this.atualFrame);
		this.adicionaNovoFrame(novoFrame);
		this.atualFrame = novoFrame;
		System.out.println(novoFrame.getBPM() + "adicionado\n");

	}
	
	public void mudaVolume(double codigoNovoVolume) {
		final MusicFrame novoFrame;
		final Volume novoVolume = new Volume(codigoNovoVolume);
		novoFrame = new MusicFrame(novoVolume, this.atualFrame);
		this.adicionaNovoFrame(novoFrame);
		this.atualFrame = novoFrame;
		System.out.println(novoFrame.getCodigoVolume() + "adicionado\n");
	}

	public void manipulaMusica(char caractereEntrada, char caractereAnterior) {

				
		if (this.ehNotaMinuscula(caractereEntrada)) {
			if (this.ehNota(caractereAnterior))
				this.repeteFrame();
			else
				this.mudaNota(SILENCIO);
			
			return;
		}
		
		if(this.ehVogalNaoNota(caractereEntrada)){
			this.mudaVolume(this.atualFrame.getCodigoVolume()*aumenta10porcento);	
			return;
		}
		
		if(this.ehConsoanteNaoNota(caractereEntrada)) {
			if (this.ehNota(caractereAnterior))
				this.repeteFrame();
			else
				this.mudaNota(SILENCIO);
			
			return;
		}
		
		if(this.ehNumero(caractereEntrada)) {
			this.mudaInstrumento(this.atualFrame.getCodigotInstrumento() + Character.getNumericValue(caractereEntrada));
		}
		
		if(caractereEntrada == '?' || caractereEntrada == '.') {
			if(this.atualFrame.getCodigoOitava()<8){
				this.mudaOitava(this.atualFrame.getCodigoOitava()+1);
			}
			
			else {
				this.mudaOitava(OITAVA_DEFAULT);
			}
			
		}

		switch (caractereEntrada) {
		case 'A':
			this.mudaNota(A);
			break;

		case 'B':
			this.mudaNota(B);
			break;

		case 'C':
			this.mudaNota(C);
			break;

		case 'D':
			this.mudaNota(D);
			break;

		case 'E':
			this.mudaNota(E);
			break;

		case 'F':
			this.mudaNota(F);
			break;

		case 'G':
			this.mudaNota(G);
			break;
			
		case ESPACO:
			this.mudaVolume(this.atualFrame.getCodigoVolume()*DOBRA_VOLUME);
			break;

		case '!':
			this.mudaInstrumento(HARPSICHORD);
			break;

		}

	}

	private boolean ehNumero(char caractere) {
		if(caractere>='0' && caractere <='9') {
			return true;
		}
		
		else
			return false;
	}

	private boolean ehConsoanteNaoNota(char caractere){
		if((caractere >= 'H' && caractere <= 'Z') || (caractere >= 'h' && caractere <= 'z')) {
			if(caractere != 'I' && caractere != 'i' && caractere != 'O' && caractere!='o' && caractere !='U' && caractere != 'u')
				return true;
			else
				return false;
		}
		else
		return false;
	}

	private boolean ehVogalNaoNota(char caractere) {
		if(caractere == 'i' || caractere == 'I' || caractere == 'o' || caractere == 'O' || caractere == 'u' || caractere == 'U')
			return true;
		else
			return false;
	}

	private boolean ehNota(char caractere) {
		if (caractere == A || caractere == B || caractere == C || caractere == D || caractere == E || caractere == F|| caractere == G)
			return true;

		else
			return false;
	}

	private boolean ehNotaMinuscula(char caractere) {
		if (caractere == 'a' || caractere == 'b' || caractere == 'c' || caractere == 'd' || caractere == 'e'
				|| caractere == 'f' || caractere == 'g')
			return true;

		else
			return false;
	}

	private void repeteFrame() {
		this.adicionaNovoFrame(this.atualFrame);
		System.out.println("Frame duplicado");
	}

}
