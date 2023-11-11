package seminar6.presentation.queries.views;

import seminar6.application.interfaces.NotesPresenter;
import seminar6.domain.Note;

import java.util.Collection;
import java.util.Scanner;

public class NotesConsolePresenter implements NotesPresenter {
    @Override
    public void printAll(Collection<Note> notes) {
        for (Note note : notes){
            System.out.println(note);
        }
    }

    @Override
    public void printRecord() {
        Scanner in = new Scanner(System.in);
        System.out.print("Input your data: ");
        String rec = in.nextLine();
        System.out.println(rec);
        in.close();
    }
}
