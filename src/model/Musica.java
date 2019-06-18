package model;

import java.util.ArrayList;

public class Musica {

	private MusicFrame atualFrame;
	private ArrayList<MusicFrame> listaFrames;
	private static final int A = 69, B = 71, C = 60, D = 62, E = 64, F = 65, G = 67, SILENCIO = 0, ESPACO = 32,
			HARPSICHORD = 7;

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
		System.out.println(novoFrame.getInstrumento() + "adicionado\n");

	}

	public void mudaBPM(int codigoNovoBPM) {
		final MusicFrame novoFrame;
		final BPM novoBPM = new BPM(codigoNovoBPM);
		novoFrame = new MusicFrame(novoBPM, this.atualFrame);
		this.adicionaNovoFrame(novoFrame);
		this.atualFrame = novoFrame;
		System.out.println(novoFrame.getBPM() + "adicionado\n");

	}

	// IMPLEMENTARAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
	private void dobraVolume() {

	}

	public void manipulaMusica(char caractereEntrada, char caractereAnterior) {

		if (this.ehNotaMinuscula(caractereEntrada)) {
			if (this.EhNota(caractereAnterior))
				this.repeteFrame();
			else
				this.mudaNota(SILENCIO);
			
			return;
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

		/*
		 * case 'a': if(caractereAnterior=='A') { this.mudaNota(A); }
		 * 
		 * else this.mudaNota(SILENCIO); break;
		 * 
		 * case 'b': if(caractereAnterior == 'B') this.mudaNota(B); else
		 * this.mudaNota(SILENCIO); break;
		 * 
		 * case 'c': if(caractereAnterior == 'C') this.mudaNota(C); else
		 * this.mudaNota(SILENCIO); break;
		 * 
		 * case 'd': if(caractereAnterior == 'D') this.repeteFrame(); else
		 * this.mudaNota(SILENCIO); break;
		 * 
		 * case 'e': if(caractereAnterior == 'E') this.mudaNota(E); else
		 * this.mudaNota(SILENCIO); break;
		 * 
		 * case 'f': if(caractereAnterior == 'F') this.mudaNota(F); else
		 * this.mudaNota(SILENCIO); break;
		 * 
		 * case 'g': if(caractereAnterior == 'G') this.mudaNota(G); else
		 * this.mudaNota(SILENCIO); break;
		 */

		case ESPACO:
			this.dobraVolume();
			break;

		case '!':
			this.mudaInstrumento(HARPSICHORD);
			break;

		}

	}

	private boolean EhNota(char caracter) {
		if (caracter == A || caracter == B || caracter == C || caracter == D || caracter == E || caracter == F|| caracter == G)
			return true;

		else
			return false;
	}

	private boolean ehNotaMinuscula(char caracter) {
		if (caracter == 'a' || caracter == 'b' || caracter == 'c' || caracter == 'd' || caracter == 'e'
				|| caracter == 'f' || caracter == 'g')
			return true;

		else
			return false;
	}

	private void repeteFrame() {
		this.adicionaNovoFrame(this.atualFrame);
		System.out.println("Frame duplicado");
	}

}
