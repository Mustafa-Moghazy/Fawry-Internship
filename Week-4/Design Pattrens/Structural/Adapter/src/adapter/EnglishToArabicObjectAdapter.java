package adapter;

import speaker.ArabicSpeaker;
import speaker.ArabicSpeakerImpl;
import speaker.EnglishSpeaker;
import speaker.EnglishSpeakerImpl;

public class EnglishToArabicObjectAdapter implements ArabicSpeaker {
    EnglishSpeaker englishSpeaker = new EnglishSpeakerImpl();
    public EnglishToArabicObjectAdapter(EnglishSpeaker englishSpeaker){
        this.englishSpeaker = englishSpeaker;
    }
    @Override
    public void greeting() {
        englishSpeaker.greeting();
    }
}
