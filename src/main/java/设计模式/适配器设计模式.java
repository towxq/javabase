package 设计模式;

public class 适配器设计模式 {
    public static void main(String[] args){
        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play("mp3","asdada.mp3");
        audioPlayer.play("vlc","asdasdasd.vlc");
        audioPlayer.play("mp4","asdadad.mp4");
        audioPlayer.play("avi","asdsadad.avi");


        Target target220 = new Adapter220();
        ImportedMachine machine = new ImportedMachine();
        target220.Convert_110V();
        machine.work();
}
}


interface MediaPlayer{
    void play(String audioType,String fileNmae);
}

interface AdvanceMediaPlayer{
    void playVlc(String filename);
    void playMp4(String filename);
}

class VlaPlayer implements AdvanceMediaPlayer{

    public void playVlc(String filename) {
        System.out.println("play vlc file.name "+filename);
    }


    public void playMp4(String filename) {

    }
}

class Mp4Player implements AdvanceMediaPlayer{


    public void playVlc(String filename) {

    }


    public void playMp4(String filename) {
        System.out.println("play mp4 file.name"+filename);
    }
}


class MediaAdpter implements MediaPlayer{

    AdvanceMediaPlayer advanceMediaPlayer;

    public MediaAdpter(String audioType){
        if(audioType.equalsIgnoreCase("vlc")){
            advanceMediaPlayer = new VlaPlayer();
        }
        if (audioType.equalsIgnoreCase("mp4")){
            advanceMediaPlayer = new Mp4Player();
        }
    }


    public void play(String audioType, String fileNmae) {
        if (audioType.equalsIgnoreCase("vls")){
            advanceMediaPlayer.playVlc(fileNmae);
        }
        if (audioType.equalsIgnoreCase("mp4")){
            advanceMediaPlayer.playMp4(fileNmae);
        }
    }
}

class AudioPlayer implements MediaPlayer{
    MediaAdpter mediaAdpter;

    public void play(String audioType, String fileNmae) {
        if (audioType.equalsIgnoreCase("mp3")){
            System.out.println("play mp3 file.name"+fileNmae);
        }

        else if(audioType.equalsIgnoreCase("vls") || audioType.equalsIgnoreCase("mp4")){
            mediaAdpter = new MediaAdpter(audioType);
            mediaAdpter.play(audioType,fileNmae);
        }

        else {
            System.out.println("Invalid media ."+audioType + "formt not support");
        }
    }
}
interface Target{
    //220-->110
    void Convert_110V();
}

//原类
class PoerPort220{
    void Output_220(){

    }
}

//适配器
class Adapter220 extends PoerPort220 implements Target{

    public void Convert_110V() {
        this.Output_220();
    }
}

class ImportedMachine{
    void work(){
        System.out.println("work");
    }
}