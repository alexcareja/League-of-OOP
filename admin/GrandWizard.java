package admin;

import utils.Constants;
import angels.Angel;
import fileio.FileSystem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public final class GrandWizard implements Observer {
    private FileSystem fileSystem;

    public GrandWizard(final FileSystem fileSystem) {
        this.fileSystem = fileSystem;
    }


    @Override
    public void update(final Observable o, final Object arg) {
        ArrayList args = (ArrayList) arg;
        String action = (String) args.get(0);
        switch (action) {
            case Constants.SPAWN:
                try {
                    fileSystem.writeWord("Angel " + ((Angel) o).getAngelType()
                            + " was spawned at " + args.get(1) + " " + args.get(2));
                    fileSystem.writeNewLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case Constants.HELP:
                try {
                    fileSystem.writeWord(((Angel) o).getAngelType() + " helped "
                            + args.get(1) + " " + args.get(2));
                    fileSystem.writeNewLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case Constants.HIT:
                try {
                    fileSystem.writeWord(((Angel) o).getAngelType() + " hit "
                            + args.get(1) + " " + args.get(2));
                    fileSystem.writeNewLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case Constants.DIED:
                try {
                    fileSystem.writeWord("Player " + args.get(1) + " " + args.get(2)
                            + " was killed by " + args.get(3) + " " + args.get(4));
                    fileSystem.writeNewLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            default:
                break;
        }
    }
}
