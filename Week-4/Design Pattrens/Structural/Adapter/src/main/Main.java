package main;

import adapter.ArabicToEnglishAdapter;
import speaker.ArabicSpeaker;
import speaker.ArabicSpeakerImpl;
import speaker.EnglishSpeaker;
import speaker.EnglishSpeakerImpl;

public class Main {
    public static void main(String[] args) {
//        ArabicSpeaker arabicSpeaker = new ArabicSpeakerImpl();
//        EnglishSpeaker englishSpeaker = new EnglishSpeakerImpl();
//        arabicSpeaker.greeting();
//        englishSpeaker.greeting();
        
        // adapting english speaker to understand arabic speaker //
        EnglishSpeaker englishSpeaker1 = new ArabicToEnglishAdapter();
        englishSpeaker1.greeting();
    }
}