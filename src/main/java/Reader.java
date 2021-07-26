import java.util.Scanner;

//singleton scanner class
public class Reader {

        private Scanner reader;
        private static Reader singleton = null;
        private boolean alreadyClosed;

        private Reader() {
            alreadyClosed = false;
            reader = new Scanner(System.in).useDelimiter("\\n");
        }

        public static Reader getInstance() {
            if(singleton == null) {
                singleton = new Reader();
            }
            return singleton;
        }

        public int nextInt() throws IllegalStateException {
            if(!alreadyClosed) {
                return reader.nextInt();
            }
            throw new IllegalStateException(); //Custom exception
        }

        public double nextDouble() throws IllegalStateException {
            if(!alreadyClosed) {
                return reader.nextDouble();
            }
            throw new IllegalStateException();
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
}

