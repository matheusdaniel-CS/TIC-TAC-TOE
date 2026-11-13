package jogovelha;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;

//Classe responsável por todos os efeitos sonoros e a música de fundo do jogo
public class SonsJogo {

    private Clip musicaFundo;

    //Toca os efeitos sonoros do jogo pelo diretório do arquivo
    public void tocarSom(String caminho) {
        try {

            AudioInputStream audio = AudioSystem.getAudioInputStream(
                    getClass().getResource(caminho)
            );
            Clip clip = AudioSystem.getClip();
            clip.open(audio);
            audio.close();
            clip.start();
        } catch (Exception e) {
            System.out.println("Pra se acaso der erro, aparecer o erro aqui:" + e.getMessage());
        }
    }

    //Toca a música de fundo do jogo em loop
    public void tocarMusicaFundo() {
        try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(
                    getClass().getResource("/sons/musicaJogo.wav")
            );
            musicaFundo = AudioSystem.getClip();
            musicaFundo.open(audio);
            audio.close();
            musicaFundo.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            System.out.println("Pra se acaso der erro, aparecer o erro aqui:" + e.getMessage());
        }
    }
}
