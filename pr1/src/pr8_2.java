import java.util.Iterator;
import java.util.NoSuchElementException;

//паттерн итератор
public class pr8_2 {}

    interface BookPart {
        String getBookPart();
    }

    class Contents implements BookPart {

        private String part;

        public Contents(String part) {
            this.part = part;
        }

        @Override
        public String getBookPart() {
            return part;
        }
    }

     class Foreword implements BookPart {

        private String part;

        public Foreword(String part) {
            this.part = part;
        }

        @Override
        public String getBookPart() {
            return part;
        }
    }

     class MainPart implements BookPart {

        private String part;

        public MainPart(String part) {
            this.part = part;
        }

        @Override
        public String getBookPart() {
            return part;
        }
    }

    class Afterword implements BookPart {

        private String part;

        public Afterword(String part) {
            this.part = part;
        }

        @Override
        public String getBookPart() {
            return part;
        }
    }

    class Book implements Iterable<BookPart>{

        private Contents contents;
        private Foreword foreword;
        private MainPart mainPart;
        private Afterword afterword;
        private int partCount;

        public Book(Contents contents, Foreword foreword, MainPart mainPart, Afterword afterword, int partCount) {
            this.contents = contents;
            this.foreword = foreword;
            this.mainPart = mainPart;
            this.afterword = afterword;
            this.partCount = 4;
        }

        public Book(Contents contents, Foreword foreword, MainPart mainPart, int partCount) {
            this.contents = contents;
            this.foreword = foreword;
            this.mainPart = mainPart;
            this.partCount = 3;
        }

        public Book(Contents contents, MainPart mainPart, int partCount) {
            this.contents = contents;
            this.mainPart = mainPart;
            this.partCount = 2;
        }

        public Book(MainPart mainPart, int partCount) {
            this.mainPart = mainPart;
            this.partCount = 1;
        }

        public Contents getContents() {
            return contents;
        }

        public Foreword getForeword() {
            return foreword;
        }

        public MainPart getMainPart() {
            return mainPart;
        }

        public Afterword getAfterword() {
            return afterword;
        }

        public int getPartCount() {
            return partCount;
        }

        public boolean hasContents() {
            return this.contents != null;
        }

        public boolean hasForeword() {
            return this.foreword != null;
        }

        public boolean hasMainPart() {
            return this.mainPart != null;
        }

        public boolean hasAfterword() {
            return this.afterword != null;
        }
        @Override
        public  Iterator<BookPart>iterator() {
            return new BookIterator(this);
        }
    }
    class BookIterator implements Iterator<BookPart> {

        private Book book;
        private int bookPartsCount;

        public BookIterator(Book bookParts) {
            this.book = bookParts;
            this.bookPartsCount = bookParts.getPartCount();
        }

        public void BookIterator(Book book) {
            this.book = book;
            this.bookPartsCount = book.getPartCount();
        }

        @Override
        public boolean hasNext() {
            if (bookPartsCount == 4) {
                return book.hasContents() || book.hasMainPart() || book.hasAfterword() || book.hasForeword();
            } else if (bookPartsCount == 3) {
                return book.hasContents() || book.hasMainPart() || book.hasForeword();
            } else if (bookPartsCount == 2) {
                return book.hasContents() || book.hasMainPart() ;
            } else if (bookPartsCount == 1) {
                return book.hasMainPart();
            }
            return false;
        }

        @Override
        public BookPart next() throws NoSuchElementException {
            if (bookPartsCount <= 0) {
                throw new NoSuchElementException("No more elements in this book!");
            }

            try {
                if (bookPartsCount == 4) {
                    return book.getAfterword();
                }
                if (bookPartsCount == 3) {
                    return book.getForeword();
                }
                if (bookPartsCount == 2) {
                    return book.getContents();
                }
                return book.getMainPart();
            } finally {
                bookPartsCount--;
            }
        }
    }
    class Test{
    public static void main(String[] args) {
        Book book = new Book(new Contents("оглавление"), new Foreword("предисловие"),
                new MainPart("главная часть"), new Afterword("послесловие"), 4);

        Iterator iter = book.iterator();
        int i =0;
        while (iter.hasNext()) {
            System.out.print(i);
            i++;
            BookPart part = (BookPart) iter.next();
            System.out.println(part.getClass() + ": " + part.getBookPart());
        }
    }
    }

