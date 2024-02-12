package adapter;

import speaker.EnglishSpeaker;
import speaker.ArabicSpeakerImpl;

public class ArabicToEnglishAdapter extends ArabicSpeakerImpl implements EnglishSpeaker {
    @Override
    public void greeting(){
        super.greeting();
    }

}
