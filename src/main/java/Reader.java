import java.util.Scanner;

//singleton scanner class to avoid scanner stream closing issues

public class Reader {

        private Scanner reader;
        private static Reader singleton = null;
        private boolean alreadyClosed;

        private Reader() {
            alreadyClosed = false;
            reader = new Scanner(System.in).useDelimiter("\\n");
        }

        //fetch instance of reader
        public static Reader getInstance() {
            if(singleton == null) {
                singleton = new Reader();
            }
            return singleton;
        }

        public String nextLine() throws IllegalStateException {
            if(!alreadyClosed) {
                if(reader.hasNext()) {
                    return reader.nextLine();
                }else return getInstance().nextLine();
            }
            throw new IllegalStateException();
        }

    public void close() {
            alreadyClosed = true;
            reader.close();
        }

    public boolean isAlreadyClosed() {
        return alreadyClosed;
    }
}

