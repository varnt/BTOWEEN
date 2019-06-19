package model;

import java.util.ArrayList;

import org.jfugue.player.Player;

public class Musica {

	private MusicFrame atualFrame;
	private ArrayList<MusicFrame> listaFrames;
	private Player player;

	private static final String A = "69", B = "71", C = "60", D = "62", E = "64", F = "65", G = "67";
	private static final double aumenta10porcento = 1.1;
	private static final String SILENCIO = "0";
	private static final double DOBRA_VOLUME = 2.0;
	private static final String HARPSICHORD = "7";
	private static final String OITAVA_DEFAULT = "4";
	private static final String TUBULAR_BELLS = "15";
	private static final String PAN_FLUTE = "76";
	private static final String CHURCH_ORGAN = "20";
	private static final int ESPACO = 32;
	private static final int MODIFICADOR_DEFAULT = 0;

	public ArrayList<MusicFrame> getListaFrames() {
		return this.listaFrames;
	}

	public Musica() {
		this.atualFrame = new MusicFrame();
		this.listaFrames = new ArrayList<MusicFrame>();
		this.player = new Player();
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

	public void mudaNota(String codigoNovaNota) {
		final MusicFrame novoFrame;
		final Nota novaNota = new Nota(codigoNovaNota);
		novoFrame = new MusicFrame(novaNota, this.atualFrame);
		this.adicionaNovoFrame(novoFrame);
		this.atualFrame = novoFrame;

		Nota notaAuxiliar = atualFrame.getCodigoNota();

		System.out.println(notaAuxiliar.getCodigoNota() + " adicionada\n");

		//novaNota.tocaNota(novaNota.getCodigoNota(), this.player);
		return;

	}

	public void mudaOitava(String oitava, int modificadorOitava) {
		final MusicFrame novoFrame;
		final Oitava novaOitava = new Oitava(oitava);
		novaOitava.setcodigoModificadordeOitava(modificadorOitava);
		novoFrame = new MusicFrame(novaOitava, this.atualFrame);
		this.adicionaNovoFrame(novoFrame);
		this.atualFrame = novoFrame;

		System.out.println(novoFrame.getOitava() + "adicionada\n");
	}

	public void mudaInstrumento(String codigoNovoInstrumento) {
		final MusicFrame novoFrame;
		final Instrumento novoInstrumento = new Instrumento(codigoNovoInstrumento);
		novoFrame = new MusicFrame(novoInstrumento, this.atualFrame);
		this.adicionaNovoFrame(novoFrame);
		this.atualFrame = novoFrame;
		System.out.println(novoFrame.getCodigotInstrumento() + "adicionado\n");
	}

	public void mudaBPM(String codigoNovoBPM) {
		final MusicFrame novoFrame;
		final BPM novoBPM = new BPM(codigoNovoBPM);
		novoFrame = new MusicFrame(novoBPM, this.atualFrame);
		this.adicionaNovoFrame(novoFrame);
		this.atualFrame = novoFrame;
		System.out.println(novoFrame.getBPM() + "adicionado\n");

	}

	public void mudaVolume(String volume) {

		final MusicFrame novoFrame;
		final Volume novoVolume = new Volume(volume);
		novoFrame = new MusicFrame(novoVolume, this.atualFrame);
		this.adicionaNovoFrame(novoFrame);
		this.atualFrame = novoFrame;

		System.out.println(novoFrame.getCodigoVolume() + "adicionado\n");
	}
	
	public void executaFrameAtual() {
		this.atualFrame.executaFrameMusic(this.player);
	}

	public void manipulaMusica(char caractereEntrada, char caractereAnterior) {

		if (this.ehNotaMinuscula(caractereEntrada)) {
			if (this.ehNota(caractereAnterior))
				this.repeteFrame();
			else
				this.mudaNota(SILENCIO);

			return;
		}

		if (this.ehVogalNaoNota(caractereEntrada)) {
			this.mudaVolume(Double.toString(Integer.parseInt(this.atualFrame.getCodigoVolume()) * aumenta10porcento));
			return;
		}

		if (this.ehConsoanteNaoNota(caractereEntrada)) {
			if (this.ehNota(caractereAnterior))
				this.repeteFrame();
			else
				this.mudaNota(SILENCIO);

			return;
		}

		if (this.ehNumero(caractereEntrada)) {
			this.mudaInstrumento(Integer.toString(Integer.parseInt(this.atualFrame.getCodigotInstrumento())
					+ Character.getNumericValue(caractereEntrada)));
		}

		if (caractereEntrada == '?' || caractereEntrada == '.') {
			if (Integer.parseInt(this.atualFrame.getCodigoOitava()) < 8) {
				this.mudaOitava(Integer.toString(Integer.parseInt(this.atualFrame.getCodigoOitava()) + 1),
						this.atualFrame.getcodigoModificadorOitava() + 12);

			}

			else {
				this.mudaOitava(OITAVA_DEFAULT, MODIFICADOR_DEFAULT);
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
			this.mudaVolume(Double.toString(Double.parseDouble(this.atualFrame.getCodigoVolume()) * DOBRA_VOLUME));
			// this.dobraVolume();
			break;

		case '!':
			this.mudaInstrumento(HARPSICHORD);
			break;

		case 10:
			this.mudaInstrumento(TUBULAR_BELLS);
			break;

		case ';':
			this.mudaInstrumento(PAN_FLUTE);
			break;

		case ',':
			this.mudaInstrumento(CHURCH_ORGAN);
			break;

		default:
			if (this.ehNota(caractereAnterior))
				this.repeteFrame();
			else
				this.mudaNota(SILENCIO);
			break;
		}

		return;

	}

	private boolean ehNumero(char caractere) {
		if (caractere >= '0' && caractere <= '9') {
			return true;
		}

		else
			return false;
	}

	private boolean ehConsoanteNaoNota(char caractere) {
		if ((caractere >= 'H' && caractere <= 'Z') || (caractere >= 'h' && caractere <= 'z')) {
			if (caractere != 'I' && caractere != 'i' && caractere != 'O' && caractere != 'o' && caractere != 'U'
					&& caractere != 'u')
				return true;
			else
				return false;
		} else
			return false;
	}

	private boolean ehVogalNaoNota(char caractere) {
		if (caractere == 'i' || caractere == 'I' || caractere == 'o' || caractere == 'O' || caractere == 'u'
				|| caractere == 'U')
			return true;
		else
			return false;
	}

	private boolean ehNota(char caractere) {
		if (caractere == 'A' || caractere == 'B' || caractere == 'C' || caractere == 'D' || caractere == 'E'
				|| caractere == 'F' || caractere == 'G')
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
