package lab;


import javax.sound.midi.*;

public class JavaSoundTestDrive{

    public static void main(String[] args) { 
      try{
        
        Synthesizer midiSynth = MidiSystem.getSynthesizer(); 
        midiSynth.open();

        //carrega os canais e instrumento padrao
        Instrument[] instr = midiSynth.getDefaultSoundbank().getInstruments();
        MidiChannel[] mChannels = midiSynth.getChannels();

        midiSynth.loadInstrument(instr[0]);//seleciona instrumento


        mChannels[0].noteOn(69, 100);//no canal 0, toca a nota 60 com velocidade 100
        try { Thread.sleep(1000); // espera em ms
        } catch( InterruptedException e ) { }
        mChannels[0].noteOff(69);//desliga a nota 60


      } catch (MidiUnavailableException e) {}
   }

}    
//A4 = 69 = 440Hz
//etc